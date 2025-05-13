package org.example.datos.dao

import org.example.data.db.Database
import org.example.model.Producto
import org.example.ui.Consola
import java.sql.*

class ProductoDAO: IProductoDAO {
    override fun getAll(): List<Producto> {
        val productos = mutableListOf<Producto>()
        var conn: Connection? = null
        var stmt: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = Database.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
                val sql = "SELECT * FROM PRODUCTO"
                rs = stmt.executeQuery(sql)
                while (rs.next()) {
                    val nombre = rs.getString("nombre")
                    val precio = rs.getDouble("precio")
                    val stock = rs.getInt("stock")
                    productos.add(Producto(nombre, precio, stock))
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
        return productos
    }

    override fun insert(producto: Producto) {
        var conn: Connection? = null
        var stmt: PreparedStatement? = null

        try {
            conn = Database.getConnection()
            if (conn != null){
                stmt = conn.prepareStatement("INSERT INTO PRODUCTO (nombre, precio, stock) VALUES (?,?,?)")
                stmt.setString(1, producto.nombre)
                stmt.setDouble(2, producto.precio)
                stmt.setInt(3, producto.stock)
                stmt.executeUpdate()
            }
        } catch (e: SQLException) {
            Consola().mostrarError("Error al insertar producto.")
        } catch (e: Exception) {
            Consola().mostrarError("Error al ejecutar.")
        } finally {
            stmt?.close()
            conn?.close()
        }
    }

    override fun update(producto: Producto) {
        var conn: Connection? = null
        var stmt: PreparedStatement? = null

        try {
            conn = Database.getConnection()
            if (conn != null){
                stmt = conn.prepareStatement("UPDATE PRODUCTO SET nombre = ?, precio = ?, stock = ? WHERE id = ?")
                stmt.setString(1, producto.nombre)
                stmt.setDouble(2, producto.precio)
                stmt.setInt(3, producto.stock)
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
                stmt = conn.prepareStatement("DELETE FROM PRODUCTO WHERE id = ?")
                stmt.setInt(1,id)
                stmt?.executeUpdate()
            }
        }catch (e: SQLException) {
            Consola().mostrarError("Error al borrar el producto.")
        } catch (e: Exception) {
            Consola().mostrarError("Error al ejecutar.")
        } finally {
            stmt?.close()
            conn?.close()
        }
    }

    override fun obtenerPorId(id: Int): List<Producto> {
        val productos = mutableListOf<Producto>()
        var conn: Connection? = null
        var stmt: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = Database.getConnection()
            if (conn != null) {
                stmt = conn.createStatement()
                val sql = "SELECT * FROM PRODUCTO WHERE id = ?"
                rs = stmt.executeQuery(sql)
                while (rs.next()) {
                    val nombre = rs.getString("nombre")
                    val precio = rs.getDouble("precio")
                    val stock = rs.getInt("stock")
                    productos.add(Producto(nombre, precio, stock))
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
        return productos
    }
}