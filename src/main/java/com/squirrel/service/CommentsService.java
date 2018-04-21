package com.squirrel.service;

import com.squirrel.pojo.Comments;

import java.util.List;

public interface CommentsService {

    int addComments(Comments comments);

    boolean updateCommentsById(Comments comments);

    boolean deleteCommentsById(int id);

    List<Comments> getCommentsByGoodsId(int goodsId);
}
