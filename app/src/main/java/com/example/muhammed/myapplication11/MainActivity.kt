package com.example.muhammed.myapplication11

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var editText : EditText
    lateinit var editText1 : EditText
    lateinit var editText2 : EditText
    lateinit var textView : TextView
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        editText1 = findViewById(R.id.editText2)
        editText2 = findViewById(R.id.editText3)
        textView = findViewById(R.id.textView)
        btn = findViewById(R.id.button)

        readInfo()

        btn.setOnClickListener {
            saveInfo()

        }
    }


 private  fun saveInfo(){
        if(editText.text.isEmpty()){
            editText.error = "Please your firstname"
        }
        if(editText1.text.isEmpty()){
            editText.error = "Please your lastname"
        }
        if(editText2.text.isEmpty()){
            editText.error = "Please your address"
        }
        val sp = getSharedPreferences("sp", Context.MODE_PRIVATE)
        val editSp = sp.edit()
        editSp.putString("firstname",editText.text.toString())
        editSp.putString("lastname",editText1.text.toString())
        editSp.putString("address",editText2.text.toString())
        editSp.apply()
        Toast.makeText(this,"Saved !!" , Toast.LENGTH_LONG).show()
    }

    private fun readInfo(){
        val sp = getSharedPreferences("sp", Context.MODE_PRIVATE)
      val firsname =   sp.getString("firstname","not found")
      val lastname =     sp.getString("lastname","not found")
      val address =    sp.getString("address","not found")

        editText.setText(firsname)
        editText1.setText(lastname)
        editText2.setText(address)

        textView.text = firsname +" " + lastname+" Location : " + address
    }

}
