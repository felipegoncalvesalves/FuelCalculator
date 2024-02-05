package presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComparadorViewModel : ViewModel () {
    private val _resultado = MutableLiveData<String>()
    val resultado : LiveData<String> get() = _resultado

    fun comparadora ( alcool: String, gasolina: String, kmAlcool:String, kmGasolina: String){
        if (alcool.isNotEmpty() && gasolina.isNotEmpty() && kmAlcool.isNotEmpty() && kmGasolina.isNotEmpty()) {
            val clcAlcool = alcool.toFloat() / kmAlcool.toFloat()
            val clcGasolina = gasolina.toFloat() / kmGasolina.toFloat()
            val calculo = clcAlcool / clcGasolina
            val result = if (calculo < 1) {
                "ÁLCOOL"
            } else {
                "GASOLINA"
            }


            _resultado.value = result
        }
    }
}