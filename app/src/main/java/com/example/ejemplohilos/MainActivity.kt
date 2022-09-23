package com.example.ejemplohilos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplohilos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movie = Movie("La Sirenita",4)
        binding.btnIniciar.setOnClickListener{
            iniciarHilo()
            iniciarProceso() }
    }

    private fun iniciarProceso() {
        //binding.txtDescarga.text = "Iniciando descarga"
        //Thread.sleep(8000)
        //binding.txtDescarga.text = "Finalizando descarga"
        binding.txtEjecucion.text = movie.play()
    }

    private fun iniciarHilo() {
        //Al configurar un hilo es necesario implementar la interfaz RUNNABLE
        //(Comando de instrucciones ejecutable). En Runnable existe el método run().
        //Todo lo que esté dentro de run se ejecutará en un segundo plano
        binding.txtDescarga.text = "Iniciando descarga"
        val hilo = Thread(Runnable {
            try {
                //Acá se implementa directamente el run()
                Thread.sleep(8000)
                //Para conectar la interfaz de usuario desde un hilo, se crea un canal de comunicación.
                runOnUiThread {
                    binding.txtDescarga.text = "Finalizando descarga"
                }
            } catch(e: InterruptedException) {
                e.printStackTrace()
            }
        })
        //Para que el hilo arranque y ejecute todo lo que está en run(), es necesario utilizar el
        //método start()
        hilo.start()
    }
}