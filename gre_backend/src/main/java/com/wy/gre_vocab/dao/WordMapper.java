package com.wy.gre_vocab.dao;

import com.wy.gre_vocab.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface WordMapper {

    List<Word> selectWords(List<Integer> id);

    int toggleFav(@Param("id") int id, @Param("favorite") int favorite);

}
