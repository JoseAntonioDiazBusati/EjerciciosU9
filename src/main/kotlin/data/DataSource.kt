package org.example.data

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import java.sql.Connection

object DataSource {
    private val hikariConfig = HikariConfig().apply {
        jdbcUrl = "jdbc:h2:~/H2"
        driverClassName = "org.h2.Driver"
        username = "user"
        password = "user"
        maximumPoolSize = 10
        isAutoCommit = true
        transactionIsolation = "TRANSACTION_READ_COMMITTED"
    }

    val dataSource = HikariDataSource(hikariConfig)

    fun getConnection(): Connection = dataSource.connection

    fun close() {
        dataSource.close()
    }
}