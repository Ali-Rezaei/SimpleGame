package com.android.sample.game.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.android.sample.game.BR
import com.android.sample.game.adapter.GifAdapter
import com.android.sample.game.databinding.FragmentInGameBinding
import com.android.sample.game.viewmodel.InGameViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class InGame : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<InGameViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentInGameBinding.inflate(inflater, container, false).apply {
            setVariable(BR.vm, viewModel)
            // Set the lifecycleOwner so DataBinding can observe LiveData
            lifecycleOwner = viewLifecycleOwner
        }

        with(binding) {
            recyclerView.apply {
                adapter = GifAdapter()
                setHasFixedSize(true)
            }
        }

        return binding.root
    }
}
