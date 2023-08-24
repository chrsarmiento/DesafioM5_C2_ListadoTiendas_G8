package com.desafiolatam.listadodetiendas.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.desafiolatam.listadodetiendas.R
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

        binding.run {
            store?.run {
                textViewStoreName.text = name
                textViewStoreAddress.text = address

                textViewStoreAddress.setOnClickListener {
                    val geoIntentUri = Uri.parse("geo:0,0?q=$address")
                    val mapIntent = Intent(Intent.ACTION_VIEW, geoIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    startActivity(mapIntent)
                }

                textViewStoreOfficeHours.text = officeHours
                textViewStoreHistory.text = history
                Glide.with(applicationContext)
                    .load(photo)
                    .centerCrop()
                    .error(R.drawable.baseline_error_outline_24)
                    .into(imageViewStore)
            }
        }
    }
}