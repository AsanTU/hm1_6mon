package mbk.io.sabrina_hm1_6m.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import mbk.io.sabrina_hm1_6m.databinding.ActivityMainBinding
import mbk.io.sabrina_hm1_6m.model.Character


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
            //viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getAllData().observe(this) {
            val adapter = CharacterAdapter(this::onClick, it)
            binding.recyclerView.adapter = adapter
        }

    }

    private fun onClick(character: Character) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("key", character.id)
        startActivity(intent)
    }
}