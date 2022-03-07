package br.com.marquesapps.editoras.di

import br.com.marquesapps.editoras.repositories.MercadoEditorialRepository
import br.com.marquesapps.editoras.ui.adapter.EditoraAdapter
import br.com.marquesapps.editoras.ui.viewmodel.EditoraViewModel
import br.com.marquesapps.editoras.ui.viewmodel.EditorasViewModel
import br.com.marquesapps.editoras.ui.viewmodel.LivroViewModel
import br.com.marquesapps.editoras.webclient.MercadoEditorialWebClient
import br.com.marquesapps.editoras.webclient.services.MercadoEditorialService
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single<EditoraAdapter> { EditoraAdapter(get()) }

    single<MercadoEditorialService> { MercadoEditorialWebClient().mercadoEditorialService }
    single<MercadoEditorialRepository> { MercadoEditorialRepository(get()) }

    viewModel<EditorasViewModel> { EditorasViewModel(get()) }
    viewModel<EditoraViewModel> { EditoraViewModel(get()) }
    viewModel<LivroViewModel> { LivroViewModel(get()) }
}