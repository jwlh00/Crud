package com.uvg.listas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*
import java.security.PrivilegedAction

class Adaptador(private val clickListener:(Int) -> Unit): RecyclerView.Adapter<Adaptador.ItemsViewHolder>() {
    private var items: MutableList<String> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_lista,parent,false)
        return ItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val item=items[position]
        holder.bin(item,clickListener)
    }
    fun setItems( nuevosItems: MutableList<String>){
        this.items=nuevosItems
        notifyDataSetChanged()
    }
    fun getItem(position: Int):String{
        return items[position]
    }

    fun getList():MutableList<String>{
        return items
    }



    class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bin(item: String,lisener:(Int)->Unit)= with(itemView){
            txtTitulo.text=item
            setOnClickListener{lisener(adapterPosition)
                txtTitulo.text="Modificado"

            }
            setOnLongClickListener {
                txtTitulo.text = "Modificado"
                true
            }


        }

    }

    override fun getItemCount(): Int {
        return items.size;

    }

    fun delete(position: Int){
        items.removeAt(position)
    }

}