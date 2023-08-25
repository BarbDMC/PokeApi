package com.mfcc.poke.data.models;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Result {
    private String name;
    private double height;
    private double weight;
    private String description;
    private String types;
    private String weaknesses;
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;


    public static class ResultBuilder {
        @Override
        public String toString() {
            return "\nPokemon Information \n" +
                    "\nName: " + name +
                    "\nHeight: " + height +
                    "\nWeight: " + weight +
                    "\nDescription: " + description +
                    "\nTypes: " + types +
                    "\nWeaknesses: " + weaknesses +
                    "\nBase Points:" +
                    "\n- hp -> " + hp +
                    "\n- attack -> " + attack +
                    "\n- defense -> " + defense +
                    "\n- special-attack -> " + specialAttack +
                    "\n- special-defense -> " + specialDefense +
                    "\n- speed -> " + speed;
        }
    }
}
