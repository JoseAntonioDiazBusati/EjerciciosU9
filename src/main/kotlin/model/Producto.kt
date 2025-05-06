package org.example.model

import org.example.data.DataSource.getConnection

data class Producto(val id: Int, val nombre: String, val precio: Double, val stock: Int)


fun initDatabaseProducto() {
    getConnection().use { conn ->
        val stmt = conn.createStatement()
        stmt.executeUpdate(
            """CREATE TABLE IF NOT EXISTS Producto (
                id INT AUTO_INCREMENT PRIMARY KEY,
                nombre VARCHAR(255) NOT NULL,
                precio DECIMAL NOT NULL,
                stock INT NOT NULL
            )"""
        )
        stmt.close()
    }
}

fun createProducto(nombre: String, precio: Double, stock: Int) {
    getConnection().use { conn ->
        val stmt = conn.prepareStatement("INSERT INTO Producto (nombre, precio, stock) VALUES (?, ?, ?)")
        stmt.setString(1, nombre)
        stmt.setDouble(2, precio)
        stmt.setInt(3,stock)
        stmt.executeUpdate()
    }
}

fun readProducto(): List<Producto> {
    val producto = mutableListOf<Producto>()
    getConnection().use { conn ->
        val stmt = conn.createStatement()
        val rs = stmt.executeQuery("SELECT * FROM Producto")
        while (rs.next()) {
            producto += Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("stock"))
        }
    }
    return producto
}

fun updateProducto(id: Int, nombre: String, precio: Double, stock: Int) {
    getConnection().use { conn ->
        val stmt = conn.prepareStatement("UPDATE Producto SET nombre = ?, email = ? WHERE id = ?")
        stmt.setString(1, nombre)
        stmt.setDouble(2, precio)
        stmt.setInt(3,stock)
        stmt.setInt(4, id)
        stmt.executeUpdate()
    }
}

fun deleteProducto(id: Int) {
    getConnection().use { conn ->
        val stmt = conn.prepareStatement("DELETE FROM Producto WHERE id = ?")
        stmt.setInt(1, id)
        stmt.executeUpdate()
    }
}