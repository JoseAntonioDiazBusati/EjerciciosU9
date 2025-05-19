package org.example.service

import org.example.datos.dao.ProductoDAO
import org.example.model.Producto

class ProductoService(private val productoDAO: ProductoDAO): IProductoService {
    override fun getAll(): List<Producto> {
        return productoDAO.getAll()
    }

    override fun insert(producto: Producto) {
        require(producto.nombre.isNotEmpty()){" El nombre no puede estar en blanco. "}
        require(producto.precio > 0.0){" El precio debe ser mayor que 0. "}
        require(producto.stock > 0){" El stock del producto debe ser superior a 0. "}
        return productoDAO.insert(producto)
    }

    override fun update(producto: Producto) {
        require(producto.nombre.isNotEmpty()){" El nombre no puede estar en blanco. "}
        require(producto.precio > 0.0){" El precio debe ser mayor que 0. "}
        require(producto.stock > 0){" El stock del producto debe ser superior a 0. "}
        return productoDAO.update(producto)
    }

    override fun delete(id: Int) {
        require(id > 0){ "El id debe ser mayor que 0" }
        return productoDAO.delete(id)
    }

    override fun obtenerPorId(id: Int): List<Producto> {
        require(id > 0){ "El id debe ser mayor que 0" }
        return productoDAO.obtenerPorId(id)
    }
}