package mbk.io.sabrina_hm1_6m.ui.first_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import mbk.io.sabrina_hm1_6m.data.base.BaseActivity
import mbk.io.sabrina_hm1_6m.databinding.ActivityMainBinding
import mbk.io.sabrina_hm1_6m.data.model.Character
import mbk.io.sabrina_hm1_6m.ui.CharacterAdapter
import mbk.io.sabrina_hm1_6m.ui.second_activity.SecondActivity
import mbk.io.sabrina_hm1_6m.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<MainViewModel>()

    private val characterAdapter by lazy {
        CharacterAdapter(this::onClick)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecycler()


        viewModel.getCharacters()
        viewModel.charactersLv.stateObserver(
            success = {
                characterAdapter.submitList(it.results)
            },
            state = {
                binding.progressIndicator.isVisible = it is Resource.Loading
            }
        )

        /*//viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.charactersLv.observe(this) { state ->
            //val adapter = CharacterAdapter(this::onClick, it)
            binding.progressIndicator.isVisible = state is Resource.Loading
            when (state) {
                is Resource.Error -> {
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    if (state.data != null) {
                        characterAdapter.submitList(state.data.results)
                    }
                }
            }
        }
        //binding.recyclerView.adapter = adapter*/
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