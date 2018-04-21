package com.squirrel.dao;

import com.squirrel.pojo.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKeyWithBLOBs(Comments record);

    int updateByPrimaryKey(Comments record);

    List<Comments> selectByGoodsId(Integer goodsId);
}
