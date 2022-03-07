package br.com.marquesapps.editoras.webclient.dto

import com.google.gson.annotations.SerializedName

data class EditoraDTO(
    @SerializedName("nome_fantasia") val nomeFantasia: String,
    @SerializedName("nome_social") val nomeSocial: String,
    @SerializedName("cnpj") val cnpj: String,
    @SerializedName("inscricao_estadual") val inscricaoEstadual: String,
    @SerializedName("telefone") val telefone: String,
    @SerializedName("numero_de_livros") val livros: String
)

data class EditoraObjDTO(
    val editora: EditoraDTO?,
    val message: String?
)
