package br.com.marquesapps.editoras.webclient.services

import br.com.marquesapps.editoras.webclient.dto.EditoraObjDTO
import br.com.marquesapps.editoras.webclient.dto.EditorasPreviaDTO
import br.com.marquesapps.editoras.webclient.dto.LivroObjDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MercadoEditorialService {

    @GET("requisitar_lista_de_editoras")
    fun listarEditoras() : Call<EditorasPreviaDTO>

    @GET("requisitar_informacoes_de_editora")
    fun pegarDadosDaEditora(@Query("cnpj") cnpj: String) : Call<EditoraObjDTO>

    @GET("https://sandbox.mercadoeditorial.org/api/v1/requisitar_livro_unico")
    fun pegarDadosDoLivro(@Query("isbn") isbn: String) : Call<LivroObjDTO>

}