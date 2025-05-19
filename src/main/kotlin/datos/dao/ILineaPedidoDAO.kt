package org.example.datos.dao

import org.example.model.LineaPedido

interface ILineaPedidoDAO {
    fun getAll(): List<LineaPedido>
    fun insert(lineaPedido: LineaPedido)
    fun update(lineaPedido: LineaPedido)
    fun delete(id: Int)
    fun obtenerPorId(id: Int): List<LineaPedido>
}