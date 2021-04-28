package com.jvgc.architecture.mvvm

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.jvgc.architecture.mvvm.databinding.AdapterCharacterBinding
import com.jvgc.architecture.mvvm.repository.model.Character

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var characters = mutableListOf<Character>()

    fun setCharacterList(characters: List<Character>) {
        this.characters = characters.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterCharacterBinding.inflate(inflater, parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val character = characters[position]
        val isAlive = if (character.alive) {
            "Yes"
        } else {
            "No"
        }
        val hogwarts = when {
            character.hogwartsStaff -> {
                "Staff"
            }
            character.hogwartsStudent -> {
                "Student"
            }
            else -> {
                ""
            }
        }
        val wandLength = if (character.wand.length!!.isNotEmpty()) {
            String.format("${character.wand.length} inches")
        } else {
            character.wand.length
        }

        holder.binding.characterName.text = character.name
        holder.binding.characterGenderValue.text = character.gender
        holder.binding.characterBirthValue.text = character.dateOfBirth
        holder.binding.characterSpeciesValue.text = character.species
        holder.binding.characterPatronusValue.text = character.patronus
        holder.binding.characterAncestryValue.text = character.ancestry
        holder.binding.characterAliveValue.text = isAlive
        holder.binding.characterHogwartsValue.text = hogwarts
        holder.binding.wandWoodValue.text = character.wand.wood
        holder.binding.wandCoreValue.text = character.wand.core
        holder.binding.wandLengthValue.text = wandLength

        Log.d("MainActivity","======================")
        Log.d("MainActivity","Name: ${character.name}")
        Log.d("MainActivity",String.format("Gender: ${character.gender}"))
        Log.d("MainActivity",String.format("Birthday: ${character.dateOfBirth}"))
        Log.d("MainActivity",String.format("Species: ${character.species}"))
        Log.d("MainActivity",String.format("Patronus: ${character.patronus}"))
        Log.d("MainActivity",String.format("Ancestry: ${character.ancestry}"))
        Log.d("MainActivity",String.format("Alive: $isAlive"))
        Log.d("MainActivity",String.format("Hogwarts: $hogwarts"))

        Glide.with(holder.itemView.context).load(character.image)
            .transform(FitCenter(), RoundedCorners(14))
            .into(holder.binding.characterPicture)
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}

class MainViewHolder(val binding: AdapterCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

}