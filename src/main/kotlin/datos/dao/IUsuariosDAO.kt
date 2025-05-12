package org.example.data.dao

import org.example.model.Usuario

interface IUsuariosDAO {
    fun getAll(): List<Usuario>
    fun insert(usuario: Usuario)
    fun update(usuario: Usuario)
    fun delete(id: Int)
    fun obtenerPorId(id: Int): List<Usuario>
}