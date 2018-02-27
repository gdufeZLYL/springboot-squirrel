package com.squirrel.service.impl;

import com.squirrel.dao.CommentsMapper;
import com.squirrel.pojo.Comments;
import com.squirrel.service.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {

    @Resource
    private CommentsMapper commentsMapper;

    @Override
    public int addComments(Comments comments) {
        return commentsMapper.insert(comments);
    }

    @Override
    public boolean updateCommentsById(Comments comments) {
        return commentsMapper.updateByPrimaryKeyWithBLOBs(comments) > 0;
    }

    @Override
    public boolean deleteCommentsById(int id) {
        return commentsMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Comments> getCommentsByGoodsId(int goodsId) {
        return commentsMapper.selectByGoodsId(goodsId);
    }
}
