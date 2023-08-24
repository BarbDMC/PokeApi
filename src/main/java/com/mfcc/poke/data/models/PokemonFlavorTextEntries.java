package com.mfcc.poke.data.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PokemonFlavorTextEntries {
    private List<FlavorTextEntries> flavor_text_entries;

    @Setter
    @Getter
    public static class FlavorTextEntries {
        private String flavor_text;
        private Language language;
        private Version version;
    }

    @Setter
    @Getter
    public static class Language {
        private String name;
    }

    @Setter
    @Getter
    public static class Version {
        private String name;
    }
}


