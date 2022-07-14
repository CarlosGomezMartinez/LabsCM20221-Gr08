package co.edu.udea.compumovil.gr08_20221.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ContactDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
        onClickNextButtonContactData()
    }

    private fun onClickNextButtonContactData(){
        val nextButton2: Button = findViewById(R.id.button_next2)

        //Campos de la actividad
        val phone : EditText = findViewById(R.id.textInput_phone)
        val email : EditText = findViewById(R.id.textInput_email)
        val country : EditText = findViewById(R.id.textInput_country)
        val city : EditText = findViewById(R.id.textInput_city)
        val address : EditText = findViewById(R.id.textInput_address)

        //Campos que llegan en el intent
        val bundle = intent.extras
        val name = bundle?.getString("name")
        val gender = bundle?.getString("gender")
        val birthdate = bundle?.getString("birthdate")
        val schoolarGrade = bundle?.getString("schoolarGrade")

        nextButton2.setOnClickListener {
            if (phone.text.isNotEmpty() && email.text.isNotEmpty() && country.text.isNotEmpty()){
                Log.d("*", "INFORMACION PERSONAL: ")
                Log.d("Nombre completo: ", name.toString())
                Log.d("Género: ", gender.toString())
                Log.d("Nació el: ", birthdate.toString())
                Log.d("Grado de escolaridad: ", schoolarGrade.toString())
                Log.d("*", "INFORMACION DE CONTACTO")
                Log.d("Teléfono: ", phone.text.toString())
                Log.d("Dirección: ", address.text.toString())
                Log.d("Email: ", email.text.toString())
                Log.d("País: ", country.text.toString())
                Log.d("Ciudad: ", city.text.toString())
            } else {
                fieldsError()
            }
        }
    }

    private fun fieldsError() {
        Toast.makeText(this, "Existen campos obligatorios sin llenar", Toast.LENGTH_LONG).show()
    }
}