package edu.iest.integracion_servicios.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.iest.integracion_servicios.R
import edu.iest.integracion_servicios.models.Videojuego

class VideojuegoAdapter(
    videojuegos: ArrayList<Videojuego>,
    context: Context) : RecyclerView.Adapter<VideojuegoAdapter.ContenedorDeVista>() {

    var inner_videojuegos: ArrayList<Videojuego> = videojuegos
    var inner_context: Context = context

    inner class ContenedorDeVista(view: View):
        RecyclerView.ViewHolder(view) {
        //aqui haremos el inflate del layout
        val tvNombreJuego : TextView
        val tvPrecio : TextView
        val ivFoto : ImageView
        val tvConsola : TextView
        val bnComprar : Button


        init {
            //Define click listener for the ViewHolder's View.
            tvNombreJuego = view.findViewById(R.id.tvNombreJuego)
            tvPrecio = view.findViewById(R.id.tvPrecio)
            ivFoto = view.findViewById(R.id.ivFoto)
            tvConsola = view.findViewById(R.id.tvConsola)
            bnComprar = view.findViewById(R.id.bnComprar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContenedorDeVista {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main2, parent, false)
        return ContenedorDeVista(view)
    }

    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        val videojuego: Videojuego = inner_videojuegos.get(position)
        holder.tvNombreJuego.text = videojuego.nombre
        holder.tvConsola.text = videojuego.consola
        holder.tvPrecio.text = videojuego.precio.toString()
        holder.ivFoto.setImageResource(videojuego.imagen)
    }

    override fun getItemCount(): Int {
        return inner_videojuegos.size
    }
}