package edu.iest.integracion_servicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iest.integracion_servicios.adapters.VideojuegoAdapter
import edu.iest.integracion_servicios.models.FakerVideojuego

class ListaJuegosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_juegos)

        val juegos = FakerVideojuego().getVideogames()
        val recycler = findViewById<RecyclerView>(R.id.recyclerJuegos)

        val CANTIDAD_COLUMNAS = 2
        val administradorDeLayouts = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        //LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //GridLayoutManager(this, CANTIDAD_COLUMNAS)
        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = VideojuegoAdapter(juegos,this)
    }
}