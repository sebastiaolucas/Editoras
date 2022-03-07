package br.com.marquesapps.editoras.webclient.dto

import com.google.gson.annotations.SerializedName

data class EditorasPreviaDTO(
    val editora: List<EditoraPreviaDTO>?,
    val message: String?
)

data class EditoraPreviaDTO(
    @SerializedName ("nome_editora") val nomeEditora: String,
    @SerializedName("cnpj_editora") val cnpjEditora: String,
    @SerializedName("id_editora") val idEditora: String
)
