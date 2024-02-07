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
            val pessoas = edtpreço.text.toString()

            viewModel.calcularResultados(consumo, distancia, preço, pessoas)
            viewModel.camposPreenchidos.observe(viewLifecycleOwner, { camposPreenchidos ->
                if (camposPreenchidos) {

                    viewModel.resultadoDistancia.observe(viewLifecycleOwner, { resultadoDistancia ->
                        viewModel.resultadoConsumo.observe(viewLifecycleOwner, { resultadoConsumo ->
                                viewModel.resultadoLitros.observe(viewLifecycleOwner, { resultadoLitros ->
                                    val intent = Intent(requireContext(), Resultado_moto::class.java).apply {
                                        putExtra("EXTRA_RESULT", resultadoConsumo)
                                        putExtra("LITROS", resultadoLitros)
                                        putExtra("DISTANCIA", resultadoDistancia)

                                    }
                                      startActivity(intent)
                                })
                            })
                        })

                } else {
                    Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                }
            })
        }
        return view_moto
    }

    companion object {
        fun newInstance() = Cal_motoFragment
    }
}