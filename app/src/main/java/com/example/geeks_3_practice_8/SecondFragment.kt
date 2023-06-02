package com.example.geeks_3_practice_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondFragment : Fragment() {

    lateinit var buttonSave : Button
    private lateinit var questionGpa : EditText
    private lateinit var questionSchool : EditText
    private lateinit var questionMarriage : EditText

    private lateinit var gpaAnswers : Array<String>
    private lateinit var schoolAnswers : Array<String>
    private lateinit var marriageAnswers : Array<String>

    var isAnswersCorrect = false
    private val bottomSuccessFragment = BottomSuccessFragment()
    private val bottomCancelFragment = BottomCancelFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findViews()
        createArrays()

        buttonSave.setOnClickListener{
            compareAnswers()
        }
    }

    private fun findViews(){
        buttonSave = requireActivity().findViewById(R.id.buttonSave)
        questionGpa = requireActivity().findViewById(R.id.editTextGPA)
        questionSchool = requireActivity().findViewById(R.id.editTextSchool)
        questionMarriage = requireActivity().findViewById(R.id.editTextMarriage)
    }

    private fun createArrays(){
        gpaAnswers = arrayOf("85", "87", "eighty five", "eighty seven")
        schoolAnswers = arrayOf("no", "нет", "не согласен", "не так", "нет конечно")
        marriageAnswers = arrayOf("18", "eighteen", "восемнадцать")
    }

    private fun compareAnswers() {
        checkBlanks()
        if(questionGpa.text.toString().isEmpty() || questionSchool.text.toString().isEmpty() || questionMarriage.text.toString().isEmpty()) {
            Toast.makeText(context, "Fill in all the blanks!", Toast.LENGTH_SHORT).show()
        }else if(isAnswersCorrect) {
            bottomSuccessFragment.show(requireActivity().supportFragmentManager, "second")
        } else {
            bottomCancelFragment.show(requireActivity().supportFragmentManager, "second")
        }
    }

    private fun checkBlanks(){
        isAnswersCorrect = gpaAnswers.contains(questionGpa.text.toString()) && schoolAnswers.contains(questionSchool.text.toString()) && marriageAnswers.contains(questionMarriage.text.toString())
    }

}