package com.example.cloudhotelroomreservationapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudhotelroomreservationapp.R
import com.example.cloudhotelroomreservationapp.data.Rooms
import com.google.android.material.imageview.ShapeableImageView

class RoomAdapter(private val roomList: ArrayList<Rooms>):RecyclerView.Adapter<RoomAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.roomslayout,parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = roomList[position]
        holder.roomName.text= currentItem.roomName
    }

    override fun getItemCount(): Int {

        return roomList.size
    }
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val roomImage:ShapeableImageView = itemView.findViewById(R.id.room_img)

        val roomName:TextView = itemView.findViewById(R.id.room_name)
    }
}