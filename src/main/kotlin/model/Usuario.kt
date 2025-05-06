package org.example.model

data class Usuario(val id: Int, val nombre: String, val email: String)
/**
fun getConnection(): Connection =
    DriverManager.getConnection("jdbc:h2:~/H2", "user", "user")

fun initDatabase() {
    getConnection().use { conn ->
        val stmt = conn.createStatement()
        stmt.executeUpdate(
            """CREATE TABLE IF NOT EXISTS Usuario (
                id INT AUTO_INCREMENT PRIMARY KEY,
                nombre VARCHAR(255),
                email VARCHAR(255)
            )"""
        )
        stmt.close()
    }
}

fun createUser(name: String, email: String) {
    getConnection().use { conn ->
        val stmt = conn.prepareStatement("INSERT INTO Usuario (nombre, email) VALUES (?, ?)")
        stmt.setString(1, name)
        stmt.setString(2, email)
        stmt.executeUpdate()
    }
}

fun readUsers(): List<Usuario> {
    val users = mutableListOf<Usuario>()
    getConnection().use { conn ->
        val stmt = conn.createStatement()
        val rs = stmt.executeQuery("SELECT * FROM Usuario")
        while (rs.next()) {
            users += Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"))
        }
    }
    return users
}

fun updateUser(id: Int, nombre: String, email: String) {
    getConnection().use { conn ->
        val stmt = conn.prepareStatement("UPDATE users SET nombre = ?, email = ? WHERE id = ?")
        stmt.setString(1, nombre)
        stmt.setString(2, email)
        stmt.setInt(3, id)
        stmt.executeUpdate()
    }
}

fun deleteUser(id: Int) {
    getConnection().use { conn ->
        val stmt = conn.prepareStatement("DELETE FROM users WHERE id = ?")
        stmt.setInt(1, id)
        stmt.executeUpdate()
    }
}
*/