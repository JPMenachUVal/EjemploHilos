package com.example.ejemplohilos

class Movie(
    private val name: String,
    val duration: Int,
) {
    fun play(): String {
        var mensaje = ""
        for (i in 0 .. duration)
            mensaje += "Playing movie $name \n"
        return mensaje
    }
}