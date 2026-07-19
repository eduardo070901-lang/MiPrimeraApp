/**
 * ═══════════════════════════════════════════════════════════════════════════
 *                            Mi Primera App
 *                     Aplicación Android Móvil - 2026
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * DESARROLLADO POR:
 * • Ronald Vasquez Maldonado (Matrícula: 2-14-4287)
 * • Eduardo Del Carmen Rodriguez (Matrícula: 1-22-4217)
 * • Jose Manuel Reyes (Matrícula: 1-21-5110)
 * 
 * DESCRIPCIÓN:
 * Aplicación Android que permite al usuario ingresar su nombre y recibir
 * un saludo personalizado. Demuestra conceptos fundamentales de desarrollo
 * Android incluyendo: actividades, componentes visuales, manejo de eventos
 * y validación de entrada de usuario.
 * 
 * ARCHIVO: MainActivity.kt
 * RESPONSABLE: Jose Manuel Reyes (Lógica y funcionalidad)
 * ÚLTIMA MODIFICACIÓN: 18 de Julio de 2026
 * ═══════════════════════════════════════════════════════════════════════════
 */

package com.example.miprimeraapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)
        tvMensaje.text = getString(R.string.bienvenido)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnSaludar.setOnClickListener {
            val nombre = etNombre.text.toString()
            if (nombre.isNotEmpty()) {
                tvMensaje.text = getString(R.string.hola_mensaje, nombre)
            } else {
                tvMensaje.text = getString(R.string.hola)
            }
        }
    }
}
