package org.example.data.dao

import org.example.data.db.Database
import org.example.model.Usuario
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class UsuariosDAOH2: IUsuariosDAO {
    override fun getAll(): List<Usuario> {
        val usuarios = mutableListOf<Usuario>()
        var conn: Connection? = null
        var stmt: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = Database.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
                val sql = "SELECT * FROM Usuario"
                rs = stmt.executeQuery(sql)
                while (rs.next()) {
                    val id = rs.getInt("id")
                    usuarios.add(Usuario(id, ))
                }
            }
        } catch (e: SQLException) {

        } catch (e: Exception) {

        } finally {
            rs?.close()
            stmt?.close()
            conn?.close()
        }

    }

    override fun insert(usuario: Usuario) {
        TODO("Not yet implemented")
    }

    override fun update(usuario: Usuario) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }
}