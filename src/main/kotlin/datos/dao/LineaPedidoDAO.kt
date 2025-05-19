package org.example.datos.dao

import org.example.data.db.Database
import org.example.model.LineaPedido
import org.example.ui.Consola
import java.sql.*

class LineaPedidoDAO: ILineaPedidoDAO {
    override fun getAll(): List<LineaPedido> {
        val lineaPedidos = mutableListOf<LineaPedido>()
        var conn: Connection? = null
        var stmt: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = Database.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
                val sql = "SELECT * FROM LINEAPEDIDO"
                rs = stmt.executeQuery(sql)
                while (rs.next()) {
                    val cantidad = rs.getInt("cantidad")
                    val precio = rs.getDouble("precio")
                    val idPedido = rs.getInt("id pedido")
                    val idProducto = rs.getInt("cantidad")
                    lineaPedidos.add(LineaPedido(cantidad,precio,idPedido,idProducto))
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
        return lineaPedidos
    }

    override fun insert(lineaPedido: LineaPedido) {
        var conn: Connection? = null
        var stmt: PreparedStatement? = null

        try {
            conn = Database.getConnection()
            stmt = conn?.prepareStatement("INSERT INTO LINEAPEDIDO (cantidad, precio, idpedido, idproducto) VALUES (?,?,?,?)")
            stmt?.setInt(1, lineaPedido.cantidad)
            stmt?.setDouble(2, lineaPedido.precio)
            stmt?.setInt(3, lineaPedido.idPedido)
            stmt?.setInt(4, lineaPedido.idProducto)
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

    override fun update(lineaPedido: LineaPedido) {
        var conn: Connection? = null
        var stmt: PreparedStatement? = null
        try {
            conn = Database.getConnection()
            if(conn != null){
                stmt = conn.prepareStatement("UPDATE LINEAPEDIDO SET cantidad = ?, precio = ?, idpedido = ?, idproducto = ? WHERE id = ?")
                stmt?.setInt(1, lineaPedido.cantidad)
                stmt?.setDouble(2, lineaPedido.precio)
                stmt?.setInt(3, lineaPedido.idPedido)
                stmt?.setInt(4, lineaPedido.idProducto)
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
                stmt = conn.prepareStatement("DELETE FROM LINEAPEDIDO WHERE id = ?")
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

    override fun obtenerPorId(id: Int): List<LineaPedido> {
        val lineaPedidos = mutableListOf<LineaPedido>()
        var conn: Connection? = null
        var stmt: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = Database.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
                val sql = "SELECT * FROM LINEAPEDIDO WHERE id = ?"
                rs = stmt.executeQuery(sql)
                while (rs.next()) {
                    val cantidad = rs.getInt("cantidad")
                    val precio = rs.getDouble("precio")
                    val idPedido = rs.getInt("id pedido")
                    val idProducto = rs.getInt("cantidad")
                    lineaPedidos.add(LineaPedido(cantidad,precio,idPedido,idProducto))
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
        return lineaPedidos
    }
}