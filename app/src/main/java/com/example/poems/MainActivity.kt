package com.example.poems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val infoList = InfoData.infoList
    private var isNavigationVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)


        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigation)

        bottomNavigation.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.aboutApp -> {
                    val aboutAppFragment = AboutAppFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mainContainer, aboutAppFragment)
                        .addToBackStack(null)
                        .commit()

                    true
                }

                R.id.aboutDeveloper -> {
                    val aboutDevelopersFragment = AboutDevelopersFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mainContainer, aboutDevelopersFragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }

                else -> false
            }
        }

        val adapter = InfoAdapter(infoList) { info ->

            val fragment = InfoDetailFragment.newInstance(info)
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, fragment)
                .addToBackStack(null)
                .commit()

            bottomNavigation.visibility = View.GONE
        }
        recyclerView.adapter = adapter


        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // Check if the user is scrolling up and the bottom navigation is visible
                if (dy > 0 && isNavigationVisible) {
                    bottomNavigation.visibility = View.GONE
                    isNavigationVisible = false
                } else if (dy < 0 && !isNavigationVisible) {
                    // Check if the user is scrolling down and the bottom navigation is hidden
                    bottomNavigation.visibility = View.VISIBLE
                    isNavigationVisible = true
                }
            }
        })
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 0){
            val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigation)
            bottomNavigation.visibility = View.VISIBLE
            supportActionBar?.show()
        }
        super.onBackPressed()
    }
}