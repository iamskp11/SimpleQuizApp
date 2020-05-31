package com.example.andapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    lateinit var qn : TextView
    lateinit var selected : RadioGroup
    lateinit var op1 : RadioButton
    lateinit var op2 : RadioButton
    lateinit var op3 : RadioButton
    lateinit var b1 : Button
    lateinit var f : Button

    var index=0
    var score=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      qn=findViewById(R.id.qn) as TextView
        selected=findViewById(R.id.selected) as RadioGroup
        op1=findViewById(R.id.op1) as RadioButton
        op2=findViewById(R.id.op2) as RadioButton
        op3=findViewById(R.id.op3) as RadioButton
        b1=findViewById(R.id.b1) as Button
        f=findViewById(R.id.f) as Button

        val qns=arrayOf("Square of 4 is ","First prime number is ")
        val opns= arrayOf<Int>(13,8,16,2,0,1)
        val ans= arrayOf<Int>(3,1)

        fun quiz(z : Int) :Void?
        {println("Index is ")
            println(index)
            index=z
            if(index==2)
            {
                b1.setVisibility(View.INVISIBLE)
                f.setVisibility(View.VISIBLE)
                f.text="End of Quiz"
                qn.text="Your Score is "+(score*50)+"%"
                op1.setVisibility(View.INVISIBLE)
                op2.setVisibility(View.INVISIBLE)
                op3.setVisibility(View.INVISIBLE)
            }
            else {
            b1.text="Submit "
            qn.text=qns[index]
            op1.text= opns[3*index].toString()
            op2.text=opns[3*index+1].toString()
            op3.text=opns[3*index+2].toString()
            b1.setOnClickListener {
                if(selected.checkedRadioButtonId!=-1) {
                    if(ans[index]==1 && op1.isChecked) score++;
                    if(ans[index]==2 && op2.isChecked) score++;
                    if(ans[index]==3 && op3.isChecked) score++;

                    index+=1

                    quiz(index)
                }
            } }
            return null
        }
        b1.setOnClickListener({
            quiz(index)

        })




    }

    fun quitApp(view: View)
    {
        this@MainActivity.finish()
        exitProcess(0)
    }

}
