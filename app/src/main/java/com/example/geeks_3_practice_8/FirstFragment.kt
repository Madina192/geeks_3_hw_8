package com.example.geeks_3_practice_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val age = requireActivity().findViewById<EditText>(R.id.editTextAge)
        val buttonNext = requireActivity().findViewById<Button>(R.id.buttonNext)
        buttonNext.setOnClickListener{
            if(age.text.toString().toInt() > 18) {
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            } else {

            }
        }
    }
}