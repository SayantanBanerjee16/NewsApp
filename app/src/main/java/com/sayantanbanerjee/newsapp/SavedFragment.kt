package com.sayantanbanerjee.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sayantanbanerjee.newsapp.databinding.FragmentSavedBinding
import com.sayantanbanerjee.newsapp.presentation.MainActivity
import com.sayantanbanerjee.newsapp.presentation.adapter.NewsAdapter
import com.sayantanbanerjee.newsapp.presentation.viewmodel.NewsViewModel

class SavedFragment : Fragment() {

    private lateinit var fragmentSavedBinding: FragmentSavedBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var savedAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSavedBinding = FragmentSavedBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        savedAdapter = (activity as MainActivity).newsAdapter

        savedAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable(getString(R.string.selectedItem), it)
            }

            findNavController().navigate(
                R.id.action_savedFragment_to_infoFragment,
                bundle
            )

        }

        initRecyclerView()
        viewModel.getSavedNews().observe(viewLifecycleOwner, {
            savedAdapter.differ.submitList(it)
        })

    }

    private fun initRecyclerView() {
        fragmentSavedBinding.rvSaved.adapter = savedAdapter
        fragmentSavedBinding.rvSaved.layoutManager = LinearLayoutManager(activity)
    }

}