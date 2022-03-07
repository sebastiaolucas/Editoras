package br.com.marquesapps.editoras.ui.extensions

import android.app.Activity
import android.view.View
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun Activity.mostrarMensagem(view: View, mensagem: String){
    Snackbar.make(
        view,
        mensagem,
        BaseTransientBottomBar.LENGTH_INDEFINITE
    ).show()
}