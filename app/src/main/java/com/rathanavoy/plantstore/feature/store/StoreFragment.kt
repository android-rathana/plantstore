package com.rathanavoy.plantstore.feature.store

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.rathanavoy.plantstore.R
import com.rathanavoy.plantstore.core.BaseFragment
import com.rathanavoy.plantstore.databinding.FragmentStoreBinding
import com.rathanavoy.plantstore.intent.PlantIntent
import com.rathanavoy.plantstore.util.extension.gone
import com.rathanavoy.plantstore.util.extension.visible
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class StoreFragment : BaseFragment<StoreViewModel>(StoreViewModel::class, R.layout.fragment_store) {

    private lateinit var storeAdapter: StoreAdapter
    private lateinit var binding: FragmentStoreBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentStoreBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        setupStoreRecyclerView()
        flowCollection()
        viewModel.getStores()
    }

    private fun flowCollection() {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.uiState.collectLatest {
                when (it) {
                    is StoreState.Loading -> binding.loading.root.visible()
                    is StoreState.Result -> {
                        storeAdapter.addMore(it.stores)
                        binding.loading.root.gone()
                    }
                    is StoreState.Error -> onError(it.exception)
                }
            }
        }

    }

    private fun setupStoreRecyclerView() {
        storeAdapter = StoreAdapter(mutableListOf()) { item, position ->
            startActivity(PlantIntent(requireContext(), item.id))
        }
        binding.list.layoutManager = LinearLayoutManager(requireContext())
        binding.list.adapter = storeAdapter
    }

    private fun onError(e: Exception) {
        binding.loading.root.gone()
    }
}