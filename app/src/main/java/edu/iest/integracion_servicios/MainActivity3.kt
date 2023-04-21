package edu.iest.integracion_servicios

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    private lateinit var tvNombre: TextView
    private lateinit var tvEdad: TextView
    private lateinit var tvAltura: TextView
    private lateinit var tvMonedero: TextView
    private lateinit var bnRegresar: Button
    private var nombre: String = ""
    private var edad: Int = 0
    private var altura: Float = 0F
    private var monedero: Float = 0F
    private var isChecked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        bnRegresar = findViewById(R.id.bnRegresar)
        bnRegresar.setOnClickListener{
            val i = Intent(this, ListaJuegosActivity::class.java)
            startActivity(i)
        }

        val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
        isChecked = miSharedPreferences.getBoolean("switch_estado", true)

        if (isChecked){
            nombre = miSharedPreferences.getString("nombre", "Nombre").toString()
            edad = miSharedPreferences.getInt("edad", 0)
            altura = miSharedPreferences.getFloat("altura", 0F)
            monedero = miSharedPreferences.getFloat("monedero", 0F)
        }

        Log.d("Datos", nombre)

        tvNombre = findViewById(R.id.tvNombre)
        tvNombre.setText(nombre)
        tvEdad = findViewById(R.id.tvEdad)
        tvEdad.setText(edad.toString())
        tvAltura = findViewById(R.id.tvAltura)
        tvAltura.setText(altura.toString())
        tvMonedero = findViewById(R.id.tvMonedero)
        tvMonedero.setText(monedero.toString())
    }
}