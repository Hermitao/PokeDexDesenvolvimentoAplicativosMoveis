package br.com.up.pokedex.model

data class Type(
    val name : String,
    val url : String
)

data class Types (
    val slot : Int,
    val type : Type,
)

data class Ability (
    val name: String,
    val url: String,
)

data class Abilities (
    val ability : Ability,
    val is_hidden : Boolean,
    val slot : Int,
)

data class Move(
    val name : String,
    val url : String,
)

data class Moves(
    val move : Move,
)

data class Stat(
    val name : String,
    val url : String,
)

data class Stats(
    val base_stat : Int,
    val stat : Stat,
)

data class Pokemon(
    val url : String,
    val name : String,
    val types : List<Types>,
    val abilities : List<Abilities>,
    val moves : List<Moves>,
    val stats : List<Stats>,
)
