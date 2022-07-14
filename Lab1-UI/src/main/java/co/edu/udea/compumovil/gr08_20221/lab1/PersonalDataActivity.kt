package co.edu.udea.compumovil.gr08_20221.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isNotEmpty

class PersonalDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_activity)
        onClickNextButtonPersonalData()
    }

    private fun onClickNextButtonPersonalData(){
        val nextButton : Button = findViewById(R.id.button_next)

        //Campos para el nombre
        val firstName : EditText = findViewById(R.id.textInput_firstname)
        val lastName : EditText = findViewById(R.id.textInput_lastname)
        val fullName : String = firstName.text.toString() + " " + lastName.text.toString()

        //Verificacion de los radioButton
        val radioMale : RadioButton = findViewById(R.id.radio_male)
        val radioFemale : RadioButton = findViewById(R.id.radio_female)
        val gMale = radioMale.isChecked
        val gFemale = radioFemale.isChecked
        lateinit var gender: String
        if(gMale){
            gender = "Masculino"
        }  else if (gFemale) {
            gender = "Femenino"
        } else {
            gender = "No especificado"
        }

        //Seleccion de nivel de escolaridad
        val schoolarGrade : Spinner = findViewById(R.id.spinner_school_grade)
        val grade: String = schoolarGrade.selectedItem.toString()

        //Seleccion de fecha de nacimiento
        val birthDate : DatePicker = findViewById(R.id.picker_date_birth)
        val birthYear = birthDate.year
        val birthMonth = birthDate.month
        val birthDay = birthDate.dayOfMonth
        val dateBirth = birthDay.toString() + "/" + birthMonth.toString() + "/" + birthYear.toString()

        //Se pasan los datos en el intent
        nextButton.setOnClickListener {
            if(firstName.text.isNotEmpty() && lastName.text.isNotEmpty() && birthDate.isNotEmpty()){
                val intent = Intent(this, ContactDataActivity::class.java)
                intent.putExtra("name", fullName)
                intent.putExtra("gender", gender)
                intent.putExtra("birthdate", dateBirth)
                intent.putExtra("schoolarGrade", grade)
                startActivity(intent)
            } else {
                fieldsError()
            }
        }
    }


    private fun fieldsError() {
        Toast.makeText(this, "Existen campos obligatorios sin llenar", Toast.LENGTH_LONG).show()
    }
}