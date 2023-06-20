package com.alfdonyus.myapplication02

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private  lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView

    private fun initComponents(){
        nameEditText=findViewById(R.id.nameEditText)
        sayHelloButton=findViewById(R.id.sayHelloButton)
        sayHelloTextView=findViewById(R.id.sayHelloTextView)
    }

    private fun checkFingerprint(){
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE", "Feature Fingerprint OM")
        }else{
            Log.i("FEATURE", "Feature Fingerprint OFF")
        }
    }

    private fun checkPlatformVersion(){
        Log.i("SDK",Build.VERSION.SDK_INT.toString())
        if (Build.VERSION.SDK_INT<Build.VERSION_CODES.S){
            Log.i("SDK","Disable feature, because version SDK is lower than 31")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        checkFingerprint()
        checkPlatformVersion()
        initComponents()

        sayHelloTextView.text= resources.getString(R.string.app_name)

        sayHelloButton.setOnClickListener {

            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }
            Log.i("RAW", sample)


            val json=assets.open("sample.json")
                .bufferedReader()
                .use{it.readText()}
            Log.i("ASSET", json)
            Log.d("PZN", "This is debug log")
            Log.i("PZN", "This is debug log")
            Log.w("PZN", "This is debug log")
            Log.e("PZN", "This is debug log")

            Log.i("Value Resource", resources.getInteger(R.integer.maxPage).toString())
            Log.i("Value Resource", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("Value Resource", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("Value Resource", resources.getColor(R.color.background, theme).toString())

            sayHelloButton.setBackgroundColor(resources.getColor(R.color.background,theme))

            val name = nameEditText.text.toString()
            sayHelloTextView.text=resources.getString(R.string.sayHelloTextView, name)
            
            resources.getStringArray(R.array.names).forEach {
                Log.i("PZN",it)
            }
        }
    }
}