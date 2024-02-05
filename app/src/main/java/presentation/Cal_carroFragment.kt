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

class Cal_carroFragment : Fragment() {

    private val viewModel: Cal_ViewModel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view_carro = inflater.inflate(R.layout.fragment_cal_carro,container, false)

        val bt_calcular_carro : Button = view_carro.findViewById(R.id.bt_calcular)
        val edtconsumo : EditText = view_carro.findViewById(R.id.consumo)
        val edtdistancia : EditText = view_carro.findViewById(R.id.distancia)
        val edtpreço : EditText = view_carro.findViewById(R.id.preço)
        val edtpessoas : EditText = view_carro.findViewById(R.id.num_pessoas)


        bt_calcular_carro.setOnClickListener {
            val consumo = edtconsumo.text.toString()
            val distancia = edtdistancia.text.toString()
            val preço = edtpreço.text.toString()
            val pessoas = edtpessoas.text.toString()


            viewModel.calcularResultados(consumo, distancia, preço, pessoas)

            val intent = Intent(requireContext(), Resultado_carro::class.java)

            viewModel.camposPreenchidos.observe(viewLifecycleOwner, { camposPreenchidos ->
                if (camposPreenchidos) {

                    viewModel.resultadoDistancia.observe(viewLifecycleOwner, { resultadoDistancia ->
                        intent.putExtra("DISTANCIA", resultadoDistancia)
                    })

                    viewModel.resultadoConsumo.observe(viewLifecycleOwner, { resultadoConsumo ->
                        intent.putExtra("EXTRA_RESULT_CARRO", resultadoConsumo)
                    })

                    viewModel.resultadoPessoas.observe(viewLifecycleOwner, { resultadoPessoas ->
                        intent.putExtra("EXTRA_RESULT_PESSOAS", resultadoPessoas)
                    })

                    viewModel.resultadoLitros.observe(viewLifecycleOwner, { resultadoLitros ->
                        intent.putExtra("EXTRA_RESULT_LITROS", resultadoLitros)
                    })

                    startActivity(intent)
                } else {
                    Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                }
            })
        }

        return view_carro
    }

    companion object {
        fun newInstance() = Cal_carroFragment
    }
}
