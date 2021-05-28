package com.uvg.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dalvik.system.DelegateLastClassLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adaptador=Adaptador({clickListener -> Remove(clickListener)})
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items: MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")
        adaptador.setItems(items)

        lista.layoutManager=LinearLayoutManager(this)
        lista.adapter=adaptador
        CreateBtn.setOnClickListener {
            items.add("Prueba1")
            adaptador.setItems(items)
            lista.layoutManager=LinearLayoutManager(this)
            lista.adapter=adaptador
        }



    }
    fun showItemClick(position: Int){
        val item=adaptador.getItem(position)
        Toast.makeText(this,item,Toast.LENGTH_SHORT).show()



    }
    fun Remove(position: Int){
        var items: MutableList<String> = adaptador.getList()
        items.removeAt(position)
        adaptador.setItems(items)
        lista.layoutManager=LinearLayoutManager(this)
        lista.adapter=adaptador
    }



}