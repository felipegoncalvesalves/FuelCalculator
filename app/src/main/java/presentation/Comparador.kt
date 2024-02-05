package presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.fuelcalculatortest.R

class Comparador : AppCompatActivity() {

    private lateinit var viewModel: ComparadorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparador)

        viewModel = ViewModelProvider(this).get(ComparadorViewModel::class.java)

        val btnConparar : Button = findViewById(R.id.btn_comparar)
        val edt_alcool : EditText = findViewById(R.id.alcool)
        val edt_gasolina : EditText = findViewById(R.id.gasolina)
        val edt_km_alcool : EditText = findViewById(R.id.km_alcool)
        val edt_km_gasolina : EditText = findViewById(R.id.km_gasolina)

            btnConparar.setOnClickListener {
                val alcool = edt_alcool.text.toString()
                val gasolina = edt_gasolina.text.toString()
                val km_alcool = edt_km_alcool.text.toString()
                val km_gasolina = edt_km_gasolina.text.toString()

                if (alcool.isNotEmpty() && gasolina.isNotEmpty() && km_alcool.isNotEmpty() && km_gasolina.isNotEmpty()) {
                    viewModel.comparadora(alcool, gasolina, km_alcool, km_gasolina)
                } else {
                    Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_SHORT).show()
                }


            }

        viewModel.resultado.observe(this, { resultado ->
                val intent = Intent (this, Resultado_Comparador::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", resultado)
                    }
                startActivity(intent)

        })


    }
}