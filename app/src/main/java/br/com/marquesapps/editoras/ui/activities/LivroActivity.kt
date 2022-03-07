package br.com.marquesapps.editoras.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.marquesapps.editoras.databinding.ActivityLivroBinding
import br.com.marquesapps.editoras.ui.constants.ISBN_EXTRA
import br.com.marquesapps.editoras.ui.extensions.mostrarMensagem
import br.com.marquesapps.editoras.ui.viewmodel.LivroViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LivroActivity : AppCompatActivity() {

    private val viewDataBinding by lazy { ActivityLivroBinding.inflate(layoutInflater) }
    private val viewModel: LivroViewModel by viewModel()

    private var isbn = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewDataBinding.root)
        configurarTitulo()
        iniciarIsbn()
    }

    private fun configurarTitulo(){
        supportActionBar?.title = "Livro"
    }

    private fun iniciarIsbn(){
        intent.getStringExtra(ISBN_EXTRA)?.let {
            isbn = it
        }
    }

    override fun onResume() {
        super.onResume()
        buscarLivro()
    }

    private fun buscarLivro() {
        viewModel.pegarDadosDoLivro(isbn).observe(this){
            it.dados?.let { livro ->
                viewDataBinding.livro = livro
            }
            it.mensagem?.let { mensagem ->
                mostrarMensagem(viewDataBinding.root, mensagem)
            }
        }
    }
}