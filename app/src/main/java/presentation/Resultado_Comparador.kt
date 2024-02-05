package presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.example.fuelcalculatortest.R

class Resultado_Comparador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_comparador)


        val txt_resultado = findViewById<TextView>(R.id.result)
        val resultado = intent.getStringExtra("EXTRA_RESULT")
        txt_resultado.text = resultado

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