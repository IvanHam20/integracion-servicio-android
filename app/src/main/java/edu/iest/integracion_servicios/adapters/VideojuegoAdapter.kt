package edu.iest.integracion_servicios.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import edu.iest.integracion_servicios.R
import edu.iest.integracion_servicios.models.Videojuego

class VideojuegoAdapter(videojuegos: ArrayList<Videojuego>, context: Context) : RecyclerView.Adapter<VideojuegoAdapter.ContenedorDeVista>() {

    var inner_videojuegos: ArrayList<Videojuego> = videojuegos
    var inner_context: Context = context

    inner class ContenedorDeVista(view: View) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
        //aqui haremos el inflate del layout
        val tvNombreJuego: TextView
        val tvPrecio: TextView
        val ivFoto: ImageView
        val tvConsola: TextView
        val tvClasificacion: TextView
        val bnComprar: Button

        init {
            //Define click listener for the ViewHolder's View.
            tvNombreJuego = view.findViewById(R.id.tvNombreJuego)
            tvPrecio = view.findViewById(R.id.tvPrecio)
            ivFoto = view.findViewById(R.id.ivFoto)
            tvConsola = view.findViewById(R.id.tvConsola)
            tvClasificacion = view.findViewById(R.id.tvClasificacion)
            bnComprar = view.findViewById(R.id.bnComprar)

            bnComprar.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            if (adapterPosition >= 0) {
                //Necesario usar contexto
                val miSharedPreferences = inner_context.getSharedPreferences("PERSISTENCIA",
                    AppCompatActivity.MODE_PRIVATE
                )
                val edad = miSharedPreferences.getInt("edad", 0)

                val videojuego: Videojuego = inner_videojuegos.get(adapterPosition)
                if ((videojuego.clasificacion == "R" && edad < 18) || (videojuego.clasificacion == "T" || videojuego.clasificacion == "R") && edad < 5) {
                    Toast.makeText(inner_context, "No se puede comprar el videojuego ${videojuego.nombre}.", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(inner_context, "Compra de ${videojuego.nombre} realizada con exito!", Toast.LENGTH_LONG).show()

                }
            }
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
        holder.tvClasificacion.text = videojuego.clasificacion
        holder.ivFoto.setImageResource(videojuego.imagen)
    }

    override fun getItemCount(): Int {
        return inner_videojuegos.size
    }
}
