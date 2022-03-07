package br.com.marquesapps.editoras.model

import br.com.marquesapps.editoras.webclient.dto.EditoraDTO

data class Editora(
    val nome: String,
    val nomeSocial: String,
    val cnpj: String,
    val inscricaoEstadual: String,
    val telefone: String,
    val livros: String
){

    constructor(dto: EditoraDTO): this(
        dto.nomeFantasia,
        dto.nomeSocial,
        dto.cnpj,
        dto.inscricaoEstadual,
        dto.telefone,
        dto.livros
    )

}