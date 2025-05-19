package org.example.service

import org.example.datos.dao.LineaPedidoDAO
import org.example.model.LineaPedido

class LineaPedidoService(private val lineaPedidoDAO: LineaPedidoDAO): ILineaPedidoService {
    override fun getAll(): List<LineaPedido> {
        return lineaPedidoDAO.getAll()
    }

    override fun insert(lineaPedido: LineaPedido) {
        require(lineaPedido.cantidad > 0){" La cantidad debe ser superior a 0. "}
        require(lineaPedido.precio > 0.0){" El precio debe ser mayor que 0. "}
        require(lineaPedido.idPedido > 0){" El id del pedido debe ser mayor que 0. "}
        require(lineaPedido.idProducto > 0){" El id del producto debe ser superior a 0. "}
        return lineaPedidoDAO.insert(lineaPedido)
    }

    override fun update(lineaPedido: LineaPedido) {
        require(lineaPedido.cantidad > 0){" La cantidad debe ser superior a 0. "}
        require(lineaPedido.precio > 0.0){" El precio debe ser mayor que 0. "}
        require(lineaPedido.idPedido > 0){" El id del pedido debe ser mayor que 0. "}
        require(lineaPedido.idProducto > 0){" El id del producto debe ser superior a 0. "}
        return lineaPedidoDAO.update(lineaPedido)
    }

    override fun delete(id: Int) {
        require(id > 0){ "El id debe ser mayor que 0" }
        return lineaPedidoDAO.delete(id)
    }

    override fun obtenerPorId(id: Int): List<LineaPedido> {
        require(id > 0){ "El id debe ser mayor que 0" }
        return lineaPedidoDAO.obtenerPorId(id)
    }
}