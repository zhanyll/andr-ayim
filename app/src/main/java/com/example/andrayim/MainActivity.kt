package com.example.andrayim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.andrayim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        val navView = binding.navView

        drawerLayout = binding.drawerLayout
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawer(GravityCompat.START)
            when (menuItem.itemId) {
                R.id.navItem1 -> {
                    supportFragmentManager.beginTransaction()
                        .add(R.id.fragment_container, Fragment1())
                        .addToBackStack(null)
                        .commit()
                }
                R.id.navItem2 -> {
                    supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, Fragment2())
                        .addToBackStack(null)
                    .commit()
                }
                R.id.navItem3 -> {
                    supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, Fragment3())
                        .addToBackStack(null)
                    .commit()
                }
            }
            Toast.makeText(this, "menu - ${menuItem.title}", Toast.LENGTH_SHORT).show()
            true
        }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (drawerToggle.onOptionsItemSelected(item)) {
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }
}