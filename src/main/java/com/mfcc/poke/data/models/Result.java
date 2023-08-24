package com.mfcc.poke.data.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Result {
    private String name;
    private double height;
    private double weight;

    public static class ResultBuilder {
        @Override
        public String toString() {
            return "Pokemon Information \n" +
                    "\nName: " + name +
                    "\nHeight: " + height +
                    "\nWeight: " + weight;
        }
    }
}
