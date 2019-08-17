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

    /** get word and definition by id
     * @param id
     * @return
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/getWord")
    public Result getWord(@RequestBody List<Integer> id) {

        List<Word> words =  wordService.selectWords(id);
        return Result.success(words);

    }

    /**
     * Get a single word by id
     * @param id
     * @return
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getAWord/{id}")
    public Result getAWord(@PathVariable("id" )int id){
        Word word = wordService.selectWord(id);
        return Result.success(word);
    }

    /**
     * Get all words in the list
     * @return
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getAll")
    public Result getAll(){
        return Result.success(wordService.getAll());
    }


    /**
     * Get range
     * @param range
     * @return
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/getRange")
    public Result getRange(@RequestBody Map<String, Integer> range){

            int start = range.get("start");
            int end = range.get("end");

            // check conditions
            if(start > end){
                int temp = start;
                start = end;
                end = temp;
            }

            List<Word> words =  wordService.getRange(start, end);

            return Result.success(words);



    }

    /**
     * Get the number of word in list
     * @return
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getCount")
    public Result getCount(){ return Result.success(wordService.getCount()); }

    /**
     * Change favorite status
     * @param info: "user_id", "word_id", "favorite" (1: add to fav, 0: delete from fav)
     * @return success message
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("changeFavorite")
    public Result changeFavorite(@RequestBody Map<String, Integer> info){

        try {
            // get important value
            int user_id = info.get("user_id");
            int word_id = info.get("word_id");
            int favorite_status = info.get("favorite");

            // add to
            if (favorite_status == 1) {
                return Result.success(wordService.addFavorite(user_id, word_id) + "");
            }
            // delete
            else {
                return Result.success(wordService.deleteFavorite(user_id, word_id) + "");
            }
        } catch (Exception e){
            return Result.error(e.toString());
        }
    }

    /**
     * Get all favorite words
     * @param id
     * @return
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getFavorites/{id}")
    public Result getFavoriteWords(@PathVariable("id") int id) {
        return Result.success(Result.success(wordService.getFavoriteWords(id)));
    }





}
