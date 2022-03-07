package br.com.marquesapps.editoras.webclient.dto

import com.google.gson.annotations.SerializedName

data class LivroObjDTO(
    val livro: LivroDTO?,
    val message: String?
)

data class LivroDTO(
    @SerializedName("titulo") val titulo: String,
    @SerializedName("subtitulo") val subtitulo: String,
    @SerializedName("isbn") val isbn: String,
    @SerializedName("edicao") val edicao: String,
    @SerializedName("data_publicacao") val dataPublicacao: String,
    @SerializedName("idioma") val idioma: String,
    @SerializedName("origem") val origem: String,
    @SerializedName("autores") val autores: List<AutoresDTO>,
    @SerializedName("sinopse") val sinopse: String,
)

data class AutoresDTO(
    @SerializedName("nome") val nome: String,
    @SerializedName("sobrenome") val sobrenome: String,
    @SerializedName("tipo_nome") val tipoNome: String,
)
