package com.example.examen_crud_firestore

import android.util.TypedValue
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_crud_firestore.model.Aplicacion

class AplicacionAdapter(
    private val mContext: CRUDAplicacion,
    private val listaAplicaciones: ArrayList<Aplicacion>,
) : RecyclerView.Adapter<AplicacionAdapter.MyViewHolder>(){

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {

        val idTextView: TextView
        val nombreTextView: TextView
        val descripcionTextView: TextView
        val versionTextView: TextView
        val fecha_lanzamientoTextView: TextView

        init {
            idTextView = view.findViewById(R.id.tv_idAplicacion)
            nombreTextView = view.findViewById(R.id.tv_nombreAplicacion)
            descripcionTextView = view.findViewById(R.id.tv_descripcion)
            versionTextView = view.findViewById(R.id.tv_version)
            fecha_lanzamientoTextView = view.findViewById(R.id.tv_fecha_lanzamiento)

            view.setOnCreateContextMenuListener(this)

            // Setting the view selection mode
            itemView.isClickable = true
            itemView.isLongClickable = true

            // Setting the style
            val typedValue = TypedValue()
            itemView.context.theme.resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true)
            itemView.setBackgroundResource(typedValue.resourceId)
        }
        override fun onCreateContextMenu(
            menu: ContextMenu?,
            view: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            if (menu != null) {
                val inflater = MenuInflater(view?.context)
                inflater.inflate(R.menu.menuaplicacion, menu)

                mContext.setSelectedAplicacionId(listaAplicaciones[adapterPosition].id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_aplicacion,
                parent,
                false
            )

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return this.listaAplicaciones.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val aplicacion = this.listaAplicaciones[position]

        holder.idTextView.text = aplicacion.id.toString()
        holder.nombreTextView.text = aplicacion.nombre
        holder.descripcionTextView.text = aplicacion.descripcion
        holder.versionTextView.text = aplicacion.version
        holder.fecha_lanzamientoTextView.text = aplicacion.fecha_lanzamiento.toString()
    }
}