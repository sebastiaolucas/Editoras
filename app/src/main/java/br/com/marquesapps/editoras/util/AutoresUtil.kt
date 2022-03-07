package br.com.marquesapps.editoras.util

import br.com.marquesapps.editoras.webclient.dto.AutoresDTO

class AutoresUtil {

    fun listaDeAutoresToString(lista: List<AutoresDTO>): String {
        var saida = ""
        lista.forEachIndexed { index, autoresDTO ->
            saida += "${autoresDTO.tipoNome}: ${autoresDTO.nome} ${autoresDTO.sobrenome}"
            if((index + 1) != lista.size) saida += "\n"
        }
        return saida
    }

}