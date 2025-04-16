package com.firstapp.legalincentivemarketplace.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.legalincentivemarketplace.R

class RequestsAdapter(private val requests: List<LegalRequest>) :
    RecyclerView.Adapter<RequestsAdapter.RequestViewHolder>() {

    // ViewHolder holds the views for each item
    class RequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.requestTitle)
        val descText: TextView = itemView.findViewById(R.id.requestDescription)
        val dateText: TextView = itemView.findViewById(R.id.requestDate)
    }

    // Inflates the layout for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_legal_request, parent, false)
        return RequestViewHolder(view)
    }

    // Binds data to views for each item
    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        val request = requests[position]
        holder.titleText.text = request.title
        holder.descText.text = request.description
    }

    override fun getItemCount(): Int = requests.size
}
