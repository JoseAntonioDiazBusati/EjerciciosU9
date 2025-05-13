package org.example.datos.dao

import org.example.model.Producto

interface IProductoDAO {
    fun getAll(): List<Producto>
    fun insert(producto: Producto)
    fun update(producto: Producto)
    fun delete(id: Int)
    fun obtenerPorId(id: Int): List<Producto>
}