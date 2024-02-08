package presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.example.fuelcalculatortest.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        val comparador : Button = findViewById(R.id.comparar)
        val calculadora : Button = findViewById(R.id.calcular)

        comparador.setOnClickListener{
             val intent = Intent (this, Comparador::class.java)
            startActivity(intent)
        }

        calculadora.setOnClickListener{
            val intent = Intent (this, Calculadora::class.java)
            startActivity(intent)
        }
    }
}