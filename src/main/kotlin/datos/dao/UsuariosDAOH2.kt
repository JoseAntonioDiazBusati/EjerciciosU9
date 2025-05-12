package org.example.data.dao

import org.example.data.db.Database
import org.example.model.Usuario
import java.sql.*
import org.example.ui.Consola

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
                    val nombre = rs.getString("nombre")
                    val email = rs.getString("email")
                    usuarios.add(Usuario(nombre, email))
                }
            }
        } catch (e: SQLException) {
            Consola().mostrarError("Error al mostrar la tabla.")
        } catch (e: Exception) {
            Consola().mostrarError("Error al ejecutar.")
        } finally {
            rs?.close()
            stmt?.close()
            conn?.close()
        }
        return usuarios
    }

    override fun insert(usuario: Usuario) {
        var conn: Connection? = null
        var stmt: PreparedStatement? = null

        try {
            conn = Database.getConnection()
            stmt = conn?.prepareStatement("INSERT INTO USUARIO (nombre, email) VALUES (?,?)")
            stmt?.setString(1, usuario.nombre)
            stmt?.setString(2, usuario.email)
            stmt?.executeUpdate()
        } catch (e: SQLException) {
            Consola().mostrarError("Error al insertar en la tabla.")
        } catch (e: Exception) {
            Consola().mostrarError("Error al ejecutar.")
        } finally {
            stmt?.close()
            conn?.close()
        }
    }

    override fun update(usuario: Usuario) {
        var conn: Connection? = null
        var stmt: PreparedStatement? = null
        try {
            conn = Database.getConnection()
            if(conn != null){
                stmt = conn.prepareStatement("UPDATE Usuario SET nombre = ? WHERE id = ?")
                stmt.setString(1, usuario.nombre)
                stmt.setString(2, usuario.email)
                stmt.executeUpdate()
            }
        } catch (e: SQLException) {
            Consola().mostrarError("Error al actualizar la tabla.")
        } catch (e: Exception) {
            Consola().mostrarError("Error al ejecutar.")
        } finally {
            stmt?.close()
            conn?.close()
        }
    }

    override fun delete(id: Int) {
        var conn: Connection? = null
        var stmt: PreparedStatement? = null
        try {
            conn = Database.getConnection()
            if (conn != null){
                stmt = conn.prepareStatement("DELETE FROM Usuario WHERE id = ?")
                stmt.setInt(1, id)
                stmt.executeUpdate()
            }
        } catch (e: SQLException) {
            Consola().mostrarError("Error al borrar el usuario.")
        } catch (e: Exception) {
            Consola().mostrarError("Error al ejecutar.")
        } finally {
            stmt?.close()
            conn?.close()
        }
    }
    override fun obtenerPorId(id: Int): List<Usuario> {
        val usuarios = mutableListOf<Usuario>()
        var conn: Connection? = null
        var stmt: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = Database.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
                val sql = "SELECT * FROM Usuario WHERE id = $id"
                rs = stmt.executeQuery(sql)
                while (rs.next()) {
                    val nombre = rs.getString("nombre")
                    val email = rs.getString("email")
                    usuarios.add(Usuario(nombre, email))
                }
            }
        } catch (e: SQLException) {
                Consola().mostrarError("Error al mostrar la tabla.")
        } catch (e: Exception) {
                Consola().mostrarError("Error al ejecutar.")
        } finally {
            rs?.close()
            stmt?.close()
            conn?.close()
        }
        return usuarios
    }
}
