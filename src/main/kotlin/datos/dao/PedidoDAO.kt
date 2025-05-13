package org.example.datos.dao


import org.example.data.db.Database
import org.example.model.Pedido
import java.sql.*
import org.example.ui.Consola

class PedidoDAO: IPedidoDAO {
    override fun getAll(): List<Pedido> {
        val pedidos = mutableListOf<Pedido>()
        var conn: Connection? = null
        var stmt: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = Database.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
                val sql = "SELECT * FROM PEDIDO"
                rs = stmt.executeQuery(sql)
                while (rs.next()) {
                    val precioTotal = rs.getDouble("precio total")
                    val idUsuario = rs.getInt("id usuario")
                    pedidos.add(Pedido(precioTotal, idUsuario))
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
        return pedidos
    }

    override fun insert(pedido: Pedido) {
        var conn: Connection? = null
        var stmt: PreparedStatement? = null

        try {
            conn = Database.getConnection()
            stmt = conn?.prepareStatement("INSERT INTO PEDIDO (precioTotal, idUsuario) VALUES (?,?)")
            stmt?.setDouble(1, pedido.precioTotal)
            stmt?.setInt(2, pedido.idUsuario)
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

    override fun update(pedido: Pedido) {
        var conn: Connection? = null
        var stmt: PreparedStatement? = null
        try {
            conn = Database.getConnection()
            if(conn != null){
                stmt = conn.prepareStatement("UPDATE PEDIDO SET precioTotal = ? WHERE id = ?")
                stmt.setDouble(1, pedido.precioTotal)
                stmt.setInt(2, pedido.idUsuario)
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
                stmt = conn.prepareStatement("DELETE FROM PEDIDO WHERE id = ?")
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
    override fun obtenerPorId(id: Int): List<Pedido> {
        val pedidos = mutableListOf<Pedido>()
        var conn: Connection? = null
        var stmt: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = Database.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
                val sql = "SELECT * FROM PEDIDO WHERE id = ?"
                rs = stmt.executeQuery(sql)
                while (rs.next()) {
                    val precioTotal = rs.getDouble("precio total")
                    val idUsuario = rs.getInt("id Usuario")
                    pedidos.add(Pedido(precioTotal, idUsuario))
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
        return pedidos
    }
}
