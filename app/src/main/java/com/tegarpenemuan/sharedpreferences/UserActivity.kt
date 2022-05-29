package com.tegarpenemuan.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tegarpenemuan.sharedpreferences.DataStorePreferenceManager.pref
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        textUsername.text = applicationContext.pref().getPrefUsername()

        buttonLogout.setOnClickListener {
            applicationContext.pref().clearPref()
            moveIntent()
            //showMessage("Keluar")
            val keluar = applicationContext.pref().getPrefLogin()
            val username = applicationContext.pref().getPrefUsername()
            val password = applicationContext.pref().getPrefPassword()
            showMessage("Username: $username dan Password: $password serta Nilai: $keluar")
        }

        val username = applicationContext.pref().getPrefUsername()
        val password = applicationContext.pref().getPrefPassword()
        val keluar = applicationContext.pref().getPrefLogin()
        dataTampil.text = username + " dan " + password + " Nilai $keluar"
    }

    private fun showMessage(message:String) {
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }

    private fun moveIntent(){
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}