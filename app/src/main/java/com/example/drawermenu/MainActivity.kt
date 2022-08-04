package com.example.drawermenu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()


        val drawerDelay: Long = 150 //delay of the drawer to close
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.nav_home -> {
                    drawerlayout.closeDrawer(GravityCompat.START)
                    Handler().postDelayed({
                        startActivity(
                            Intent(
                                this,
                                HomeActivity::class.java
                            )
                        )
                    }, drawerDelay)
                    setTitle("Home")
                }

                R.id.nav_cart -> {
                    drawerlayout.closeDrawer(GravityCompat.START)
                    Handler().postDelayed({
                        startActivity(
                            Intent(
                                this,
                                CartActivity::class.java
                            )
                        )
                    }, drawerDelay)
                    setTitle("Cart")
                }
                R.id.nav_payment -> {
                    drawerlayout.closeDrawer(GravityCompat.START)
                    Handler().postDelayed({
                        startActivity(
                            Intent(
                                this,
                                PaymentActivity::class.java
                            )
                        )
                    }, drawerDelay)
                }

                R.id.nav_logout -> {
                    drawerlayout.closeDrawer(GravityCompat.START)
                }
            }
            true
        }

        fun setToolbarTitle(s: String) {
            supportActionBar?.title = title
        }

    }
    }
