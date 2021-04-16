package com.demo.cartrack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.cartrack.R
import com.demo.cartrack.repository.DetailsList


class DetailsAdapter (private val detailsList: List<DetailsList>) : RecyclerView.Adapter<DetailsAdapter.ViewHolder>()
{
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val name = itemView.findViewById<TextView>(R.id.userName)
        val email = itemView.findViewById<Button>(R.id.email)
        val address = itemView.findViewById<Button>(R.id.address)
        val phone = itemView.findViewById<Button>(R.id.phone)
        val website = itemView.findViewById<Button>(R.id.website)
        val company = itemView.findViewById<Button>(R.id.company)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.details_row_component, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: DetailsAdapter.ViewHolder, position: Int) {
        val data: DetailsList = detailsList[position]
        viewHolder.name.text = data.username
        viewHolder.email.text = data.email
        viewHolder.address.text = data.address.city
        viewHolder.phone.text = data.phone
        viewHolder.website.text = data.website
        viewHolder.company.text = data.company.name
    }

    override fun getItemCount(): Int {
        return detailsList.size
    }
}