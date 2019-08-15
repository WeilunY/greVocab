package com.wy.gre_vocab.controller;

import com.wy.gre_vocab.common.Result;
import com.wy.gre_vocab.entity.Word;
import com.wy.gre_vocab.service.WordService;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {

    @Resource
    WordService wordService;

    // get word and definition by id
    @GetMapping("/getWord")
    public Result getWord(@RequestBody List<Integer> id) {

       List<Word> words =  wordService.selectWords(id);
       return Result.success(words);

    }

    // update favorite

    @PostMapping("/toggleFav")
    public Result toggleFavorite(@RequestBody Word word){
        int id = word.getId();
        int favorite = word.getFavorite();
        return Result.success(wordService.toggleFav(id, favorite) + "");
    }



}
