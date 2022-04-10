package com.ummuhanoksuz.kotlincatchtherick

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

abstract class MainActivity : AppCompatActivity() {
    lateinit var timeText:TextView
    lateinit var scoreText:TextView
    var score=0
    var rickArray=ArrayList<ImageView>()
    lateinit var imageView1:ImageView
    lateinit var imageView2:ImageView
    lateinit var imageView3:ImageView
    lateinit var imageView4:ImageView
    lateinit var imageView5:ImageView
    lateinit var imageView6:ImageView
    lateinit var imageView7:ImageView
    lateinit var imageView8:ImageView
    lateinit var imageView9:ImageView
    lateinit var imageView10:ImageView
    lateinit var imageView11:ImageView
    lateinit var imageView12:ImageView
    lateinit var imageView13:ImageView
    lateinit var imageView14:ImageView
    lateinit var imageView15:ImageView
    lateinit var imageView16:ImageView
    lateinit var imageView17:ImageView
    lateinit var imageView18:ImageView
    lateinit var imageView19:ImageView
    lateinit var imageView20:ImageView
    lateinit var imageView21:ImageView
    lateinit var imageView22:ImageView
    lateinit var imageView23:ImageView
    lateinit var imageView24:ImageView

    var runnable : Runnable = Runnable {  }
    var handler = Handler(Looper.myLooper()!!)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeText=findViewById(R.id.time)
        scoreText=findViewById(R.id.score)
        imageView1=findViewById(R.id.imageView1)
        imageView2=findViewById(R.id.imageView2)
         imageView3=findViewById(R.id.imageView3)
         imageView4=findViewById(R.id.imageView4)
         imageView5=findViewById(R.id.imageView5)
         imageView6=findViewById(R.id.imageView6)
         imageView7=findViewById(R.id.imageView7)
        imageView8=findViewById<ImageView>(R.id.imageView8)
        imageView9=findViewById<ImageView>(R.id.imageView9)
         imageView10=findViewById<ImageView>(R.id.imageView10)
         imageView11=findViewById<ImageView>(R.id.imageView11)
         imageView12=findViewById<ImageView>(R.id.imageView12)
         imageView13=findViewById<ImageView>(R.id.imageView13)
         imageView14=findViewById<ImageView>(R.id.imageView14)
         imageView15=findViewById<ImageView>(R.id.imageView15)
         imageView16=findViewById<ImageView>(R.id.imageView16)
         imageView17=findViewById<ImageView>(R.id.imageView17)
         imageView18=findViewById<ImageView>(R.id.imageView18)
         imageView19=findViewById<ImageView>(R.id.imageView19)
         imageView20=findViewById<ImageView>(R.id.imageView20)
         imageView21=findViewById<ImageView>(R.id.imageView21)
         imageView22=findViewById<ImageView>(R.id.imageView22)
         imageView23=findViewById<ImageView>(R.id.imageView23)
         imageView24=findViewById<ImageView>(R.id.imageView24)

        setDataImageArray()

        object:CountDownTimer(15000, 1000){
            override fun onTick(p0: Long) {
                timeText.text="Time: ${p0/1000}"
            }

            override fun onFinish() {
                handler.removeCallbacks(runnable)//Oyun bittikten sonra resimde durur
                for(image in rickArray){
                    image.visibility=View.INVISIBLE
                }
                var alert=AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart the game?")
                alert.setPositiveButton("Yes"){ dialog, which->

                    //Başka bir activitye gitmeden aynı activityi çağırma işlemi
                    var intent=intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No"){ dialog, which->
                    Toast.makeText(this@MainActivity, "GOOD BYE!!", Toast.LENGTH_SHORT)

                    Handler().postDelayed({
                    }, 2000)
                    finish()
                }
                alert.show()
            }
        }.start()
        showImage()
    }

    fun increaseScore(view: View){
        score=score+1
        scoreText.text="Skor: ${score}"
    }

    fun showImage(){
        var runnable=object :Runnable{
            override fun run() {
                var rand=(0..24).random()

                rickArray[rand].visibility=View.VISIBLE
                handler.postDelayed(runnable, 500)
            }

        }
        handler.post(runnable)
    }

    fun setDataImageArray(){
        rickArray.add(imageView1)
        rickArray.add(imageView2)
        rickArray.add(imageView3)
        rickArray.add(imageView4)
        rickArray.add(imageView5)
        rickArray.add(imageView6)
        rickArray.add(imageView7)
        rickArray.add(imageView8)
        rickArray.add(imageView9)
        rickArray.add(imageView10)
        rickArray.add(imageView11)
        rickArray.add(imageView12)
        rickArray.add(imageView13)
        rickArray.add(imageView14)
        rickArray.add(imageView15)
        rickArray.add(imageView16)
        rickArray.add(imageView17)
        rickArray.add(imageView18)
        rickArray.add(imageView19)
        rickArray.add(imageView20)
        rickArray.add(imageView21)
        rickArray.add(imageView22)
        rickArray.add(imageView23)
        rickArray.add(imageView24)

    }
}