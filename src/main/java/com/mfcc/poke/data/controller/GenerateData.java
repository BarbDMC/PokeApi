package com.mfcc.poke.data.controller;

import com.mfcc.poke.data.client.PokemonClientApi;
import com.mfcc.poke.data.models.Pokemon;
import com.mfcc.poke.data.models.Result;

import java.util.Optional;

public class GenerateData {
    private Pokemon pokemon;
    private PokemonClientApi pokemonClientApi;

    public GenerateData(Pokemon pokemon, PokemonClientApi pokemonClientApi){
        this.pokemon = pokemon;
        this.pokemonClientApi = pokemonClientApi;
    }

    public Optional<Result> getInformation() {
        if(pokemon != null){
            Result.ResultBuilder resultBuilder = Result.builder();
            resultBuilder.name(pokemon.getName());
            resultBuilder.height(pokemon.getHeight());
            resultBuilder.weight(pokemon.getWeight());
        }

        return Optional.empty();
    }
}
