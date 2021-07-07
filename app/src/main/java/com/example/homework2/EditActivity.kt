package com.example.homework2

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        supportActionBar?.hide()



        btEditEditAct.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name",edNameDog.text.toString())
            intent.putExtra("city","Город: ${edCity.text.toString()}")
            intent.putExtra("age","Возраст  ${edAge.text.toString()}")
            intent.putExtra("poroda","Порода  ${edPoroda.text.toString()}")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}