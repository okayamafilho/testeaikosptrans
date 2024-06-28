package br.com.okayamafilho.testeaikosptrans

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.okayamafilho.testeaikosptrans.api.RetrofitCustom
import br.com.okayamafilho.testeaikosptrans.api.model.ResultadoPesquisaLinhaBus
import br.com.okayamafilho.testeaikosptrans.api.model.ResultadoPesquisaLinhaBusItem
import br.com.okayamafilho.testeaikosptrans.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var buslineAdapter: BuslineAdapter
    private val ispTransAPI by lazy {
        RetrofitCustom.spTransAPI
    }

    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        buslineAdapter = BuslineAdapter()
        buslineAdapter.adicionarLista(
            listOf("R.drawable.img_ponto", "teste", "teste2")
        )
        binding.rvBusline.adapter = buslineAdapter
        binding.rvBusline.layoutManager = LinearLayoutManager(applicationContext)
    }

    override fun onStart() {
        super.onStart()
        recuperarBusLineAPI()
    }

    fun recuperarBusLineAPI() {
        job = CoroutineScope(Dispatchers.IO).launch {
            var responseAutenticacao: Response<Boolean>? = null
            var response: Response<ResultadoPesquisaLinhaBusItem>? = null

            try {
              responseAutenticacao = ispTransAPI.autenticarAPI( "7283c7558f5fee16beb01a03a6fb41d8b301461d7503d5744e483cbbeb3bb2f8")

               var cookie = responseAutenticacao.headers().get("Set-Cookie")
                cookie?.let {
                    var teste = ispTransAPI.pequisarLinhasBus("Lapa", it )
                    Log.i("teste_response", "Erro ao $teste ")
                }

                Log.i("teste_cookie", "Erro ao $cookie ")
            } catch (e: Exception) {
                e.printStackTrace()
            }

            if (response != null && response!!.isSuccessful && responseAutenticacao != null) {
                val resultado = response!!.body()
                if (resultado != null) {
                    resultado.cl
                }
            } else {
                Log.i("teste_", "Erro ao ")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }
}