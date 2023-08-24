package com.mfcc.poke.data.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Pokemon {
    private String name;
    private double height;
    private double weight;
    private List<Stats> stats;
    private List<Types> types;

    @Setter
    @Getter
    public static class Stat {
        private String name;
    }

    @Setter
    @Getter
    public static class Stats {
        private int base_stat;
        private Stat stat;
    }

    @Setter
    @Getter
    public static class Type {
        private String name;
    }

    @Setter
    @Getter
    public static class Types {
        private Type type;
    }


}
