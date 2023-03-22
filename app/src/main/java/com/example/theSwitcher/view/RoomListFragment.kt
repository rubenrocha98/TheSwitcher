package com.example.theSwitcher.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.theSwitcher.adapter.RoomListAdapter
import com.example.theSwitcher.model.Room
import com.example.theSwitcher.util.Util
import com.example.theswitcher_rubenrocha.R
import com.example.theswitcher_rubenrocha.databinding.RoomsListFragmentBinding

class RoomListFragment : Fragment(R.layout.rooms_list_fragment) {
    private lateinit var binding: RoomsListFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RoomsListFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
    }

    private fun setupList() {
        val roomListAdapter = RoomListAdapter(::onRoomClicked, requireContext())
        roomListAdapter.setRoomList(getRoomList())
        binding.listView.apply {
            adapter = roomListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


    //function to get list of rooms (mocked so far)
    private fun getRoomList(): List<Room> {
        val roomsList: MutableList<Room> = mutableListOf()
        roomsList.add(Room("Kitchen"))
        roomsList.add(Room("Living room"))
        roomsList.add(Room("Master bedroom"))
        roomsList.add(Room("Guest's bedroom"))
        return roomsList
    }


    private fun onRoomClicked(data: Room) {
        val bundle = Bundle()
        bundle.putParcelable(Util.ARG_LIGHT, data)
        findNavController().navigate(R.id.action_roomsListFragment_to_insideRoomFragment, bundle)
    }

}