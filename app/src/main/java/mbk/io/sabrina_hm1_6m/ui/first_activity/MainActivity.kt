package mbk.io.sabrina_hm1_6m.ui.first_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import mbk.io.sabrina_hm1_6m.databinding.ActivityMainBinding
import mbk.io.sabrina_hm1_6m.model.Character
import mbk.io.sabrina_hm1_6m.ui.CharacterAdapter
import mbk.io.sabrina_hm1_6m.ui.second_activity.SecondActivity
import mbk.io.sabrina_hm1_6m.utils.Resource


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private val characterAdapter by lazy {
        CharacterAdapter(this::onClick)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecycler()
        //viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getAllData().observe(this) { state ->
            //val adapter = CharacterAdapter(this::onClick, it)
            binding.progressIndicator.isVisible = state is Resource.Loading
            when (state) {
                is Resource.Error -> {
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    if (state.data != null)
                        characterAdapter.setCharacter(state.data)
                }
            }
        }
        //binding.recyclerView.adapter = adapter
    }

    private fun setupRecycler() = with(binding.recyclerView) {
        layoutManager = LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = characterAdapter
    }

    private fun onClick(character: Character) {
        /*val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(CHARACTER_ID_ARG, character.id)
        startActivity(intent)*/

        startActivity(
            Intent(
                this, SecondActivity::class.java
            ).apply {
                putExtra(
                    CHARACTER_ID_ARG,
                    character.id
                )
            }
        )
    }

    companion object {
        const val CHARACTER_ID_ARG = "key"
    }
}