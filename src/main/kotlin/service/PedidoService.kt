package org.example.service

import org.example.datos.dao.PedidoDAO
import org.example.model.Pedido

class PedidoService(private val pedidosDao: PedidoDAO): IPedidoService {
    override fun getAll(): List<Pedido> {
        return pedidosDao.getAll()
    }

    override fun insert(pedido: Pedido) {
        require(pedido.idUsuario > 0){ "El id del usuario debe ser mayor que 0" }
        require(pedido.precioTotal > 0){ "El precio debe ser siempre mayor a 0" }
        return pedidosDao.insert(pedido)
    }

    override fun update(pedido: Pedido) {
        require(pedido.idUsuario > 0){ "El id del usuario debe ser mayor que 0" }
        require(pedido.precioTotal > 0){ "El precio debe ser siempre mayor a 0" }
        return pedidosDao.update(pedido)
    }

    override fun delete(id: Int) {
        require(id > 0){ "El id debe ser mayor que 0" }
        return pedidosDao.delete(id)
    }

    override fun obtenerPorId(id: Int): List<Pedido> {
        require(id > 0){ "El id debe ser mayor que 0" }
        return pedidosDao.obtenerPorId(id)
    }
}