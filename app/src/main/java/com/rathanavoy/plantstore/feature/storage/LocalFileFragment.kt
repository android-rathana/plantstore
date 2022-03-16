package com.rathanavoy.plantstore.feature.storage

import android.os.Bundle
import android.view.View
import com.rathanavoy.plantstore.R
import com.rathanavoy.plantstore.core.BaseFragment
import com.rathanavoy.plantstore.core.BaseViewModel
import com.rathanavoy.plantstore.databinding.FragmentLocalFileBinding
import com.rathanavoy.plantstore.util.FileUtil
import com.rathanavoy.plantstore.util.extension.gone
import com.rathanavoy.plantstore.util.extension.visible
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalFileFragment :
    BaseFragment<BaseViewModel>(BaseViewModel::class, R.layout.fragment_local_file) {

    private lateinit var binding: FragmentLocalFileBinding
    private var startTime: Long = 0L
    private var endTime: Long = 0L
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLocalFileBinding.bind(view)

        binding.btnWriteFile.setOnClickListener {
            writeFile(FILE_CONTENT, 10000)
        }
    }

    private fun writeFile(content: String, loop: Int = 1) {
        showLoading()
        startTime = System.currentTimeMillis()
        CoroutineScope(Dispatchers.IO).launch {
            val file = FileUtil.createCacheFile(requireContext(), FILE_NAME)
            var contentString = ""
            for (i in 0..loop) {
                contentString += content
            }
            FileUtil.writeFile(file, contentString.toByteArray())
            writeFinished()
        }
    }

    private fun writeFinished() {
        CoroutineScope(Dispatchers.Main).launch {
            hideLoading()
            endTime = System.currentTimeMillis()
            val duration = (endTime - startTime) / 1000
            showToastMessage("Finished in $duration")
            startTime = 0
            endTime = 0
        }
    }

    private fun showLoading() = binding.loading.root.visible()

    private fun hideLoading() = binding.loading.root.gone()

    companion object {
        const val FILE_NAME = "history_book.txt"
        const val FILE_CONTENT =
            "Coroutine cancellation is cooperative. A coroutine code has to cooperate to be cancellable. All the suspending functions in kotlinx.coroutines are cancellable."
    }

}