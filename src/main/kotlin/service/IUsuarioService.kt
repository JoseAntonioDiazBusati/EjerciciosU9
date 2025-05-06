package org.example.service

import org.example.model.Usuario

interface IUsuarioService {
    fun getAll(): List<Usuario>
    fun insert(usuario: Usuario)
    fun update(usuario: Usuario)
    fun delete(id: Int)
}