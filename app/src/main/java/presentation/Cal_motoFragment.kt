package presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.fuelcalculatortest.R


class Cal_motoFragment : Fragment() {
    private val viewModel: Cal_ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view_moto=  inflater.inflate(R.layout.fragment_cal_moto, container, false)

        val bt_calcular_moto : Button = view_moto.findViewById(R.id.btn_calcular)
        val edtconsumo : EditText = view_moto.findViewById(R.id.consumo)
        val edtdistancia : EditText = view_moto.findViewById(R.id.distancia)
        val edtpreço : EditText = view_moto.findViewById(R.id.preço)

        bt_calcular_moto.setOnClickListener {
            val consumo = edtconsumo.text.toString()
            val distancia = edtdistancia.text.toString()
            val preço = edtpreço.text.toString()
            val pessoa = edtpreço.text.toString()
            val distanciaFloat = distancia.toFloat()

            viewModel.calcularResultados(consumo, distancia, preço, pessoa)

            val intent = Intent(requireContext(), Resultado_moto::class.java)
                intent.putExtra("DISTANCIA", distanciaFloat)

            viewModel.camposPreenchidos.observe(viewLifecycleOwner, { camposPreenchidos ->
                    if (!camposPreenchidos) {
                        Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                    }
                })
            viewModel.resultadoConsumo.observe(viewLifecycleOwner, { resultadoConsumo ->
                intent.putExtra("EXTRA_RESULT", resultadoConsumo)
            })
            viewModel.resultadoPessoas.observe(viewLifecycleOwner, { resultadoPessoas ->
                intent.putExtra("EXTRA_RESULT_PESSOAS", resultadoPessoas)
            })
            viewModel.resultadoLitros.observe(viewLifecycleOwner, {resultadoLitros ->
                intent.putExtra("LITROS", resultadoLitros)
            })

            startActivity(intent)

        }
        return view_moto
    }

    companion object {
        fun newInstance() = Cal_motoFragment
    }
}