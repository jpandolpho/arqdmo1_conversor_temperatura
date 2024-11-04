package br.edu.ifsp.dmo1.conversordetemperatura

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.conversordetemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configurar comportamento do botão
        binding.buttonConverter.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_converter){
            handleConversion()
        }
    }

    private fun handleConversion() {
        val celsius = binding.editTemperature.text.toString().toDouble()
        val fahrenheit = converter(celsius)
        binding.textFahrenheit.text = "$fahrenheit ºF"
    }

    private fun converter(celsius: Double): Double {
        return (celsius * 9.0 / 5.0) + 32.0
    }
}