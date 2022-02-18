package com.example.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG = "MainActivity"
/**
Note: The log tag is typically declared outside of the class.
Even though this variable is declared outside of MainActivity,
it's declared as private so that it will only be accessible in MainActivity.kt.
This means you can also declare a TAG variable for other classes
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)  // has to be before setting findviewById
        Log.d(TAG,"This is where the app crashed before.")
        val helloTextView: TextView = findViewById(R.id.division_textview)
        Log.d(TAG, "This should be logged if the bug is fixed.")
        helloTextView.text = "Hello, debugging"

        logging()
        division()
    }
    fun division(){
        val numerator = 60
        var denominator = 4   // have to be a variable
        repeat(4) {
            findViewById<TextView>(R.id.division_textview).setText("${numerator / denominator}")
            Log.v(TAG, " Calculation ${numerator/denominator}")
            denominator --  //denominator is reduced each time by -1, app will crash because of division by 0
        }
    }
    fun logging() {           //avoid introducing side effects (modifying values in your code)
        Log.e(TAG, "ERROR: a sersios error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
    }
}
