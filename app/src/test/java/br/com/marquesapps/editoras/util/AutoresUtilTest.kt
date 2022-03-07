package br.com.marquesapps.editoras.util

import br.com.marquesapps.editoras.webclient.dto.AutoresDTO
import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class AutoresUtilTest{

    private val util = AutoresUtil()

    @Test
    fun deve_DevolverStringVazia_QuandoReceberListaDeAutoresVazia(){
        val listaVazia = listOf<AutoresDTO>()

        val stringRetornada = util.listaDeAutoresToString(listaVazia)

        assertThat(stringRetornada, `is`(""))
    }

    @Test
    fun deve_DevolverStringComUmaLinha_QuandoReceberListaComApenasUmAutor(){
        val listaComAutor = listOf(
            AutoresDTO("Sebastião", "Lucas", "Autor")
        )

        val stringRetornada = util.listaDeAutoresToString(listaComAutor)

        assertThat(stringRetornada, `is`("Autor: Sebastião Lucas"))
    }

    @Test
    fun deve_DevolverStringVariasLinha_QuandoReceberListaVariosAutores(){
        val listaComVariosAutores = listOf(
            AutoresDTO("Pedro", "Santos", "Autor"),
            AutoresDTO("Sebastião", "Lucas", "Coordenador"),
            AutoresDTO("Maria", "De Paula", "Diretor")
        )

        val stringRetornada = util.listaDeAutoresToString(listaComVariosAutores)

        assertThat(stringRetornada, `is`("Autor: Pedro Santos\n" +
                "Coordenador: Sebastião Lucas\n" +
                "Diretor: Maria De Paula"))
    }

}