package presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fuelcalculatortest.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)


        val calc_carro = Cal_carroFragment()
        val calc_moto = Cal_motoFragment()
        val menu_nav = findViewById<BottomNavigationView>(R.id.menu_cal)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, calc_carro)
            .commit()

        menu_nav.setOnItemSelectedListener {  menuItem  ->
            val fragment = when (menuItem.itemId){
                R.id.carro -> calc_carro
                R.id.moto -> calc_moto
                else -> calc_carro
                }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()

            true
            }
        }
}
