package br.com.marquesapps.editoras.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.marquesapps.editoras.model.Editora
import br.com.marquesapps.editoras.repositories.MercadoEditorialRepository
import br.com.marquesapps.editoras.ui.viewmodel.resources.Resources

class EditoraViewModel(
    private val repository: MercadoEditorialRepository
) : ViewModel() {

    fun pegarDadosDaEditora(cnpj: String): LiveData<Resources<Editora>> {
        val liveData = MutableLiveData<Resources<Editora>>()
        repository.pegarDadosDaEditora(cnpj,
            {
                liveData.postValue(
                    Resources(it, null)
                )
            },
            {
                liveData.postValue(
                    Resources(null, it)
                )
            }
        )
        return liveData
    }

}