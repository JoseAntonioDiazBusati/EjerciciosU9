package org.example.data.db


import java.sql.*

object Database {
    private const val URL = "jdbc:h2:./data/tiendadb"
    private const val USERNAME = "sa"
    private const val PASSWORD = ""

    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection(URL, USERNAME, PASSWORD)
        } catch (e: SQLException) {
            print("Error: ${e.message}")
            null
        }
    }

    fun closeConnection(conn: Connection?) {
        try {
            conn?.close()
        } catch (e: SQLException) {
            print("Error: ${e.message}")
        }
    }

}