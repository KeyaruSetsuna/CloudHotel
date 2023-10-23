package com.example.cloudhotelroomreservationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudhotelroomreservationapp.adapters.RoomAdapter
import com.example.cloudhotelroomreservationapp.data.Rooms
import com.example.cloudhotelroomreservationapp.databinding.FragmentHomepageBinding

class HomepageFragment : Fragment(R.layout.fragment_homepage) {
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var adapter: RoomAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var roomsArrayList: ArrayList<Rooms>
    lateinit var imageId: Array<Int>
    lateinit var nameId: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)

        binding.profile.setOnClickListener {
            findNavController().navigate(R.id.action_homepageFragment_to_profileFragment)
        }

            return binding.root

    }

    override fun onViewCreated(view:View,savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        dataInitialized()
        val layoutManager = LinearLayoutManager(context)

        recyclerView = view.findViewById(R.id.recycler_view)

        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RoomAdapter(roomsArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialized() {

        roomsArrayList = arrayListOf<Rooms>()

            imageId = arrayOf(
                R.drawable.hotel1,
                R.drawable.hotel2,
                R.drawable.hotel3,
                R.drawable.room4,
                R.drawable.hotel4,
                R.drawable.hotel5,
                R.drawable.backk,
                R.drawable.backk,
                R.drawable.backk,
                R.drawable.backk
            )

            nameId = arrayOf(
                getString(R.string.room_1),
                getString(R.string.room_2),
                getString(R.string.room_3),
                getString(R.string.room_4),
                getString(R.string.room_5),
                getString(R.string.room_6),
                getString(R.string.room_7),
                getString(R.string.room_8),
                getString(R.string.room_9),
                getString(R.string.room_10)
            )

            for (i in imageId.indices){

                val rooms = Rooms(imageId[i],nameId[i])

                roomsArrayList.add(rooms)
            }

    }
}
