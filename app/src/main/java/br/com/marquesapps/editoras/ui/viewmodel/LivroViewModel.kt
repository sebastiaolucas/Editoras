package br.com.marquesapps.editoras.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.marquesapps.editoras.model.Livro
import br.com.marquesapps.editoras.repositories.MercadoEditorialRepository
import br.com.marquesapps.editoras.ui.viewmodel.resources.Resources

class LivroViewModel(
    private val repository: MercadoEditorialRepository
) : ViewModel() {

    fun pegarDadosDoLivro(isbn: String): LiveData<Resources<Livro>> {
        val liveData = MutableLiveData<Resources<Livro>>()
        repository.pegarDadosDoLivro(isbn,
            { livro ->
                liveData.postValue(Resources(livro, null))
            }, {
                liveData.postValue(Resources(null, it))
            })
        return liveData
    }

}