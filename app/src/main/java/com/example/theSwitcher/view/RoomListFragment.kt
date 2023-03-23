package com.example.theSwitcher.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.theSwitcher.adapter.RoomListAdapter
import com.example.theSwitcher.model.Room
import com.example.theSwitcher.util.Util
import com.example.theSwitcher.viewmodel.RoomsViewModel
import com.example.theswitcher_rubenrocha.R
import com.example.theswitcher_rubenrocha.databinding.RoomsListFragmentBinding

class RoomListFragment : Fragment(R.layout.rooms_list_fragment) {
    private lateinit var binding: RoomsListFragmentBinding
    private lateinit var roomList: List<Room>
    private lateinit var roomsViewModel: RoomsViewModel
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
        roomsViewModel = ViewModelProvider(this)[RoomsViewModel::class.java]
        setupList()
    }

    //create and setup list adapter
    private fun setupList() {
        val roomListAdapter = RoomListAdapter(::onRoomClicked, requireContext())
        roomList = roomsViewModel.getRoomList()
        roomListAdapter.setRoomList(roomList)
        binding.listView.apply {
            adapter = roomListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


    //callback function for when a room is clicked
    private fun onRoomClicked(data: Room) {
        val bundle = Bundle()
        bundle.putParcelable(Util.ARGUMENT_ROOM, data)
        roomsViewModel.saveRoomList(roomList)
        findNavController().navigate(R.id.action_roomsListFragment_to_insideRoomFragment, bundle)
    }

}