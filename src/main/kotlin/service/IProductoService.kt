package org.example.service

import org.example.model.Producto

interface IProductoService {
    fun getAll(): List<Producto>
    fun insert(producto: Producto)
    fun update(producto: Producto)
    fun delete(id: Int)
    fun obtenerPorId(id: Int): List<Producto>
}