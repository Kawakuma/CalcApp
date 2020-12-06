package jp.techacademy.kentaro.kawamura.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        multi.setOnClickListener(this)
        divide.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        if (editText1.text.toString() != "" && editText2.text.toString() != "") {

            val intent = Intent(this, SecondActivity::class.java)
            var Tx1St = editText1.text.toString()
            var Tx1int = Tx1St.toDouble()
            var Tx2St = editText2.text.toString()
            var Tx2int = Tx2St.toDouble()

            if (v.id == R.id.plus) {

                var Sum = Tx1int + Tx2int
                intent.putExtra("Value", Sum)
                startActivity(intent)
            } else if (v.id == R.id.minus) {

                var Sum = Tx1int - Tx2int
                intent.putExtra("Value", Sum)
                startActivity(intent)

            }

            else if(v.id==R.id.multi)
            {var Sum = Tx1int * Tx2int
            intent.putExtra("Value", Sum)
            startActivity(intent)
        }

            else if(v.id==R.id.divide)
            {var Sum = Tx1int / Tx2int
                intent.putExtra("Value", Sum)
                startActivity(intent)
            }
        }
        else {Snackbar.make(v, "数値を入力してください", Snackbar.LENGTH_INDEFINITE)
            .setAction("Action"){
                Log.d("UI_PARTS", "Snackbarをタップした")
            }.show()}
    }
}