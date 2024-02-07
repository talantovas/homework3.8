package com.geeks.homework38

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.geeks.homework38.databinding.ItemCharacterBinding

class MainAdapter(
    private val characterList: ArrayList<Character>,
    private val onClick: (model: Character) -> Unit // Изменения здесь: добавление переменной onClick в конструктор
) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding, onClick) // Изменения здесь: передача onClick в конструктор MainViewHolder
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(characterList[position])
    }
}

class MainViewHolder(
    private val binding: ItemCharacterBinding,
    private val onClick: (model: Character) -> Unit // Изменения здесь: добавление переменной onClick в конструктор
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character) {
        with(binding) {
            tvCharacterDescription.text = character.description
            tvCharacterName.text = character.name
            Glide.with(imgCharacters).load(character.image).into(imgCharacters)
        }
        itemView.setOnClickListener {
            onClick.invoke(character)
        }
    }
}
