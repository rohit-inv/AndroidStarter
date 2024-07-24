package com.invictus.starter.ui.screen.compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.invictus.starter.databinding.FragmentComposeBinding

class ComposeFragment : Fragment() {

    private var _binding: FragmentComposeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<ComposeViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComposeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val counter: Button = binding.counter

        viewModel.count.observe(viewLifecycleOwner) { count ->
            counter.text = count.toString()
        }

        counter.setOnClickListener {
            viewModel.count.postValue(
                (viewModel.count.value ?: 0) + 1
            )
        }

    }
}