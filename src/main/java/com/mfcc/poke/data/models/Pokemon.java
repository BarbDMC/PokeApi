package com.mfcc.poke.data.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Pokemon {
    private String name;
    private double height;
    private double weight;


}
