package com.mfcc.poke.data.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PokemonWeaknesses {
    private DamageRelations damage_relations;
    @Setter
    @Getter
    public static class Damage {
        private String name;
    }

    @Setter
    @Getter
    public static class DamageRelations {
        private List<Damage> double_damage_from;
        private List<Damage> half_damage_from;
    }
}
