package br.edu.ifsp.dmo1.conversordetemperatura

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Buscar as referências dos objetos
        editText = findViewById(R.id.edit_temperature)
        button = findViewById(R.id.button_converter)
        textView = findViewById(R.id.text_fahrenheit)

        //Configurar comportamento do botão
        button.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_converter){
            handleConversion()
        }
    }

    private fun handleConversion() {
        val celsius = editText.text.toString().toDouble()
        val fahrenheit = converter(celsius)
        textView.text = "$fahrenheit ºF"
    }

    private fun converter(celsius: Double): Double {
        return (celsius * 9.0 / 5.0) + 32.0
    }
}