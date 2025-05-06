package org.example.data.dao

import org.example.data.db.Database
import org.example.model.Usuario
import java.sql.*

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
                    val nombre = rs.getString("nombre")
                    val email = rs.getString("email")
                    usuarios.add(Usuario(id, nombre, email))
                }
            }
        } catch (e: SQLException) {

        } catch (e: Exception) {

        } finally {
            rs?.close()
            stmt?.close()
            conn?.close()
        }
        return usuarios
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