package edu.iest.integracion_servicios

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.*
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {

    private lateinit var tvBienvenido: TextView
    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etAltura: EditText
    private lateinit var etMonedero: EditText
    private lateinit var bnGuardar: Button
    private lateinit var swPreferencias: Switch
    private val NOMBRE_KEY = "nombre"
    private val SWITCH_KEY = "switch_estado"
    private val EDAD_KEY = "edad"
    private val ALTURA_KEY = "altura"
    private val MONEDERO_KEY = "monedero"
    private val NOMBRE_INSTANCIA = "nombre_instancia"
    private var nombre: String = ""
    private var edad: Int = 0
    private var altura: Float = 0F
    private var monedero: Float = 0F
    private var isChecked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PREFERENCIAS", "onCreate")

        var actionBar: ActionBar?
        actionBar = supportActionBar
        var colorDrawable: ColorDrawable
        colorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
        actionBar!!.setBackgroundDrawable(colorDrawable)

        inicializarVistas()

        Log.d("PREFERENCIAS", savedInstanceState?.getString(NOMBRE_KEY).toString())
        //nombre = savedInstanceState?.getString(NOMBRE_KEY).toString()

        val swPreferencias = findViewById<Switch>(R.id.swPreferencias)
        swPreferencias.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            isChecked = !isChecked
            Log.d("Datos", "Tus preferencias se guardan? $isChecked")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("PREFERENCIAS", "onSaveInstanceState")
        outState.putString(NOMBRE_KEY, nombre )
        outState?.run {
            putString(NOMBRE_KEY, nombre)
            putInt(EDAD_KEY, edad)
            putFloat(ALTURA_KEY, altura)
            putFloat(MONEDERO_KEY, monedero)
        }
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)

    }

    override fun onResume() {
        Log.d("PREFERENCIAS", "onResume")
        if(TextUtils.isEmpty(nombre)){
            val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            nombre = miSharedPreferences.getString(NOMBRE_KEY, "").toString()
            edad = miSharedPreferences.getInt(EDAD_KEY, 0)
            altura = miSharedPreferences.getFloat(ALTURA_KEY, 0F)
            monedero = miSharedPreferences.getFloat(MONEDERO_KEY, 0F)
        }

        tvBienvenido.text = "Bienvenido $nombre"
        etNombre.setText(nombre)
        etEdad.setText(edad.toString())
        etAltura.setText(altura.toString())
        etMonedero.setText(monedero.toString())
        super.onResume()
    }

    override fun onStart() {
        Log.d("PREFERENCIAS", "onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.d("PREFERENCIAS", "onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("PREFERENCIAS", "onDestroy")
        super.onDestroy()
    }

    private fun cambiarTextoBienvenida(nombre: String) {
        if (!TextUtils.isEmpty(nombre)) {
            tvBienvenido.text = "Bienvenido " + nombre
        }
    }

    private fun inicializarVistas() {
        tvBienvenido = findViewById(R.id.tvBienvenido)
        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etAltura = findViewById(R.id.etAltura)
        etMonedero = findViewById(R.id.etMonedero)
        bnGuardar = findViewById(R.id.bnGuardar)
        swPreferencias = findViewById(R.id.swPreferencias)

        bnGuardar.setOnClickListener {
            try {
                nombre = etNombre.text.toString()
                edad = etEdad.text.toString().toInt()
                altura = etAltura.text.toString().toFloat()
                monedero = etMonedero.text.toString().toFloat()
                cambiarTextoBienvenida(nombre)
                val i = Intent(this, ListaJuegosActivity::class.java)
                if (isChecked){
                    val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
                    val editor = miSharedPreferences.edit()
                    editor.putBoolean(SWITCH_KEY, isChecked)
                    editor.putString(NOMBRE_KEY, nombre)
                    editor.putInt(EDAD_KEY, edad)
                    editor.putFloat(ALTURA_KEY, altura)
                    editor.putFloat(MONEDERO_KEY, monedero)
                    editor.apply()
                }else{
                    val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
                    val editor = miSharedPreferences.edit()
                    editor.putBoolean(SWITCH_KEY, isChecked)
                    editor.apply()
                }
                startActivity(i)
            } catch (e: java.lang.NumberFormatException) {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show()
            }
        }
    }
}