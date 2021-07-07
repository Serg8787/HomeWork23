package com.example.homework2

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val PICK_IMAGE = 100
    lateinit var bitmap:Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        ivAvatar.setOnClickListener {
            val intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent,"select picture"),PICK_IMAGE)
        }

        btEditMainAct.setOnClickListener {
            var intent = Intent(this, EditActivity::class.java)
            startActivityForResult(intent, 3)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 3) {
            tvName.text = data?.getStringExtra("name")
            tvCity.text = data?.getStringExtra("city")
            tvAge.text = data?.getStringExtra("age")
            tvPoroda.text = data?.getStringExtra("poroda")
        } else if(requestCode== PICK_IMAGE && resultCode== RESULT_OK) {
            val imageUri = data?.data
            bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)

            ivAvatar.setImageBitmap(bitmap)
        }

    }
}