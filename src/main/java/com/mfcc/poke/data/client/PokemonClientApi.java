package com.mfcc.poke.data.client;

import com.mfcc.poke.data.models.Pokemon;
import com.mfcc.poke.data.models.PokemonFlavorTextEntries;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokemonApi", url="https://pokeapi.co/api/v2")


public interface PokemonClientApi {
    @GetMapping("/pokemon/{pokemon}")
    Pokemon getPokemonInfo(@PathVariable String pokemon);

    @GetMapping("/pokemon-species/257")
    PokemonFlavorTextEntries getPokemonFlavorText();
}
