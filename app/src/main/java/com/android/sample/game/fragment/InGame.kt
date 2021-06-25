package com.android.sample.game.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.android.sample.game.BR
import com.android.sample.game.R
import com.android.sample.game.adapter.GifAdapter
import com.android.sample.game.databinding.FragmentInGameBinding
import com.android.sample.game.viewmodel.InGameViewModel
import dagger.android.support.DaggerFragment
import org.apache.commons.lang3.StringUtils
import javax.inject.Inject
import kotlin.math.roundToInt

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

        val args: InGameArgs by navArgs()

        with(binding) {
            recyclerView.apply {
                adapter = GifAdapter()
                setHasFixedSize(true)
            }
            registerBtn.setOnClickListener {
                if (userGuess.text.isEmpty()) {
                    userGuessLayout.error = getString(R.string.guess_error)
                } else {
                    val score = (StringUtils.getJaroWinklerDistance(args.query, userGuess.text.trim()) * 100).roundToInt()
                    if (score >= WINNING_SCORE) {
                        Navigation.findNavController(root)
                            .navigate(R.id.action_in_game_to_resultsWinner)
                    } else {
                        Navigation.findNavController(root)
                            .navigate(R.id.action_in_game_to_gameOver)
                    }
                }
            }
            userGuess.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {}
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    userGuessLayout.error = null
                }
            })
        }
        return binding.root
    }

    companion object {
        private const val WINNING_SCORE = 80
    }
}
