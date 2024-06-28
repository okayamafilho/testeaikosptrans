package br.com.okayamafilho.testeaikosptrans.api

import br.com.okayamafilho.testeaikosptrans.api.model.ResultadoPesquisaLinhaBus
import br.com.okayamafilho.testeaikosptrans.api.model.ResultadoPesquisaLinhaBusItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ISPTransAPI {

    @GET("Linha/Buscar")
    suspend fun pequisarLinhasBus(
        @Query ("termosBusca") termosBusca : String,
        @Header("cookie") cookie : String,
    ) : Response<ResultadoPesquisaLinhaBusItem>

    @POST("Login/Autenticar")
    suspend fun autenticarAPI(
        @Query ("token") token : String,
    ) : Response<Boolean>

}