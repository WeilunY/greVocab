package com.wy.gre_vocab.word.service;

import com.wy.gre_vocab.word.dao.WordMapper;
import com.wy.gre_vocab.word.entity.Word;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class WordService {

    @Resource
    WordMapper wordMapper;

    // select words from list of ids
    public List<Word> selectWords(List<Integer> id){
        return wordMapper.selectWords(id);
    }

    public Word selectWord(int id) {
        return wordMapper.selectWord(id);
    }

    public int getCount() {
        return wordMapper.getCount();
    }

    public List<Word> getRange(int start, int end){
        return wordMapper.getRange(start, end);
    }

    public List<Word> getAll(){
        return wordMapper.getAll();
    }


    // add to fav
    public int addFavorite(int user_id, int word_id){


        if (wordMapper.checkExist(user_id, word_id) > 0){
            return 0;
        }
        return wordMapper.addFavorite(user_id, word_id);
    }

    // delete from favorite
    public int deleteFavorite(int user_id, int word_id){
        return wordMapper.deleteFavorite(user_id, word_id);
    }

    /**
     * Get a list of favorite word
     * @param id
     * @return
     */
    public List<Word> getFavoriteWords(int id){
        return wordMapper.getFavoriteWords(id);
    }




}
