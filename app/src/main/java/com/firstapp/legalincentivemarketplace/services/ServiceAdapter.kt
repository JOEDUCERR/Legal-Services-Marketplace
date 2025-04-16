package com.legalservices.marketplace.ui.services

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.legalincentivemarketplace.R
import com.firstapp.legalincentivemarketplace.models.LegalService
import com.firstapp.legalincentivemarketplace.models.ServiceStatus
import com.google.android.material.chip.Chip
import java.text.NumberFormat
import java.util.Locale

class ServiceAdapter(
    private var services: List<LegalService>,
    private val onItemClick: (LegalService) -> Unit
) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    class ServiceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.serviceTitle)
        val providerText: TextView = view.findViewById(R.id.serviceProvider)
        val descriptionText: TextView = view.findViewById(R.id.serviceDescription)
        val priceText: TextView = view.findViewById(R.id.servicePrice)
        val statusChip: Chip = view.findViewById(R.id.statusChip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_service, parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val service = services[position]
        holder.titleText.text = service.title
        holder.providerText.text = "${service.providerName} (${service.providerType})"
        holder.descriptionText.text = service.description

        val formatter = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
        holder.priceText.text = formatter.format(service.price)

        holder.statusChip.text = service.status.name
        val statusColor = when (service.status) {
            ServiceStatus.ACTIVE -> android.R.color.holo_green_light
            ServiceStatus.COMPLETED -> android.R.color.holo_blue_light
            ServiceStatus.PENDING -> android.R.color.holo_orange_light
        }
        holder.statusChip.setChipBackgroundColorResource(statusColor)

        holder.itemView.setOnClickListener { onItemClick(service) }
    }

    override fun getItemCount() = services.size

    fun updateServices(newServices: List<LegalService>) {
        services = newServices
        notifyDataSetChanged()
    }
}
