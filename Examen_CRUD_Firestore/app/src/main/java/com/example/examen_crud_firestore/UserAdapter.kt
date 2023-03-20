package com.example.examen_crud_firestore

import android.util.TypedValue
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_crud_firestore.model.User

class UserAdapter(
    private val mContext: CRUDUser,
    private val listaUsers: ArrayList<User>,
) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener{

        val idTextView: TextView

        val nombreTextView: TextView
        val apellidoTextView: TextView
        val correoTextView: TextView
        val generoTextView: TextView
        val fechaNacimientoTextView: TextView

        init {
            idTextView = view.findViewById(R.id.tv_idUser)

            nombreTextView = view.findViewById(R.id.tv_nombreUser)
            apellidoTextView = view.findViewById(R.id.tv_apellidoUser)
            correoTextView = view.findViewById(R.id.tv_generUser)
            generoTextView = view.findViewById(R.id.tv_correoUser)
            fechaNacimientoTextView = view.findViewById(R.id.tv_fechaNacimiento)

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
                inflater.inflate(R.menu.menuuser, menu)

                mContext.setSelectedComponentCode(listaUsers[adapterPosition].id)
            }
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapter.MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_user,
                parent,
                false
            )

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {
        val user = this.listaUsers[position]

        holder.idTextView.text = user.id.toString()

        holder.nombreTextView.text = user.nombre
        holder.apellidoTextView.text = user.apellido
        holder.correoTextView.text = user.correo
        holder.generoTextView.text = user.genero
        holder.fechaNacimientoTextView.text = user.fechaNacimiento.toString()
    }

    override fun getItemCount(): Int {
        return this.listaUsers.size
    }
}