package br.com.marquesapps.editoras.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import br.com.marquesapps.editoras.databinding.ActivityEditorasBinding
import br.com.marquesapps.editoras.databinding.BuscaIsbnItemBinding
import br.com.marquesapps.editoras.ui.adapter.EditoraAdapter
import br.com.marquesapps.editoras.ui.constants.CNPJ_EXTRA
import br.com.marquesapps.editoras.ui.constants.ISBN_EXTRA
import br.com.marquesapps.editoras.ui.extensions.mostrarMensagem
import br.com.marquesapps.editoras.ui.viewmodel.EditorasViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class EditorasActivity : AppCompatActivity() {

    private val viewDataBinding by lazy { ActivityEditorasBinding.inflate(layoutInflater) }
    private val adapter: EditoraAdapter by inject()
    private val viewModel: EditorasViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewDataBinding.root)
        configurarAdapter()
        configurarBusca()
        configurarTitulo()
    }

    private fun configurarTitulo(){
        supportActionBar?.title = "Editoras"
    }

    private fun configurarAdapter(){
        viewDataBinding.listaActivityEditoras.adapter = adapter
        adapter.onEditoraClickList = { previa ->
            irParaEditoraActivity(previa.cnpj)
        }
    }

    private fun configurarBusca(){
        viewDataBinding.setOnBuscaClickListener {
            mostraCaixaDeBusca()
        }
    }

    override fun onResume() {
        super.onResume()
        buscarEditoras()
    }

    private fun buscarEditoras(){
        viewModel.listarEditoras().observe(this){
            it.dados?.let { previa ->
                adapter.submitList(previa)
            }
            it.mensagem?.let { mensagem ->
                mostrarMensagem(viewDataBinding.root, mensagem)
            }
        }
    }

    private fun mostraCaixaDeBusca(){
        val isbnData = ObservableField("")
        val inflate = BuscaIsbnItemBinding.inflate(layoutInflater)
        inflate.isbnData = isbnData
        AlertDialog.Builder(this)
            .setTitle("Buscar livro por ISBN")
            .setView(inflate.root)
            .setNeutralButton("Cancelar",null)
            .setPositiveButton("Buscar"
            ) { _, _ ->
                isbnData.get()?.let{
                    irParaLivroActivity(it)
                }
            }
            .show()
    }

    private fun irParaLivroActivity(isbn: String){
        Intent(this, LivroActivity::class.java).run {
            putExtra(ISBN_EXTRA, isbn)
            startActivity(this)
        }
    }

    private fun irParaEditoraActivity(cnpj: String){
        Intent(this, EditoraActivity::class.java).run {
            putExtra(CNPJ_EXTRA, cnpj)
            startActivity(this)
        }
    }
}