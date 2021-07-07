package com.example.homework2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

            // Хард код. Логин - Ника, пароль - 1234

        btEnter.setOnClickListener {
            if (edLogin.text.toString() == "Ника" && edPassword.text.toString()=="1234") {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            } else{
                Snackbar.make(btEnter, R.string.help, 5000)
                    .show()
            }
        }


        Glide.with(this).load(R.drawable.icons8_dog3).into(ivAnimDog);
        btEnter


    }
}