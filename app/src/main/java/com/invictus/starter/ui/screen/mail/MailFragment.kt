package com.invictus.starter.ui.screen.mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.invictus.starter.databinding.FragmentMailBinding
import com.invictus.starter.domain.model.HeaderModel
import com.invictus.starter.domain.model.HorizontalListModel
import com.invictus.starter.domain.model.MailModel
import com.invictus.starter.domain.model.RecentMailModel
import com.invictus.starter.ui.navigation.ScreenRoute
import com.invictus.starter.ui.navigation.navigate
import com.invictus.starter.ui.recycler_utils.adapter.MyRecycleAdapter


class MailFragment : Fragment() {
    private var _binding: FragmentMailBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<MailsViewModel>()
    private val adapter = MyRecycleAdapter()

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

        binding.recyclerView.adapter = adapter
        /**
         * Variables for better understanding. SpanCount must be evenly divisible on ColumnCount.
         * For example if you need 1, 2, 3 and 4 columns -> spanCount will be = 12.
         */
        val spanCount = 2
        val oneColumn = spanCount / 1
        val twoColumns = spanCount / 2
        val layoutManager = GridLayoutManager(requireContext(), spanCount)

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.currentList.getOrNull(position)) {
                    is HorizontalListModel -> oneColumn
                    is HeaderModel -> oneColumn
                    else -> twoColumns
                }
            }

        }

        binding.recyclerView.layoutManager = layoutManager

        adapter.setOnItemClickListener { model ->
            if (model is MailModel) {
                navController.navigate(ScreenRoute.MailDetails(model.id))
            }

            if (model is HorizontalListModel) {
                println(model)
            }

            if (model is RecentMailModel) {
                println(model.name)
            }
        }

        viewModel.mails.observe(viewLifecycleOwner) { mails ->
            adapter.submitList(mails)
        }

        binding.composeBtn.setOnClickListener {
            navController.navigate(ScreenRoute.Compose)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}