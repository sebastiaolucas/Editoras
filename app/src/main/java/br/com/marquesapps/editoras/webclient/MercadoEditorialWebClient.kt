package br.com.marquesapps.editoras.webclient

import br.com.marquesapps.editoras.webclient.services.MercadoEditorialService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MercadoEditorialWebClient {

    private val interceptor = HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://sandbox.mercadoeditorial.org/api/v1/")
        .client(client)
        .build()

    val mercadoEditorialService: MercadoEditorialService =
        retrofit.create(MercadoEditorialService::class.java)

}