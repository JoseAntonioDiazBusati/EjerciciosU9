package org.example.datos.dao

import org.example.model.Pedido

interface IPedidoDAO {
    fun getAll(): List<Pedido>
    fun insert(pedido: Pedido)
    fun update(pedido: Pedido)
    fun delete(id: Int)
    fun obtenerPorId(id: Int): List<Pedido>
}