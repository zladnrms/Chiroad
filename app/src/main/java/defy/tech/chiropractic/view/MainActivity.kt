package defy.tech.chiropractic.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import defy.tech.chiropractic.R
import defy.tech.chiropractic.databinding.ActivityFavoriteBinding
import defy.tech.chiropractic.viewmodel.FavoriteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFavoriteBinding

    private val favoriteViewModel: FavoriteViewModel by lazy {
        ViewModelProviders.of(this).get(FavoriteViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        favoriteViewModel.welcomeText.observe(this, Observer {
            Toast.makeText(this, "바낌", Toast.LENGTH_SHORT).show()
        })

        binding = DataBindingUtil.setContentView(this, R.layout.activity_favorite)
        binding.viewModel = favoriteViewModel
        binding.lifecycleOwner = this
    }
}
