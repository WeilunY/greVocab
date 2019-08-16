package com.wy.gre_vocab.word.controller;

import com.wy.gre_vocab.common.Result;
import com.wy.gre_vocab.word.entity.Word;
import com.wy.gre_vocab.word.service.WordService;



import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/getAll")
    public Result getAll(){
        return Result.success(wordService.getAll());
    }

    /**
     * Change favorite status
     * @param info: "user_id", "word_id", "favorite" (1: add to fav, 0: delete from fav)
     * @return success message
     */
    @PostMapping("changeFavorite")
    public Result changeFavorite(@RequestBody Map<String, Integer> info){

        // get important value
        int user_id = info.get("user_id");
        int word_id = info.get("word_id");
        int favorite_status = info.get("favorite");

        // add to
        if(favorite_status == 1){
            return Result.success(wordService.addFavorite(user_id, word_id) + "");
        }
        // delete
        else {
            return Result.success(wordService.deleteFavorite(user_id, word_id) + "");
        }
    }

    @GetMapping("/getFavorites/{id}")
    public Result getFavoriteWords(@PathVariable("id") int id) {
        return Result.success(Result.success(wordService.getFavoriteWords(id)));
    }





}
