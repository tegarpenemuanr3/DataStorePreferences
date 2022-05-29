package com.tegarpenemuan.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tegarpenemuan.sharedpreferences.DataStorePreferenceManager.pref
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(applicationContext.pref().getPrefLogin() == false) {

        } else {
            moveIntent()
        }

        buttonLogin.setOnClickListener {
            if(editUsername.text.isNotEmpty() && editPassword.text.isNotEmpty()) {
                saveDataStore(editUsername.text.toString(),editPassword.text.toString())
                applicationContext.pref().setPrefLogin(true)
                showMessage("Berhasil Masuk")
                moveIntent()
            }
        }
    }

    private fun moveIntent(){
        startActivity(Intent(this,UserActivity::class.java))
        finish()
    }

    private fun saveDataStore(username:String,password:String) {
        applicationContext.pref().setPrefUsername(username)
        applicationContext.pref().setPrefPassword(password)
    }

    private fun showMessage(message:String) {
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }
}