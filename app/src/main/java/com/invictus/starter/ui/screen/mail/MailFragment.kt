package com.invictus.starter.ui.screen.mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.invictus.starter.databinding.FragmentMailBinding
import com.invictus.starter.ui.navigation.Screen
import com.invictus.starter.ui.recycler_utils.adapter.MyRecycleAdapter


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
        val myRecycleAdapter = MyRecycleAdapter()
        binding.listView.adapter = myRecycleAdapter
        myRecycleAdapter.setOnItemClickListener { _ ->
            navController.navigate(Screen.MailDetails.route)
        }

        viewModel.mails.observe(viewLifecycleOwner) { mails ->
            myRecycleAdapter.saveData(mails)
        }

        binding.composeBtn.setOnClickListener {
            navController.navigate(Screen.Compose.route)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}