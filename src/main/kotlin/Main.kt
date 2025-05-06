package org.example
import org.example.model.createUsuario
import org.example.model.initDatabaseUsuario
import org.example.model.readUsuario
import java.sql.*

fun main() {
    initDatabaseUsuario()
    createUsuario("Facundo Pérez","facuper@mail.com")
    createUsuario("Ataulfo Rodríguez","ataurod@mail.com")
    createUsuario("Cornelio Ramírez","Cornram@mail.com")
    readUsuario().forEach(::println)
}