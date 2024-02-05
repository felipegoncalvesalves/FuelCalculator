package presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.example.fuelcalculatortest.R

class Resultado_carro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_carro)

        val tv_distancia = findViewById<TextView>(R.id.tv_km)
        val tv_litros = findViewById<TextView>(R.id.tv_lts)
        val tv_preço = findViewById<TextView>(R.id.tv_preço)
        val tv_preço_pessoa = findViewById<TextView>(R.id.tv_preço_pessoa)

        val distancia = intent.getFloatExtra("DISTANCIA", 0.1f,)
        val litros = intent.getFloatExtra("EXTRA_RESULT_LITROS", 0.01f)
        val preço = intent.getFloatExtra("EXTRA_RESULT_CARRO", 0.01f)
        val preço_pessoas = intent.getFloatExtra("EXTRA_RESULT_PESSOAS", 0.01f)

        tv_distancia.text = distancia.toString()
        tv_litros.text = litros.toString()
        tv_preço.text = preço.toString()
        tv_preço_pessoa.text = preço_pessoas.toString()


        supportActionBar?.title = "Voltar"
        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Ação para o botão de voltar (seta para trás)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)

        }
    }
}
