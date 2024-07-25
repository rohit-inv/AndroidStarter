package com.invictus.starter.ui.screen.mail_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.invictus.starter.databinding.FragmentMailDetailsBinding


class MailDetailsFragment : Fragment() {

    private var _binding: FragmentMailDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<MailDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMailDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()


        viewModel.loadMailById(arguments?.getInt("mailId") ?: -1)
        binding.toolbar.backBtn.setOnClickListener {
            navController.navigateUp()
        }
        viewModel.mail.observe(viewLifecycleOwner) { (loading, error, mail) ->
            binding.overlayContainer.isVisible = error != null || loading || mail == null
            binding.progressBar.isVisible = loading
            binding.errorText.isVisible = error != null
            binding.errorText.text = error ?: ""
            mail?.let {
                binding.name.text = mail.name
                binding.logoText.text = mail.name.take(1)
                binding.subject.text = mail.subject
                binding.body.text = mail.body
                binding.time.text = mail.time
                binding.bgImg.setColorFilter(mail.color)
            }


        }

    }

}