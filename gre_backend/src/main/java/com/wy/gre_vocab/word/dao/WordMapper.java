package com.wy.gre_vocab.word.dao;

import com.wy.gre_vocab.word.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface WordMapper {

    List<Word> selectWords(List<Integer> id);

    Word selectWord(int id);

    List<Word> getAll();

    List<Word> getRange(@Param("start") int start, @Param("end") int end);

    int getCount();

    int checkExist(@Param("user_id") int user_id, @Param("word_id") int word_id);

    int addFavorite(@Param("user_id") int user_id, @Param("word_id") int word_id);

    int deleteFavorite(@Param("user_id") int user_id, @Param("word_id") int word_id);

    List<Word> getFavoriteWords(@Param("id") int id);


}
