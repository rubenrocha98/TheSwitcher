package com.example.theSwitcher.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.theSwitcher.model.Room
import com.example.theswitcher_rubenrocha.R

class RoomListAdapter(
    private val onItemClicked: (data: Room) -> Unit,
    private val context: Context
) : Adapter<RoomListAdapter.RoomViewHolder>() {

    private val roomsList: MutableList<Room> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        return RoomViewHolder(
            LayoutInflater.from(context).inflate(R.layout.room_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int = roomsList.size

    fun setRoomList(rooms: List<Room>) {
        roomsList.clear()
        roomsList.addAll(rooms)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bind(roomsList[position])
    }

    inner class RoomViewHolder(itemView: View) : ViewHolder(itemView) {
        private val switch: SwitchCompat = itemView.findViewById(R.id.lightSwitch)
        private val roomText: TextView = itemView.findViewById(R.id.roomName)
        fun bind(data: Room) {
            roomText.text = data.roomName
            switch.isChecked = data.lightOn
            switch.setOnClickListener { data.lightOn = (it as SwitchCompat).isChecked }
            itemView.setOnClickListener { onItemClicked(data) }
        }
    }
}