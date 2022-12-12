package com.example.memorygame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    var temp_button: ImageButton? = null;
    var temp_resource: Int? = null
    var score_counts = 0
    var time = 0
    var minutes = 0
    lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        val btn1 = findViewById<ImageButton>(R.id.btn1);
        val btn2 = findViewById<ImageButton>(R.id.btn2);
        val btn3 = findViewById<ImageButton>(R.id.btn3);
        val btn4 = findViewById<ImageButton>(R.id.btn4);
        val btn5 = findViewById<ImageButton>(R.id.btn5);
        val btn6 = findViewById<ImageButton>(R.id.btn6);
        val btn7 = findViewById<ImageButton>(R.id.btn7);
        val btn8 = findViewById<ImageButton>(R.id.btn8);
        val btn9 = findViewById<ImageButton>(R.id.btn9);
        val btn10 = findViewById<ImageButton>(R.id.btn10);
        val btn11 = findViewById<ImageButton>(R.id.btn11);
        val btn12 = findViewById<ImageButton>(R.id.btn12);

        var pics = LinkedList<Int>();
        pics.add(R.drawable.ic_facebook)
        pics.add(R.drawable.ic_imo)
        pics.add(R.drawable.ic_instagram)
        pics.add(R.drawable.ic_linkedin)
        pics.add(R.drawable.ic_messenger)
        pics.add(R.drawable.ic_twitter)
        pics.add(R.drawable.ic_facebook)
        pics.add(R.drawable.ic_imo)
        pics.add(R.drawable.ic_instagram)
        pics.add(R.drawable.ic_linkedin)
        pics.add(R.drawable.ic_messenger)
        pics.add(R.drawable.ic_twitter)
        var shuffeld_pics = pics.shuffled()
        btn1.setOnClickListener {
            click(0, it as ImageButton, shuffeld_pics)
        }
        btn2.setOnClickListener {

            click(1, it as ImageButton, shuffeld_pics)
        }
        btn3.setOnClickListener {

            click(2, it as ImageButton, shuffeld_pics)
        }
        btn4.setOnClickListener {

            click(3, it as ImageButton, shuffeld_pics)
        }
        btn5.setOnClickListener {

            click(4, it as ImageButton, shuffeld_pics)
        }
        btn6.setOnClickListener {

            click(5, it as ImageButton, shuffeld_pics)
        }
        btn7.setOnClickListener {

            click(6, it as ImageButton, shuffeld_pics)
        }
        btn8.setOnClickListener {

            click(7, it as ImageButton, shuffeld_pics)
        }
        btn9.setOnClickListener {

            click(8, it as ImageButton, shuffeld_pics)
        }
        btn10.setOnClickListener {

            click(9, it as ImageButton, shuffeld_pics)
        }
        btn11.setOnClickListener {

            click(10, it as ImageButton, shuffeld_pics)
        }
        btn12.setOnClickListener {

            click(11, it as ImageButton, shuffeld_pics)
        }

        Timer().schedule(object : TimerTask() {

            @SuppressLint("SetTextI18n")
            override fun run() {
                textView.setText("%02d:%02d".format(minutes,time).toString())
                time++
                if(time == 60){
                    time = 0
                    minutes++
                }
            }
        }, 1000, 1000)
    }

    fun click(index: Int, it: ImageButton, shuffeld_pics: List<Int>) {
        val tempbtn = temp_button
        val pic = shuffeld_pics[index]
        if (tempbtn == null) {
            it.setImageResource(pic)
            it.isClickable = false
            temp_button = it
            temp_resource = pic;

        } else {
            if (temp_resource == pic) {
                it.setImageResource(pic)
                it.isClickable = false
                it.isClickable = false
                score_counts++
                if (score_counts == 6) {
                    Toast.makeText(this, "Congrates You Won", Toast.LENGTH_LONG).show()
                } else {

                    Toast.makeText(this, "Great Hit", Toast.LENGTH_SHORT).show()
                }
            } else {
                it.setImageResource(pic)
                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        tempbtn?.setImageResource(R.drawable.ic_question)
                        it.setImageResource(R.drawable.ic_question)
                        tempbtn?.isClickable = true
                        it.isClickable = true
                    }
                }, 1500)
            }
            temp_button = null
            temp_resource = null
        }
    }

}