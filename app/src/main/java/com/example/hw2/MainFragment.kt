package com.example.hw2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRetainInstance(true)
    }

    override fun onResume() {
        super.onResume()
        val recycler = view?.findViewById<RecyclerView>(R.id.gif_rv)
        val progress = view?.findViewById<FrameLayout>(R.id.progress_bar)
        val button = view?.findViewById<FrameLayout>(R.id.retry_btn)

        val myCallback = { result: TrendingGifsResponse?, error: Throwable? ->
            progress?.isVisible = false
            button?.isVisible = false
            when {
                result != null -> {
                    val images = result.data.map { it.images }
                    val adapter = GifAdapter(images)
                    recycler?.adapter = adapter
                }

                error != null -> {
                    Toast.makeText(
                        context,
                        "Runtime error occurred: $error",
                        Toast.LENGTH_LONG
                    ).show()
                    button?.isVisible = true
                }
            }
        }

        button?.setOnClickListener {
            RetrofitController.loadData(myCallback)
        }

        recycler?.layoutManager = LinearLayoutManager(context)
        RetrofitController.loadData(myCallback)

    }
}