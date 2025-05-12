package org.example
import org.example.data.dao.UsuariosDAOH2
import org.example.data.db.Database
import org.example.model.Usuario
import org.example.service.UsuarioService

fun main() {

    Database.getConnection()

    val usuario1 = Usuario( "Facundo Pérez",  "facuper@mail.com")
    val usuario2 = Usuario( "Ataulfo Rodríguez",  "ataurod@mail.com")
    val usuario3 = Usuario( "Cornelio Ramírez",  "Cornram@mail.com")

    val dao = UsuariosDAOH2()
    val servicio = UsuarioService(dao)

    servicio.insert(usuario1)
    servicio.insert(usuario2)
    servicio.insert(usuario3)
    println(servicio.getAll())

}