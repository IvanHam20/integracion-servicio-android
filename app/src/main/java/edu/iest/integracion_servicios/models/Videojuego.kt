package edu.iest.integracion_servicios.models

data class Videojuego(
    var id: Int,
    var nombre: String,
    var precio: Float,
    var consola: String,
    var imagen: Int,
    var clasificacion: String
)
