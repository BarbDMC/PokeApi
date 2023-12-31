package com.mfcc.poke.data.controller;

import com.mfcc.poke.data.client.PokemonClientApi;
import com.mfcc.poke.data.models.Pokemon;
import com.mfcc.poke.data.models.PokemonFlavorTextEntries;
import com.mfcc.poke.data.models.PokemonWeaknesses;
import com.mfcc.poke.data.models.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

            PokemonFlavorTextEntries pokemonFlavorTextEntries = pokemonClientApi.getPokemonFlavorText();
            List<String> descriptionList = pokemonFlavorTextEntries.getFlavor_text_entries().stream()
                    .filter(flavorTextEntries -> "es".equals(flavorTextEntries.getLanguage().getName()) && "x".equals(flavorTextEntries.getVersion().getName()))
                    .map(PokemonFlavorTextEntries.FlavorTextEntries::getFlavor_text)
                    .collect(Collectors.toList());

            String description = String.join(" ", descriptionList);
            resultBuilder.description(description);

            List<String> typesList = pokemon.getTypes().stream()
                    .map(types -> types.getType().getName())
                    .collect(Collectors.toList());

            String types = String.join(", ", typesList);
            resultBuilder.types(types);

            PokemonWeaknesses pokemonWeaknesses = pokemonClientApi.getPokemonWeaknesses();

            List <String> doubleDamageFrom = new ArrayList<>();
            pokemonWeaknesses.getDamage_relations().getDouble_damage_from().forEach(doubleDamage -> {
                   doubleDamageFrom.add(doubleDamage.getName());
            });

            List <String> halfDamageFrom = new ArrayList<>();
            pokemonWeaknesses.getDamage_relations().getHalf_damage_from().forEach(halfDamage -> {
                    halfDamageFrom.add(halfDamage.getName());
            });

            List<String> combinedWeaknesses = new ArrayList<>(doubleDamageFrom);
            combinedWeaknesses.addAll(halfDamageFrom);

            String weaknesses = String.join(", ", combinedWeaknesses);
            resultBuilder.weaknesses(weaknesses);


            List<Integer> hpList = pokemon.getStats().stream()
                    .filter(stats -> "hp".equals(stats.getStat().getName()))
                    .map(Pokemon.Stats::getBase_stat)
                    .collect(Collectors.toList());

            int hp = hpList.get(0);
            resultBuilder.hp(hp);

            List<Integer> attackList = pokemon.getStats().stream()
                    .filter(stats -> "attack".equals(stats.getStat().getName()))
                    .map(Pokemon.Stats::getBase_stat)
                    .collect(Collectors.toList());

            int attack = attackList.get(0);
            resultBuilder.attack(attack);

            List<Integer> defenseList = pokemon.getStats().stream()
                    .filter(stats -> "defense".equals(stats.getStat().getName()))
                    .map(Pokemon.Stats::getBase_stat)
                    .collect(Collectors.toList());

            int defense = defenseList.get(0);
            resultBuilder.defense(defense);

            List<Integer> specialAttackList = pokemon.getStats().stream()
                    .filter(stats -> "special-attack".equals(stats.getStat().getName()))
                    .map(Pokemon.Stats::getBase_stat)
                    .collect(Collectors.toList());

            int specialAttack = specialAttackList.get(0);
            resultBuilder.specialAttack(specialAttack);

            List<Integer> specialDefenseList = pokemon.getStats().stream()
                    .filter(stats -> "special-defense".equals(stats.getStat().getName()))
                    .map(Pokemon.Stats::getBase_stat)
                    .collect(Collectors.toList());

            int specialDefense = specialDefenseList.get(0);
            resultBuilder.specialDefense(specialDefense);

            List<Integer> speedList = pokemon.getStats().stream()
                    .filter(stats -> "speed".equals(stats.getStat().getName()))
                    .map(Pokemon.Stats::getBase_stat)
                    .collect(Collectors.toList());

            int speed = speedList.get(0);
            resultBuilder.speed(speed);


            log.info(resultBuilder.toString());
            return Optional.of(resultBuilder.build());
        }

        return Optional.empty();
    }
}
