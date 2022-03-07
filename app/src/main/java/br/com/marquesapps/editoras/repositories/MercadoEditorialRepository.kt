package br.com.marquesapps.editoras.repositories

import br.com.marquesapps.editoras.model.Editora
import br.com.marquesapps.editoras.model.EditoraPrevia
import br.com.marquesapps.editoras.model.Livro
import br.com.marquesapps.editoras.webclient.services.MercadoEditorialService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val MENSAGEM_DE_ERRO = "Ocorreu um erro"

class MercadoEditorialRepository(
    private val service: MercadoEditorialService
) {

    private fun <T> executaChamada(
        chamada: Call<T>,
        quandoSucesso: (resposta: T) -> Unit,
        quandoFalha: (mensagem: String) -> Unit,
    ) {
        chamada.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    response.body()?.let { resposta ->
                        quandoSucesso(resposta)
                    } ?: quandoFalha(MENSAGEM_DE_ERRO)
                } else {
                    quandoFalha(MENSAGEM_DE_ERRO)
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                quandoFalha(MENSAGEM_DE_ERRO)
            }

        })
    }

    fun listarEditoras(
        quandoSucesso: (lista: List<EditoraPrevia>) -> Unit,
        quandoFalha: (mensagem: String) -> Unit
    ) {
        executaChamada(
            service.listarEditoras(),
            {
                it.editora?.let { editoras ->
                    val lista = editoras.map { dto ->
                        EditoraPrevia(dto)
                    }
                    quandoSucesso(lista)
                }
                it.message?.let(quandoFalha)
            },
            quandoFalha
        )
    }

    fun pegarDadosDaEditora(
        cnpj: String,
        quandoSucesso: (editora: Editora) -> Unit,
        quandoFalha: (mensagem: String) -> Unit
    ) {
        executaChamada(
            service.pegarDadosDaEditora(cnpj),
            {
                it.editora?.let { dto ->
                    val editora = Editora(dto)
                    quandoSucesso(editora)
                }
                it.message?.let(quandoFalha)
            },
            quandoFalha
        )
    }

    fun pegarDadosDoLivro(
        isbn: String,
        quandoSucesso: (livro: Livro) -> Unit,
        quandoFalha: (mensagem: String) -> Unit
    ) {
        executaChamada(
            service.pegarDadosDoLivro(isbn),
            {
                it.livro?.let { dto ->
                    val livro = Livro(dto)
                    quandoSucesso(livro)
                }
                it.message?.let(quandoFalha)
            },
            quandoFalha
        )
    }

}