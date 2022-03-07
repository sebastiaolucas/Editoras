package br.com.marquesapps.editoras.model

import br.com.marquesapps.editoras.webclient.dto.EditoraPreviaDTO

data class EditoraPrevia(
    val nome: String,
    val cnpj: String,
    val id: String
){

    constructor(dto: EditoraPreviaDTO): this(
        dto.nomeEditora,
        dto.cnpjEditora,
        dto.idEditora
    )

}
