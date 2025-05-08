package org.example.ui

class Consola: IConsola {

    override fun mostrarMsj(mensaje: String) {
        println(mensaje)
    }

    override fun mostrarError(error: String) {
        println(error)
    }
}