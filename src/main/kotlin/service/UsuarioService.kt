package org.example.service

import org.example.data.dao.IUsuariosDAO
import org.example.model.Usuario

class UsuarioService(private val usuarioDao: IUsuariosDAO): IUsuarioService {
    override fun getAll(): List<Usuario> {
        return usuarioDao.getAll()
    }

    override fun insert(usuario: Usuario) {
        require(usuario.nombre.isNotEmpty()) { "El nombre del usuario no puede estar vacío" }
        //...
        usuarioDao.insert(usuario)
    }

    override fun update(usuario: Usuario) {
        require(usuario.nombre.isNotEmpty()) { "El nombre del usuario no puede estar vacío" }
        //...
        usuarioDao.update(usuario)
    }

    override fun delete(id: Int) {
        require(id > 0) { "El id debe ser válido!" }
        //...
        usuarioDao.delete(id)
    }
}