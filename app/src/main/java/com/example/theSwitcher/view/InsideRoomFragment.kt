package com.example.theSwitcher.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.theSwitcher.model.Room
import com.example.theSwitcher.util.getRoom
import com.example.theswitcher_rubenrocha.R
import com.example.theswitcher_rubenrocha.databinding.InsideRoomFragmentBinding

class InsideRoomFragment : Fragment(R.layout.inside_room_fragment) {
    private lateinit var binding: InsideRoomFragmentBinding
    private lateinit var room: Room
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InsideRoomFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        room = requireArguments().getRoom()
        binding.toolbar.apply {
            title = room.roomName
            setNavigationIcon(R.drawable.baseline_arrow_back_24)
            setNavigationOnClickListener { findNavController().popBackStack() }
        }
        binding.roomTextView.text = getString(R.string.room_light_message).format(room.roomName)
        if (room.lightOn){
            binding.imageView.setImageResource(R.drawable.light_on)
            binding.lightTextView.text = getString(R.string.on)
        } else {
            binding.imageView.setImageResource(R.drawable.light_off)
            binding.lightTextView.text = getString(R.string.off)
        }
    }

}