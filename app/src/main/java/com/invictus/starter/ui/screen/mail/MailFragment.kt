package com.invictus.starter.ui.screen.mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.invictus.starter.MailAdapter
import com.invictus.starter.databinding.FragmentMailBinding


class MailFragment : Fragment() {
    private var _binding: FragmentMailBinding? = null
    private val binding get() = _binding!!


    private val viewModel by viewModels<MailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        binding.listView.adapter = MailAdapter(emptyList())

        viewModel.mails.observe(viewLifecycleOwner) { mails ->
            binding.listView.adapter = MailAdapter(mails)
        }



        binding.composeBtn.setOnClickListener {
            navController.navigate("compose")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}