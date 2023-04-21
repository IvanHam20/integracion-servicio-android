package edu.iest.integracion_servicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iest.integracion_servicios.adapters.VideojuegoAdapter
import edu.iest.integracion_servicios.models.FakerVideojuego

class ListaJuegosActivity : AppCompatActivity() {

    private lateinit var bnCol1: Button
    private lateinit var bnCol2: Button
    private lateinit var bnCol3: Button
    private lateinit var bnVertical: Button
    private lateinit var bnHorizontal: Button
    private var nombre: String = ""
    private var edad: Int = 0
    private var altura: Float = 0F
    private var monedero: Float = 0F
    private var isChecked: Boolean = false
    private var cantidadColumnas = 1
    private var orientacion = GridLayoutManager.VERTICAL
    private lateinit var administradorDeLayouts: GridLayoutManager
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_juegos)

        val juegos = FakerVideojuego().getVideogames()
        recycler = findViewById<RecyclerView>(R.id.recyclerJuegos)

        bnCol1 = findViewById(R.id.bnCol1)
        bnCol2 = findViewById(R.id.bnCol2)
        bnCol3 = findViewById(R.id.bnCol3)
        bnVertical = findViewById(R.id.bnVertical)
        bnHorizontal = findViewById(R.id.bnHorizontal)

        administradorDeLayouts = GridLayoutManager(this, cantidadColumnas, orientacion, false)
        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = VideojuegoAdapter(juegos, this)

        bnCol1.setOnClickListener{
            cantidadColumnas = 1
            actualizarLayout()
        }

        bnCol2.setOnClickListener{
            cantidadColumnas = 2
            actualizarLayout()
        }

        bnCol3.setOnClickListener{
            cantidadColumnas = 3
            actualizarLayout()
        }

        bnVertical.setOnClickListener{
            orientacion = GridLayoutManager.VERTICAL
            actualizarLayout()
        }

        bnHorizontal.setOnClickListener{
            orientacion = GridLayoutManager.HORIZONTAL
            actualizarLayout()
        }

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            val i = Intent(this, MainActivity3::class.java)
            if (!isChecked){
                i.putExtra("nombre", nombre)
                i.putExtra("edad", edad)
                i.putExtra("altura", altura)
                i.putExtra("monedero", monedero)
            }
            startActivity(i)
        }
    }

    private fun actualizarLayout() {
        administradorDeLayouts = GridLayoutManager(this, cantidadColumnas, orientacion, false)
        recycler.layoutManager = administradorDeLayouts
    }
}
