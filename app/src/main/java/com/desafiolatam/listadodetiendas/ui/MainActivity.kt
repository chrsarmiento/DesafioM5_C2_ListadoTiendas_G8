package com.desafiolatam.listadodetiendas.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.desafiolatam.listadodetiendas.adapter.StoreAdapter
import com.desafiolatam.listadodetiendas.data.StoreRepository
import com.desafiolatam.listadodetiendas.databinding.ActivityMainBinding
import com.desafiolatam.listadodetiendas.model.Store
import com.desafiolatam.listadodetiendas.model.StoreViewModel
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: StoreViewModel by viewModels()

    private lateinit var adapter: StoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenCreated {
            viewModel.getStoreList().collect {
                initAdapter(it)
            }
        }

        /*
        // Para obtener el listado de tiendas debes ocupar la clase StoreRepository
        // la funcion getStoreList retorna un listado de sucursales
        // Por ejmeplo:

        val storeList = StoreRepository().getStoreList()
        storeList.forEach { store ->
            // Listado de tiendas
            Log.d("MainActivity", "onCreate: store = $store")

            // Utiliza Glide para mostrar las imagenes en el recyclerview y en la vista de detalles
            // Ejemplo:

        }*/
    }

    private fun initAdapter(list: List<Store>){
        adapter = StoreAdapter(list)
        binding.recyclerViewStores.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewStores.adapter = adapter
        showDetail()
    }

    private fun showDetail(){
        adapter.onClick = {
            storeId ->
            lifecycleScope.launchWhenCreated {
                viewModel.getStoreById(storeId).collectLatest {
                    store -> store?.let {
                        startActivity(Intent(applicationContext,StoreDetailActivity::class.java).apply{
                            putExtra("BUNDLE", Bundle().apply {
                                putParcelable("STORE",it)
                            })
                        })
                    }
                }
            }
        }
    }


}