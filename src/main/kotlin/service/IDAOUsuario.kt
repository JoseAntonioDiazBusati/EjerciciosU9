package org.example.service

import org.example.model.Usuario

interface IDAOUsuario {
    fun iniciarUsuario()
    fun crearUsuario(nombre: String, email: String)
    fun leerUsuario(): List<Usuario>
    fun actualizarUsuario(id: Int, nombre: String, email: String)
    fun borrarUsuario(id: Int)
}