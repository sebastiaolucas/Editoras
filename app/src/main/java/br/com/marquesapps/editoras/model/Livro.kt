package br.com.marquesapps.editoras.model

import br.com.marquesapps.editoras.util.AutoresUtil
import br.com.marquesapps.editoras.webclient.dto.LivroDTO

data class Livro(
    val titulo: String,
    val subtitulo: String,
    val isbn: String,
    val edicao: String,
    val dataPublicacao: String,
    val idioma: String,
    val origem: String,
    val autores: String,
    val sinopse: String,
){

    constructor(dto: LivroDTO): this(
        dto.titulo,
        dto.subtitulo,
        dto.isbn,
        dto.edicao,
        dto.dataPublicacao,
        dto.idioma,
        dto.origem,
        AutoresUtil().listaDeAutoresToString(dto.autores),
        dto.sinopse
    )

}