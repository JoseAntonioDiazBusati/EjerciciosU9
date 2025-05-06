package org.example
import org.example.data.db.Database

fun main() {

    val conn = Database.getConnection()

    if (conn != null) {
        print("Conexión OK")
    } else {
        print("Un mojón p ti")
    }

    Database.closeConnection(conn)

}