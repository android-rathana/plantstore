package com.rathanavoy.plantstore.feature.plant

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.rathanavoy.plantstore.R
import com.rathanavoy.plantstore.core.BaseFragment
import com.rathanavoy.plantstore.databinding.FragmentPlantBinding
import com.rathanavoy.plantstore.intent.PlantDetailIntent
import com.rathanavoy.plantstore.util.extension.getDimen
import com.rathanavoy.plantstore.util.extension.gone
import com.rathanavoy.plantstore.util.extension.visible
import com.rathanavoy.plantstore.view.GridItemDecoration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PlantFragment : BaseFragment<PlantViewModel>(PlantViewModel::class, R.layout.fragment_plant) {

    private lateinit var plantAdapter: PlantAdapter
    private lateinit var binding: FragmentPlantBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlantBinding.bind(view)
        setupRecyclerView()
        collectFlows()
        viewModel.getPlants()
    }


    private fun collectFlows() {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.uiState.collect {
                when (it) {
                    is PlantState.Loading -> binding.loading.root.visible()
                    is PlantState.Finished -> binding.loading.root.gone()
                    is PlantState.Result -> {
                        binding.loading.root.gone()
                        plantAdapter.addMore(it.plants)
                    }
                    is PlantState.Error -> onError(it.exception)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        plantAdapter = PlantAdapter(mutableListOf()) { plant, position ->
            startActivity(PlantDetailIntent(requireContext()))
        }
        binding.list.run {
            layoutManager = GridLayoutManager(requireContext(), 2)
            addItemDecoration(
                GridItemDecoration(
                    requireActivity(),
                    2,
                    context.getDimen(R.dimen.item_grid_margin)
                )
            )
            adapter = plantAdapter
        }
    }

    private fun onError(exception: Exception) {
        binding.loading.root.gone()
    }

}