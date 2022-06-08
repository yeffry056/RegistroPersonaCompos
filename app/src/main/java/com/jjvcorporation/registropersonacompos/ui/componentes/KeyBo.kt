package com.jjvcorporation.registropersonacompos.ui.componentes

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


fun View.Keyboard(){
    val imp = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imp.hideSoftInputFromWindow(windowToken, 0)
}