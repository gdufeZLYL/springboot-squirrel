package com.squirrel.controller;

import com.squirrel.dto.AjaxResult;
import com.squirrel.pojo.Comments;
import com.squirrel.service.CommentsService;
import com.squirrel.util.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/comments")
public class CommentsController {

    private static Log LOG = LogFactory.getLog(CommentsController.class);

    @Autowired
    private CommentsService commentsService;

    //添加评论
    @RequestMapping(value="/api/addComments", method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult addaddComments(@RequestBody Comments comments) {
        AjaxResult ajaxResult = new AjaxResult();
        comments.setCreateAt(DateUtil.getNowTime());
        int commentsId = commentsService.addComments(comments);
        return new AjaxResult().setData(commentsId);
    }

    //更新评论
    @RequestMapping(value="/api/updateComments", method= RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateComments(@RequestBody Comments comments) {
        AjaxResult ajaxResult = new AjaxResult();
        boolean result = commentsService.updateCommentsById(comments);
        return new AjaxResult().setData(result);
    }

    //删除评论
    @DeleteMapping("/api/deleteComments/{id}")
    public AjaxResult deleteComments(@PathVariable int id) {
        AjaxResult ajaxResult = new AjaxResult();
        boolean result = commentsService.deleteCommentsById(id);
        return new AjaxResult().setData(result);
    }
}
