package com.example.komalpatel_comp304_test01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get

class StudentDetails_Activity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

      val details = findViewById<TextView>(R.id.text_details)
        val stuId = findViewById<EditText>(R.id.editstudId)
        val email = findViewById<EditText>(R.id.edit_email)
        val studName = findViewById<EditText>(R.id.editstudName)
        val radioGroupmode = findViewById<RadioGroup>(R.id.radiogrp_mode)
        val btnPrev = findViewById<Button>(R.id.buttonPrev)
        val btnSubmit = findViewById<Button>(R.id.buttonSubmit)
        val finalDetails = findViewById<TextView>(R.id.text_studdetails)

        var Name = intent.getStringExtra("Name")
        var Total_fees = intent.getStringExtra("Fees")

        val result= "Program Name:$Name\nFees:$Total_fees"

        details.text=result

        btnPrev.setOnClickListener {
            intent= Intent(this,MainActivity::class.java)
        }
        btnSubmit.setOnClickListener {
            val  StuedentId = stuId.text.toString()
            val Stuname = studName.text.toString()
            val StuEmail = email.text.toString()

            val selectedFormat = when (radioGroupmode.checkedRadioButtonId) {
                R.id.radio_online-> "Online"
                R.id.radio_hybrid -> "Hybrid"
                R.id.radio_inclass -> "In-class"

                else -> ""
            }

            val result= "ID:$StuedentId\nEmail:$StuEmail \n Name: $Stuname\n Mode: $selectedFormat "

            finalDetails.text=result

        }

    }
}