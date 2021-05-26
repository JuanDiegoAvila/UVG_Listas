package com.uvg.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_lista.*

class MainActivity : AppCompatActivity(){
    var contador = 0;
    private val adaptador = Adaptador ({ clickListener -> onItemClicked(clickListener)
    },{longClickListener -> onItemLongClicked(longClickListener)})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items : MutableList<String> = mutableListOf()

        btnAdd.setOnClickListener {
            contador++;
            items.add("Prueba "+contador)
            adaptador.setItems(items)
            lista.layoutManager = LinearLayoutManager(this)
            lista.adapter = adaptador
        }
        
        

        adaptador.setItems(items)
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador
    }

    private fun onItemClicked(position:Int){
        adaptador.remove(position)
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador
    }
    private fun onItemLongClicked(position:Int){
        adaptador.set(position,"Actualizado")
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador
    }

}