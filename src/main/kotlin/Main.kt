package org.example
import java.sql.*

fun main() {
        val url = "jdbc:h2:~/H2"
        val usuario = "user"
        val contrasenia = "user"

        try {
            val conexion = DriverManager.getConnection(url, usuario, contrasenia)
            println("Conexión exitosa")
            conexion.close()
        } catch (e: SQLException) {
            println("Error en la conexión: ${e.message}")
        } catch (e: ClassNotFoundException) {
            println("No se encontró el driver JDBC: ${e.message}")
        }
}