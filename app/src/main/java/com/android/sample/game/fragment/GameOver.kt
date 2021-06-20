package com.android.sample.game.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.android.sample.game.R


/**
 * Shows a game over screen and a button to start over.
 */
class GameOver : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game_over, container, false)

        view.findViewById<View>(R.id.play_btn4).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_game_over_to_match)
        }
        return view
    }
}
