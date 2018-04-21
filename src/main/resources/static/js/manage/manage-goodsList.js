/**
 * 模块化JavaScript
 **/
var manageGoodsListPage = {
    data:{
        pageNum: 0,
        pageSize: 0,
        totalPageNum: 0,
        totalPageSize: 0,
        catelogId: 0,
        text: '',
        goodsList: [],
    },
    init: function (pageNum, pageSize, totalPageNum,
                    totalPageSize, catelogId,
                    text, goodsList) {
        manageGoodsListPage.data.pageNum = pageNum;
        manageGoodsListPage.data.pageSize = pageSize;
        manageGoodsListPage.data.totalPageNum = totalPageNum;
        manageGoodsListPage.data.totalPageSize = totalPageSize;
        manageGoodsListPage.data.catelogId = catelogId;
        manageGoodsListPage.data.text = text,
        manageGoodsListPage.data.goodsList = goodsList;
        //分页初始化
        manageGoodsListPage.subPageMenuInit();

        $('#queryText').val(text);
        var selectQueryCatelogIds = document.getElementById('queryCatelogId');
        for (var i = 0; i < selectQueryCatelogIds.length; i++) {
            if (selectQueryCatelogIds[i].value == catelogId) {
                selectQueryCatelogIds[i].selected = true;
            }
        }

        //编辑考试，取消考试编辑
        $('#cancelUpdateGoodsBtn').click(function(){
            $("#updateGoodsModal").modal('hide');
        });

        //编辑考试，确定保存考试
        $('#confirmUpdateGoodsBtn').click(function(){
            manageGoodsListPage.updateGoodsAction();
        });

        //查詢按鈕触发
        $('#queryGoodsBtn').click(function () {
            manageGoodsListPage.queryGoodsAction();
        });

        //日期时间控件
        $('.form_datetime').datetimepicker({
            language:  'zh-CN',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1
        });
    },
    firstPage: function () {
        var text = $('#queryText').val();
        var catelogId = $('#queryCatelogId').val();
        window.location.href = app.URL.manageGoodsListUrl()
            + '?page=1&catelogId=' + catelogId + '&text=' + text;
    },
    prevPage: function () {
        var text = $('#queryText').val();
        var catelogId = $('#queryCatelogId').val();
        window.location.href = app.URL.manageGoodsListUrl()
            + '?page=' + (pageNum-1) + '&catelogId='
            + catelogId + '&text=' + text;
    },
    targetPage: function (page) {
        var text = $('#queryText').val();
        var catelogId = $('#queryCatelogId').val();
        window.location.href = app.URL.manageGoodsListUrl()
            + '?page=' + page + '&catelogId='
            + catelogId + '&text=' + text;
    },
    nextPage: function () {
        var text = $('#queryText').val();
        var catelogId = $('#queryCatelogId').val();
        window.location.href = app.URL.manageGoodsListUrl()
            + '?page=' + (pageNum+1) + '&catelogId='
            + catelogId + '&text=' + text;
    },
    lastPage: function () {
        var text = $('#queryText').val();
        var catelogId = $('#queryCatelogId').val();
        window.location.href = app.URL.manageGoodsListUrl()
            + '?page=' + manageGoodsListPage.data.totalPageNum + '&catelogId='
            + catelogId + '&text=' + text;
    },
    subPageMenuInit: function(){
        var subPageStr = '<ul class="pagination">';
        if (manageGoodsListPage.data.pageNum == 1) {
            subPageStr += '<li class="disabled"><a><span>首页</span></a></li>';
            subPageStr += '<li class="disabled"><a><span>上一页</span></a></li>';
        } else {
            subPageStr += '<li><a onclick="manageGoodsListPage.firstPage()"><span>首页</span></a></li>';
            subPageStr += '<li><a onclick="manageGoodsListPage.prevPage()"><span>上一页</span></a></li>';
        }
        var startPage = (manageGoodsListPage.data.pageNum-4 > 0 ? manageGoodsListPage.data.pageNum-4 : 1);
        var endPage = (startPage+7 > manageGoodsListPage.data.totalPageNum ? manageGoodsListPage.data.totalPageNum : startPage+7);
        console.log('startPage = ' + startPage);
        console.log('endPage = ' + endPage);
        console.log('pageNum = ' + manageGoodsListPage.data.pageNum);
        console.log('totalPageNum = ' + manageGoodsListPage.data.totalPageNum);
        for (var i = startPage; i <= endPage; i++) {
            if (i == manageGoodsListPage.data.pageNum) {
                subPageStr += '<li class="active"><a onclick="manageGoodsListPage.targetPage('+i+')">'+i+'</a></li>';
            } else {
                subPageStr += '<li><a onclick="manageGoodsListPage.targetPage('+i+')">'+i+'</a></li>';
            }
        }
        if (manageGoodsListPage.data.pageNum == manageGoodsListPage.data.totalPageNum) {
            subPageStr += '<li class="disabled"><a><span>下一页</span></a></li>';
            subPageStr += '<li class="disabled"><a><span>末页</span></a></li>';
        } else {
            subPageStr += '<li><a onclick="manageGoodsListPage.nextPage()"><span>下一页</span></a></li>';
            subPageStr += '<li><a onclick="manageGoodsListPage.lastPage()"><span>末页</span></a></li>';
        }
        $('#subPageHead').html(subPageStr);
    },
    //编辑商品模态框触发
    updateGoodsModalAction: function (index) {
        //编辑考试，弹出编辑窗口
        //console.log(index);
        //输入框初始化数据
        manageGoodsListPage.initUpdateGoodsData(index);
        $("#updateGoodsModal").modal({
            keyboard : false,
            show : true,
            backdrop : "static"
        });
    },
    initUpdateGoodsData: function (index) {
        //初始化数据
        var goodsList = manageGoodsListPage.data.goodsList;
        $('#updateGoodsIndex').val(index);
        $('#updateName').val(goodsList[index].name);
        $('#updateUsername').val(goodsList[index].user.username);
        var selectCatelogIds = document.getElementById('updateCatelogId');
        for (var i = 0; i < selectCatelogIds.length; i++) {
            if (selectCatelogIds[i].value == goodsList[index].catelogId) {
                selectCatelogIds[i].selected = true;
            }
        }
        $('#updatePrice').val(goodsList[index].price);
        $('#updateRealPrice').val(goodsList[index].realPrice);
        $('#updateStartTime').val(goodsList[index].startTime);
        $('#updateEndTime').val(goodsList[index].endTime);
        $('#updateDescrible').val(goodsList[index].describle);
    },
    checkUpdateGoodsData: function (name, price,
                                    realPrice, startTime, endTime, describle) {
        return true;
    },
    updateGoodsAction: function () {
        var goodsList = manageGoodsListPage.data.goodsList;
        var index = $('#updateGoodsIndex').val();
        var name = $('#updateName').val();
        var catelogId = $('#updateCatelogId').val();
        var price = $('#updatePrice').val();
        var realPrice = $('#updateRealPrice').val();
        var startTime = $('#updateStartTime').val();
        var endTime = $('#updateEndTime').val();
        var describle = $('#updateDescrible').val();
        if (manageGoodsListPage.checkUpdateGoodsData(name, price,
                realPrice, startTime, endTime, describle)) {
            $.ajax({
                url : app.URL.updateGoodsUrl(),
                type : "POST",
                dataType: "json",
                contentType : "application/json;charset=UTF-8",
                <!-- 向后端传输的数据 -->
                data : JSON.stringify({
                    id: goodsList[index].id,
                    catelogId: catelogId,
                    userId: goodsList[index].userId,
                    name: name,
                    price: price,
                    realPrice: realPrice,
                    startTime: startTime,
                    endTime: endTime,
                    polishTime: goodsList[index].polishTime,
                    commetNum: goodsList[index].commetNum,
                    describle: describle,
                }),
                success:function(result) {
                    if (result && result['success']) {
                        // 验证通过 刷新页面
                        window.location.reload();
                    } else {
                        $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                            '                <p>'+result.message+'</p>');
                        $('#loginModalErrorMessage').removeClass('hidden');
                    }
                },
                error:function(result){
                    $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                        '                <p>'+result.message+'</p>');
                    $('#loginModalErrorMessage').removeClass('hidden');
                }
            });
        }
    },
    offGoodsAction: function (index) {
        $.ajax({
            url : app.URL.offGoodsUrl()+index,
            type : "DELETE",
            dataType: "json",
            contentType : "application/json;charset=UTF-8",
            success:function(result) {
                if (result && result['success']) {
                    // 验证通过 刷新页面
                    window.location.reload();
                } else {
                    $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                        '                <p>'+result.message+'</p>');
                    $('#loginModalErrorMessage').removeClass('hidden');
                }
            },
            error:function(result){
                $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                    '                <p>'+result.message+'</p>');
                $('#loginModalErrorMessage').removeClass('hidden');
            }
        });
    },
    //查询
    queryGoodsAction: function () {
        var text = $('#queryText').val();
        var catelogId = $('#queryCatelogId').val();
        window.location.href = app.URL.manageGoodsListUrl()
            + '?page=1&catelogId=' + catelogId + '&text=' + text;
    },

};