package com.anggadps.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.contracts.Returns

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollbutton: Button = findViewById(R.id.btnRoll)
        val txtChangeView: TextView = findViewById(R.id.txtChangeNumber)


        /*
        contoh untuk fungsi button saat kondisi di tekan
        */
        rollbutton.setOnClickListener {


            /*
            contoh memakai fungsi toast
            */
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()


            /*
            contoh merubah text
            */
            txtChangeView.text = "6"


            kocokDadu()
        }
    }

    private fun kocokDadu() {

        /*
        memanggil class "dice" di dalam
        function terlebih dahulu
        */
        val dadu = Dice(6)

        /*
        lalu untuk kondisi mengocok dadunya dengan
        cara membuat variable yang berisi koding untuk memanggil
        function "roll" yang ada di dalam class "dice"
        */
        val kocok = dadu.roll()


        val txthasildadu: TextView = findViewById(R.id.txtRollNumber)
        val imghasildadu: ImageView = findViewById(R.id.imgDice)
        val imghasildadu2: ImageView = findViewById(R.id.imgDice2)
        val imghasildadu3: ImageView = findViewById(R.id.imgDice3)



        /*
        contoh merubah data angka menjadi teks dikarenakan "hasildadu" adalah int
        * sedangkan tempat untuk menaruh datanya(txtRollNumber) adalah teks
        */
        txthasildadu.text = kocok.toString()

        /*
        contoh merubah gambar menggukan "if/else" berdasarkan angka dadu yang keluar
        * */
        if (kocok == 1){
            imghasildadu.setImageResource(R.drawable.dice_1)
        } else if (kocok == 2){
            imghasildadu.setImageResource(R.drawable.dice_2)
        } else if (kocok == 3){
            imghasildadu.setImageResource(R.drawable.dice_3)
        } else if (kocok == 4){
            imghasildadu.setImageResource(R.drawable.dice_4)
        } else if (kocok == 5){
            imghasildadu.setImageResource(R.drawable.dice_5)
        } else{
            imghasildadu.setImageResource(R.drawable.dice_6)
        }


        /*
        contoh merubah gambar menggukan "when" berdasarkan angka dadu yang keluar
        * */
        when (kocok){
            1 -> imghasildadu2.setImageResource(R.drawable.dice_1)
            2 -> imghasildadu2.setImageResource(R.drawable.dice_2)
            3 -> imghasildadu2.setImageResource(R.drawable.dice_3)
            4 -> imghasildadu2.setImageResource(R.drawable.dice_4)
            5 -> imghasildadu2.setImageResource(R.drawable.dice_5)
            6 -> imghasildadu2.setImageResource(R.drawable.dice_6)
        }


        /*
        contoh merubah gambar menggukan "when yang di persingkat" berdasarkan angka dadu yang keluar
        * */
        val drawableResource = when (kocok){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> {R.drawable.dice_6}
        }
        imghasildadu3.setImageResource(drawableResource)


        imghasildadu.contentDescription = kocok.toString()
        imghasildadu2.contentDescription = kocok.toString()
        imghasildadu3.contentDescription = kocok.toString()


    }
}

class Dice(val jmlSisi: Int) {

    fun roll(): Int {
        return (1..jmlSisi).random()
    }
}