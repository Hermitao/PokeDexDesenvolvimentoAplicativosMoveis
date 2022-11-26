package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import br.com.up.pokedex.model.Pokemon
import br.com.up.pokedex.network.PokeApi
import com.squareup.picasso.Picasso

class PokemonDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemon = intent.getStringExtra("pokemon")
        val id = intent.getStringExtra("id")


        PokeApi().getPokemonByName(pokemon!!, ){
                pokemon ->

            if(pokemon != null){
                val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

                val pokeImage : ImageView = findViewById(R.id.pokeImage)
                Picasso.get().load(url).into(pokeImage)

                val pokeText : TextView = findViewById(R.id.pokeText)

                var finalText : String
                finalText = "Name: " + pokemon.name

                finalText += "\n\nAbilities: "

                for (ability in pokemon.abilities)
                {
                    finalText += ability.ability.name + " "
                }

                finalText += "\n\nStats: "

                for (stat in pokemon.stats)
                {
                    finalText += stat.stat.name + ": " + stat.base_stat + " "
                }

                finalText += "\n\nTypes: "


                for (type in pokemon.types)
                {
                    finalText += type.type.name + " "
                }

                finalText += "\n\nMoves: "


                for (move in pokemon.moves)
                {
                    finalText += move.move.name + " "
                }

                pokeText.text = finalText
            }
        }

//        PokeApi().getPokemonById(id!!, ){
//                pokemon ->
//
//            if(pokemon != null){
//                Log.d("PokemonDetailsActivity", "wtf")
//
//                val pokeImage : ImageView = findViewById(R.id.pokeImage)
//                Picasso.get().load(pokemon.url).into(pokeImage)
//
//                val pokeText : TextView = findViewById(R.id.pokeText)
//                pokeText.text = intent.getStringExtra("pokemon");
//            }
//        }

    }
}