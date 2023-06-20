package com.alfdonyus.myapplication02

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity :AppCompatActivity() {

    lateinit var computerImageView: ImageView
    lateinit var rockImageButton: ImageButton
    lateinit var paperImageButton: ImageButton
    lateinit var scissorImageButton: ImageButton
    lateinit var resultImageView: ImageView

    private fun initComponents(){
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        scissorImageButton = findViewById(R.id.scissorImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }

    private fun initListener (){
        rockImageButton.setOnClickListener { startGame("ROCK") }
        scissorImageButton.setOnClickListener { startGame("SCISSOR") }
        paperImageButton.setOnClickListener { startGame("PAPER") }

    }

    private fun startGame (option: String){
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when{
            Game.isDraw(option,computerOption)->resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(option,computerOption)->resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListener()
    }
}