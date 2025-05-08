package org.example.ui

class Consola: IConsola {

    override fun mostrarMSJ(mensaje: String) {
        println(mensaje)
    }

    override fun mostrarError(Error: String) {
        println(Error)
    }
}