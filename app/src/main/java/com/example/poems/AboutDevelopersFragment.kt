package com.example.poems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class AboutDevelopersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.about_developer_fragment, container, false)

        // Set a touch listener to intercept touch events and prevent them from propagating
        view.setOnTouchListener { _, _ -> true }

        return view
    }
}