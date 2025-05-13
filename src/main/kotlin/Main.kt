package org.example
import org.example.data.dao.UsuariosDAOH2
import org.example.data.db.Database
import org.example.model.Usuario
import org.example.service.UsuarioService

fun main() {

    val usuario1 = Usuario( "Facundo Pérez",  "facuper@mail.com")
    val usuario2 = Usuario( "Ataulfo Rodríguez",  "ataurod@mail.com")
    val usuario3 = Usuario( "Cornelio Ramírez",  "Cornram@mail.com")

    val usuariodao = UsuariosDAOH2()
    val usuarioservicio = UsuarioService(usuariodao)

    usuarioservicio.insert(usuario1)
    usuarioservicio.insert(usuario2)
    usuarioservicio.insert(usuario3)
    println(usuarioservicio.getAll())

}