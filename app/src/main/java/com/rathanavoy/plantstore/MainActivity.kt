package com.rathanavoy.plantstore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rathanavoy.plantstore.databinding.ActivityMainBinding
import com.rathanavoy.plantstore.entity.Animal
import com.rathanavoy.plantstore.repository.local.MockAnimalRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val repository by lazy { MockAnimalRepositoryImpl() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerListeners()

    }

    private fun registerListeners() {
        binding.btnGet.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                getAnimals()
            }
        }
    }

    private suspend fun getAnimals() {
        val data = repository.getAnimals()
        onResult(data)
    }

    private suspend fun onResult(animals: List<Animal>) {
        withContext(Dispatchers.Main) {
            for (i in animals.indices) {
                if (indexCopied >= animals.size) indexCopied = 0
                if (i == indexCopied) {
                    val animal = animals[i]
                    val display = "ID: ${animal.id} \n Name: ${animal.name}"
                    binding.txtDisplay.text = display
                    indexCopied++
                    break
                }
            }

        }
    }

    companion object {
        private var indexCopied = 0
    }
}