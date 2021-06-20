package com.android.sample.game.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.sample.game.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class InGame : DaggerFragment() {

    @Inject
    lateinit var text: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_in_game, container, false)

        return view
    }
}
