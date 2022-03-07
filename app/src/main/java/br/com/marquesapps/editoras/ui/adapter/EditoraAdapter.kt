package br.com.marquesapps.editoras.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.marquesapps.editoras.databinding.EditoraItemBinding
import br.com.marquesapps.editoras.model.EditoraPrevia

class EditoraAdapter(
    private val context: Context
) : ListAdapter<EditoraPrevia, EditoraAdapter.EditoraViewHolder>(EditoraAdapter){

    var onEditoraClickList: (editoraPrevia: EditoraPrevia) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditoraViewHolder {
        val inflater = LayoutInflater.from(context)
        val viewDataBinding = EditoraItemBinding.inflate(inflater, parent, false)
        return EditoraViewHolder(viewDataBinding)
    }

    override fun onBindViewHolder(holder: EditoraViewHolder, position: Int) {
        holder.vincular(getItem(position))
    }

    companion object diffItem: DiffUtil.ItemCallback<EditoraPrevia>(){
        override fun areItemsTheSame(oldItem: EditoraPrevia, newItem: EditoraPrevia): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: EditoraPrevia, newItem: EditoraPrevia): Boolean {
            return oldItem == newItem
        }

    }

    inner class EditoraViewHolder(private val viewDataBinding: EditoraItemBinding)
        : RecyclerView.ViewHolder(viewDataBinding.root){

            fun vincular(editoraPrevia: EditoraPrevia){
                viewDataBinding.editoraPrevia = editoraPrevia
                viewDataBinding.setOnEditoraClickListener {
                    onEditoraClickList(editoraPrevia)
                }
            }
    }

}