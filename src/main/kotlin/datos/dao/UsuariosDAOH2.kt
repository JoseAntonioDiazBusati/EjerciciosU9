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
                    val id = rs.getInt("id")
                    val nombre = rs.getString("nombre")
                    val email = rs.getString("email")
                    usuarios.add(Usuario(id, nombre, email))
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
        val usuarios = mutableListOf<Usuario>()
        var conn: Connection? = null
        var stmt: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = Database.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
                val sql = "INSERT INTO Usuario"
                rs = stmt.executeQuery(sql)
                usuarios.add(usuario)
            }
        } catch (e: SQLException) {
            Consola().mostrarError("Error al insertar la tabla.")
        } catch (e: Exception) {
            Consola().mostrarError("Error al ejecutar.")
        } finally {
            rs?.close()
            stmt?.close()
            conn?.close()
        }
    }

    override fun update(usuario: Usuario) {
        val usuarios = mutableListOf<Usuario>()
        var conn: Connection? = null
        var stmt: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = Database.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
                val sql = "INSERT usuario INTO Usuario"
                rs = stmt.executeQuery(sql)
                usuarios.add(usuario)
            }
        } catch (e: SQLException) {
            Consola().mostrarError("Error al actualizar la tabla.")
        } catch (e: Exception) {
            Consola().mostrarError("Error al ejecutar.")
        } finally {
            rs?.close()
            stmt?.close()
            conn?.close()
        }
    }

    override fun delete(id: Int) {
        val usuarios = mutableListOf<Usuario>()
        var conn: Connection? = null
        var stmt: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = Database.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
                val sql = "DELETE FROM Usuario WHERE id = ?"
                rs = stmt.executeQuery(sql)
            }
        } catch (e: SQLException) {
            Consola().mostrarError("Error al borrar el usuario.")
        } catch (e: Exception) {
            Consola().mostrarError("Error al ejecutar.")
        } finally {
            rs?.close()
            stmt?.close()
            conn?.close()
        }
    }
}