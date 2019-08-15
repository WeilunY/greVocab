package com.wy.gre_vocab.entity;

import lombok.Data;


import java.io.Serializable;


@Data
public class Word implements Serializable {

    // properties

    // word id
    private int id;

    // english word
    private String word;

    // chinese definition
    private String chin_def;

    // favorite
    private int favorite;



}
