package com.example.komalpatel_comp304_test01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editProg = findViewById<EditText>(R.id.editNumber)
        val editDate= findViewById<EditText>(R.id.editDate)
        val editSchool = findViewById<EditText>(R.id.edit_school)
        val radioGroupProg = findViewById<RadioGroup>(R.id.radiogrpProgram)
        val checkbxdata = findViewById<CheckBox>(R.id.chek_database)
        val checkbxweb = findViewById<CheckBox>(R.id.chek_web)
        val checkbxmobile = findViewById<CheckBox>(R.id.chek_mobile)
        val checkbxjava = findViewById<CheckBox>(R.id.chek_Java)
        val editFee = findViewById<EditText>(R.id.editFees)
        val btnNext = findViewById<Button>(R.id.buttonNext)
        val btnselect= findViewById<Button>(R.id.button_select)

        val semster_spinner= findViewById<Spinner>(R.id.spinner_duration)
        val semester = resources.getStringArray(R.array.duration_semester)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,semester)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        semster_spinner.adapter = adapter


        btnNext.setOnClickListener {

            val fees = editFee.text.toString().toInt()
            val semster = semster_spinner.selectedItem.toString().toInt()

            val total_fees = fees * semster

            if(editFee==null || editProg== null || editDate== null || editSchool==null)
            {
                Toast.makeText(
                    this,
                    "Invalid input. Please check your entries.",
                    Toast.LENGTH_SHORT
                ).show()

            }
            if(!checkbxdata.isChecked || !checkbxjava.isChecked || !checkbxmobile.isChecked || !checkbxweb.isChecked)
            {
                Toast.makeText(
                    this,
                    "At least one checkbox should be selected",
                    Toast.LENGTH_SHORT
                ).show()

            }


            val isTypeSelected =
                ((checkbxdata.isChecked || checkbxweb.isChecked || checkbxjava.isChecked|| checkbxmobile.isChecked)&&
                        checkbxdata.isChecked || checkbxweb.isChecked || checkbxjava.isChecked|| checkbxmobile.isChecked)

            // Get selected event format
            val selectedFormat = when (radioGroupProg.checkedRadioButtonId) {
                R.id.radio_analyst-> "Software Analyst"
                R.id.radio_health -> "Health Infomatics"
                R.id.radio_technician -> "Software Technician"

                else -> ""
            }

            intent= Intent(this,StudentDetails_Activity::class.java)
            intent.putExtra("Name",editProg.text.toString()) // use double quatation
            intent.putExtra("Fees",total_fees.toString())


            startActivity(intent)
        }
    }
}