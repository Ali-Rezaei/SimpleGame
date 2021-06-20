package com.android.sample.game.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.android.sample.game.R
import com.google.android.material.textfield.TextInputLayout
import dagger.android.support.DaggerFragment

class Register : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val userTextLayout = view.findViewById(R.id.user_text_layout) as TextInputLayout
        val userText = view.findViewById(R.id.user_text) as EditText
        view.findViewById<Button>(R.id.register_btn).setOnClickListener {
            if (userText.text.isEmpty()) {
                userTextLayout.error = getString(R.string.question_1)
            } else {
                val destination = RegisterDirections.actionRegisterToInGame(userText.text.trim().toString())
                with(findNavController()) {
                    currentDestination?.getAction(destination.actionId)?.let { navigate(destination) }
                }
            }
        }

        userText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                userTextLayout.error = null
            }
        })

        return view
    }
}
