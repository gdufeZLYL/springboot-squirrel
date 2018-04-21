/**
 * 模块JavaScript
 */
var detailGoodsPage = {
    data:{
        cur_user: null,
        commentsList: null,
        goodsExtend: null,
    },
    init: function (cur_user, commentsList, goodsExtend) {
        detailGoodsPage.data.cur_user = cur_user;
        detailGoodsPage.data.commentsList = commentsList;
        detailGoodsPage.data.goodsExtend = goodsExtend;

        //取消评论回复
        $('#cancelReplyCommentsBtn').click(function(){
            $("#replyCommentsModal").modal('hide');
        });

        //确认评论回复
        $('#confirmReplyCommentsBtn').click(function(){
            detailGoodsPage.replyCommentsAction();
        });

        //写评论
        $('#addCommentsBtn').click(function () {
            detailGoodsPage.addCommentsAction();
        });
    },
    replyCommentsModalAction: function (index) {
        $('#replyAtuserId').val(commentsList[index].userId);
        $("#replyCommentsModal").modal({
            keyboard : false,
            show : true,
            backdrop : "static"
        });
    },
    replyCommentsAction: function () {
        var cur_user = detailGoodsPage.data.cur_user;
        var goodsExtend = detailGoodsPage.data.goodsExtend;

        var atuserId = $('#replyAtuserId').val();
        var content = $('#replyContent').val();

        $.ajax({
            url : app.URL.addCommentsUrl(),
            type : "POST",
            dataType: "json",
            contentType : "application/json;charset=UTF-8",
            <!-- 向后端传输的数据 -->
            data : JSON.stringify({
                userId: cur_user.id,
                atuserId: atuserId,
                goodsId: goodsExtend.goods.id,
                content: content,
            }),
            success:function(result) {
                if (result && result['success']) {
                    // 验证通过 刷新页面
                    window.location.reload();
                } else {
                    console.log(result.message);
                }
            },
            error:function(result){
                console.log(result.message);
            }
        });

    },
    addCommentsAction: function () {
        var cur_user = detailGoodsPage.data.cur_user;
        var goodsExtend = detailGoodsPage.data.goodsExtend;
        var content = $('#commentbox').val();

        $.ajax({
            url : app.URL.addCommentsUrl(),
            type : "POST",
            dataType: "json",
            contentType : "application/json;charset=UTF-8",
            <!-- 向后端传输的数据 -->
            data : JSON.stringify({
                userId: cur_user.id,
                atuserId: 0,
                goodsId: goodsExtend.goods.id,
                content: content,
            }),
            success:function(result) {
                if (result && result['success']) {
                    // 验证通过 刷新页面
                    window.location.reload();
                } else {
                    console.log(result.message);
                }
            },
            error:function(result){
                console.log(result.message);
            }
        });
    },
    deleteCommentsAction: function (id) {
        $.ajax({
            url : app.URL.deleteCommentsUrl()+id,
            type : "DELETE",
            dataType: "json",
            contentType : "application/json;charset=UTF-8",
            success:function(result) {
                if (result && result['success']) {
                    // 验证通过 刷新页面
                    window.location.reload();
                } else {
                    console.log(result.message);
                }
            },
            error:function(result){
                console.log(result.message);
            }
        });
    },


};