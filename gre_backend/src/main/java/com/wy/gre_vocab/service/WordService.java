package com.wy.gre_vocab.service;

import com.wy.gre_vocab.dao.WordMapper;
import com.wy.gre_vocab.entity.Word;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class WordService {

    @Resource
    WordMapper wordMapper;

    public List<Word> selectWords(List<Integer> id){
        return wordMapper.selectWords(id);
    }

    public int toggleFav(int id, int favorite){
         return wordMapper.toggleFav(id, favorite);
    }


}
