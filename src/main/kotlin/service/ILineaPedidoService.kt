package org.example.service

import org.example.model.LineaPedido

interface ILineaPedidoService {
    fun getAll(): List<LineaPedido>
    fun insert(lineaPedido: LineaPedido)
    fun update(lineaPedido: LineaPedido)
    fun delete(id: Int)
    fun obtenerPorId(id: Int): List<LineaPedido>
}