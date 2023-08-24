package com.desafiolatam.listadodetiendas.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.desafiolatam.listadodetiendas.databinding.ActivityStoreDetailBinding
import com.desafiolatam.listadodetiendas.model.Store

class StoreDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoreDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras?.get("BUNDLE") as Bundle
        val store = bundle.getParcelable<Store>("STORE")

        if (store != null) {
            Log.i("INFORMACION",store.name)
        }
    }
}