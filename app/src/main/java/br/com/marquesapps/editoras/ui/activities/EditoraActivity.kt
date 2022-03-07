package br.com.marquesapps.editoras.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.marquesapps.editoras.databinding.ActivityEditoraBinding
import br.com.marquesapps.editoras.ui.constants.CNPJ_EXTRA
import br.com.marquesapps.editoras.ui.extensions.mostrarMensagem
import br.com.marquesapps.editoras.ui.viewmodel.EditoraViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class EditoraActivity : AppCompatActivity() {

    private val viewDataBinding by lazy { ActivityEditoraBinding.inflate(layoutInflater) }
    private val viewModel: EditoraViewModel by viewModel()
    private var cnpj = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewDataBinding.root)
        configurarTitulo()
        iniciarCnpj()
    }

    private fun configurarTitulo(){
        supportActionBar?.title = "Editora"
    }

    private fun iniciarCnpj(){
        intent.getStringExtra(CNPJ_EXTRA)?.let {
            cnpj = it
        }
    }

    override fun onResume() {
        super.onResume()
        buscarEditora()
    }

    private fun buscarEditora(){
        viewModel.pegarDadosDaEditora(cnpj).observe(this){
            it.dados?.let { editora ->
                viewDataBinding.editora = editora
            }
            it.mensagem?.let { mensagem ->
                mostrarMensagem(viewDataBinding.root, mensagem)
            }
        }
    }


}