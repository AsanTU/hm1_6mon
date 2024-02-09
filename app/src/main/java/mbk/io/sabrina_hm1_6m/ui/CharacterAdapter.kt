package mbk.io.sabrina_hm1_6m.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mbk.io.sabrina_hm1_6m.utils.Status
import mbk.io.sabrina_hm1_6m.databinding.ItemCharacterBinding
import mbk.io.sabrina_hm1_6m.model.Character

class CharacterAdapter(
    private val onClick: (character: Character) -> Unit,
    //private var list: List<Character>
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var list = listOf<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return CharacterViewHolder(
            binding,
            onClick
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setCharacter(list: List<Character>) {
        this.list = list
        notifyDataSetChanged()
    }

    class CharacterViewHolder(
        private val binding: ItemCharacterBinding,
        private val onClick: (character: Character) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(character: Character) {
            binding.apply {
                Glide.with(image).load(character.image)
                    .into(image)
                tvName.text = character.name
                tvStatus.text = character.status
                tvSpecies.text = character.species
                tvLocation.text = character.location.name
                itemView.setOnClickListener {
                    onClick(character)
                }

                val statusImage = Status(imgCircleStatus)
                statusImage.setStatusImage(character.status)
            }
        }
    }
}