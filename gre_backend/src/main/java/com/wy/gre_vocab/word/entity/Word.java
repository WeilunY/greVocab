package com.wy.gre_vocab.word.entity;

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

    private int user_id;




}
