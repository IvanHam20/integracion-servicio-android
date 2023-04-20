package edu.iest.integracion_servicios.models

import edu.iest.integracion_servicios.R

class FakerVideojuego {

    fun getVideogames() : ArrayList<Videojuego>{
        var videogames : ArrayList<Videojuego>
        videogames = arrayListOf<Videojuego>()

        var videojuego = Videojuego(1, "Pokemon Rojo", 1100F, "Gameboy Advance", R.drawable.pokemon_rojo)
        videogames.add(videojuego)//1
        videogames.add(Videojuego(2, "Pokemon Oro", 1400F, "Gameboy Color", R.drawable.pokemon_oro))
        videogames.add(Videojuego(3, "Pokemon Escarlata", 2000F, "Nintendo Switch", R.drawable.pokemon_escarlata))
        videogames.add(Videojuego(4, "Pokemon Esmeralda", 1200F, "Gameboy Advance", R.drawable.pokemon_esmeralda))
        videogames.add(Videojuego(5, "Pokemon Rubi Omega", 1500F, "Nintendo 3DS", R.drawable.pokemon_rubi_omega))
        videogames.add(Videojuego(6, "Pokemon X", 1300F, "Nintendo 3DS", R.drawable.pokemon_x))
        videogames.add(Videojuego(7, "Pokemon Black Version 2", 1300F, "Nintendo DS", R.drawable.pokemon_black))
        videogames.add(Videojuego(8, "Pokemon Escudo", 1300F, "Nintendo Switch", R.drawable.pokemon_escudo))
        videogames.add(Videojuego(9, "Pokemon Platino", 1300F, "Nintendo DS", R.drawable.pokemon_platino))
        videogames.add(Videojuego(10, "Pokemon Ultrasol", 1300F, "Nintendo 3DS", R.drawable.pokemon_ultrasol))

        return videogames
    }
}