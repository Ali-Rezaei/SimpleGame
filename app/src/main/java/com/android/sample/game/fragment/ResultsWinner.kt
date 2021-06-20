package com.android.sample.game.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.android.sample.game.R

/**
 * Shows the winning screen.
 */
class ResultsWinner : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_results_winner, container, false)

        view.findViewById<Button>(R.id.play_btn2).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_results_winner_to_match)
        }

        return view
    }
}
