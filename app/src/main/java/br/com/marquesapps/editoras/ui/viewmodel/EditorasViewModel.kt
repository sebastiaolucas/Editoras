package br.com.marquesapps.editoras.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.marquesapps.editoras.model.EditoraPrevia
import br.com.marquesapps.editoras.repositories.MercadoEditorialRepository
import br.com.marquesapps.editoras.ui.viewmodel.resources.Resources

class EditorasViewModel(
    private val repository: MercadoEditorialRepository
): ViewModel() {

    fun listarEditoras(): LiveData<Resources<List<EditoraPrevia>>>{
        val liveData = MutableLiveData<Resources<List<EditoraPrevia>>>()
        repository.listarEditoras(
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