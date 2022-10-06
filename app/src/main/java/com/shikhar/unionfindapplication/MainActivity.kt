package com.shikhar.unionfindapplication

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.core.view.isInvisible
import androidx.navigation.fragment.findNavController
import com.shikhar.unionfindapplication.databinding.ActivityMainBinding
import com.shikhar.unionfindapplication.databinding.FragmentFirstBinding

class MainActivity : AppCompatActivity() {
    var d=DSU(20)

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var _binding: FragmentFirstBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
         //union(2,3)
       // union(3,4)

       fun check(i: Int, j: Int): Boolean? {
            return d.connected(i,j)
        }
        fun union(i :Int,j:Int) : Boolean?{
            return d.union(i,j)
        }
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)



       /* binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      /* return if(R.id.addconnections){
           intent=Intent(@this@MainActivity,FirstFragment::class.java)
           startActivity(intent)
           return true
       }else if(R.id.action_settings){
           return true
          // super.onOptionsItemSelected(item)

       }*/

        return when (item.itemId) {
           /* R.id.action_settings -> true*/
           R.id.addconnections->{
               findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.action_FirstFragment_to_SecondFragment)
               item.isVisible = false
               return true
           }

               /*intent=Intent(@this,FragmentFirstBinding::class.java)
               startActivity(intent)*/

            else -> super.onOptionsItemSelected(item)

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }









}