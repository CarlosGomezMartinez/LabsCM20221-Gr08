package co.edu.udea.compumovil.gr08_20221.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PersonalDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_activity)

        findViewById<Button>(R.id.button_next).setOnClickListener {
            val intent = Intent(this, ContactDataActivity::class.java)
            startActivity(intent)
        }
    }
}