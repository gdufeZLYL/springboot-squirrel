package com.squirrel.dao;

import com.squirrel.pojo.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ImageMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteImagesByGoodsPrimaryKey(Integer goodsId);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKeyWithBLOBs(Image record);

    int updateByPrimaryKey(Image record);

    List<Image> selectByGoodsPrimaryKey(Integer goodsId);
}
