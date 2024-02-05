package presentation

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Cal_ViewModel: ViewModel() {

    private val _resultadoConsumo = MutableLiveData<Float>()
    val resultadoConsumo : LiveData<Float> get() = _resultadoConsumo

    private val _resultadoDistancia = MutableLiveData<Float>()
    val resultadoDistancia : LiveData<Float> get() = _resultadoDistancia

    private val _resultadoPessoas = MutableLiveData<Float>()
    val resultadoPessoas : LiveData<Float> get() = _resultadoPessoas

    private val _resultadoLitros = MutableLiveData<Float>()
    val resultadoLitros :LiveData<Float> get() = _resultadoLitros

    private val _camposPreenchidos = MutableLiveData<Boolean>()
    val camposPreenchidos : LiveData<Boolean> get() = _camposPreenchidos

    fun calcularResultados(consumo: String, distancia: String, preço: String, pessoas: String) {
        if (consumo.isNotEmpty() && distancia.isNotEmpty() && preço.isNotEmpty() && pessoas.isNotEmpty()) {
            val consumoFloat = consumo.toFloat()
            val distanciaFloat = distancia.toFloat()
            val preçoFloat = preço.toFloat()
            val pessoasFloat = pessoas.toFloat()

            val resultConsumo = distanciaFloat / consumoFloat * preçoFloat
            val resultPessoas = resultConsumo / pessoasFloat
            val resultLitros = distanciaFloat / consumoFloat

            _resultadoDistancia.value = distanciaFloat
            _resultadoConsumo.value = resultConsumo
            _resultadoPessoas.value = resultPessoas
            _resultadoLitros.value = resultLitros
            _camposPreenchidos.value = true
        } else {
            _camposPreenchidos.value = false

        }
        }
    }
