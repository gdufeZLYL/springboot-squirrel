/**
 * 模块化JavaScript
 **/
var manageUserListPage = {
    data:{
        pageNum: 0,
        pageSize: 0,
        totalPageNum: 0,
        totalPageSize: 0,
        users: [],
    },
    init: function (pageNum, pageSize, totalPageNum, totalPageSize, users) {
        manageUserListPage.data.pageNum = pageNum;
        manageUserListPage.data.pageSize = pageSize;
        manageUserListPage.data.totalPageNum = totalPageNum;
        manageUserListPage.data.totalPageSize = totalPageSize;
        manageUserListPage.data.users = users;
        //分页初始化
        manageUserListPage.subPageMenuInit();

        //新增用户，弹出新增窗口
        $("#addUserBtn").click(function () {
            //输入框初始化数据
            manageUserListPage.initAddUserData();
            $("#addUserModal").modal({
                keyboard : false,
                show : true,
                backdrop : "static"
            });
        });

        //新增用户，取消增加
        $('#cancelAddUserBtn').click(function(){
            $("#addUserModal").modal('hide');
        });

        //新增用户，确定增加
        $('#confirmAddUserBtn').click(function(){
            manageUserListPage.addUserAction();
        });

        //编辑考试，取消考试编辑
        $('#cancelUpdateUserBtn').click(function(){
            $("#updateUserModal").modal('hide');
        });

        //编辑考试，确定保存考试
        $('#confirmUpdateUserBtn').click(function(){
            manageUserListPage.updateUserAction();
        });
    },
    firstPage: function () {
        window.location.href = app.URL.manageUserListUrl() + '?page=1';
    },
    prevPage: function () {
        window.location.href = app.URL.manageUserListUrl() + '?page=' + (pageNum-1);
    },
    targetPage: function (page) {
        window.location.href = app.URL.manageUserListUrl() + '?page=' + page;
    },
    nextPage: function () {
        window.location.href = app.URL.manageUserListUrl() + '?page=' + (pageNum+1);
    },
    lastPage: function () {
        window.location.href = app.URL.manageUserListUrl() + '?page=' + manageUserListPage.data.totalPageNum;
    },
    subPageMenuInit: function(){
        var subPageStr = '<ul class="pagination">';
        if (manageUserListPage.data.pageNum == 1) {
            subPageStr += '<li class="disabled"><a><span>首页</span></a></li>';
            subPageStr += '<li class="disabled"><a><span>上一页</span></a></li>';
        } else {
            subPageStr += '<li><a onclick="manageUserListPage.firstPage()"><span>首页</span></a></li>';
            subPageStr += '<li><a onclick="manageUserListPage.prevPage()"><span>上一页</span></a></li>';
        }
        var startPage = (manageUserListPage.data.pageNum-4 > 0 ? manageUserListPage.data.pageNum-4 : 1);
        var endPage = (startPage+7 > manageUserListPage.data.totalPageNum ? manageUserListPage.data.totalPageNum : startPage+7);
        console.log('startPage = ' + startPage);
        console.log('endPage = ' + endPage);
        console.log('pageNum = ' + manageUserListPage.data.pageNum);
        console.log('totalPageNum = ' + manageUserListPage.data.totalPageNum);
        for (var i = startPage; i <= endPage; i++) {
            if (i == manageUserListPage.data.pageNum) {
                subPageStr += '<li class="active"><a onclick="manageUserListPage.targetPage('+i+')">'+i+'</a></li>';
            } else {
                subPageStr += '<li><a onclick="manageUserListPage.targetPage('+i+')">'+i+'</a></li>';
            }
        }
        if (manageUserListPage.data.pageNum == manageUserListPage.data.totalPageNum) {
            subPageStr += '<li class="disabled"><a><span>下一页</span></a></li>';
            subPageStr += '<li class="disabled"><a><span>末页</span></a></li>';
        } else {
            subPageStr += '<li><a onclick="manageUserListPage.nextPage()"><span>下一页</span></a></li>';
            subPageStr += '<li><a onclick="manageUserListPage.lastPage()"><span>末页</span></a></li>';
        }
        $('#subPageHead').html(subPageStr);
    },
    initAddUserData: function () {
        //初始化数据
        $('#addUsername').val("");
        $('#addPhone').val("");
        $('#addQq').val("");
        $('#addPassword').val("");

    },
    checkAddUserData: function (username, phone, qq, password) {
        if (username == null || username == ''
            || username.replace(/(^s*)|(s*$)/g, "").length == 0) {
            //TODO::信息校验
            $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                '                <p>'+'昵称不能为空'+'</p>');
            $('#loginModalErrorMessage').removeClass('hidden');
            return false;
        }
        if (phone == null || phone == ''
            || phone.replace(/(^s*)|(s*$)/g, "").length == 0) {
            $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                '                <p>'+'手机不能为空'+'</p>');
            $('#loginModalErrorMessage').removeClass('hidden');
            return false;
        }
        if (qq == null || qq == ''
            || qq.replace(/(^s*)|(s*$)/g, "").length == 0) {
            $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                '                <p>'+'QQ不能为空'+'</p>');
            $('#loginModalErrorMessage').removeClass('hidden');
            return false;
        }
        if (password == null || password == ''
            || password.replace(/(^s*)|(s*$)/g, "").length == 0) {
            $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                '                <p>'+'密码不能为空'+'</p>');
            $('#loginModalErrorMessage').removeClass('hidden');
            return false;
        }
        return true;
    },
    addUserAction: function () {
        var username = $('#addUsername').val();
        var phone = $('#addPhone').val();
        var qq = $('#addQq').val();
        var power = $('#addPower').val();
        var password = $('#addPassword').val();

        if (manageUserListPage.checkAddUserData(username, phone, qq, password)) {
            $.ajax({
                url : app.URL.addUserUrl(),
                type : "POST",
                dataType: "json",
                contentType : "application/json;charset=UTF-8",
                <!-- 向后端传输的数据 -->
                data : JSON.stringify({
                    username: username,
                    phone: phone,
                    qq: qq,
                    power: power,
                    password: password,
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
    //编辑考试模态框触发
    updateUserModalAction: function (index) {
        //编辑考试，弹出编辑窗口
        //console.log(index);
        //输入框初始化数据
        manageUserListPage.initUpdateUserData(index);
        $("#updateUserModal").modal({
            keyboard : false,
            show : true,
            backdrop : "static"
        });
    },
    initUpdateUserData: function (index) {
        //初始化数据
        $('#updateUserIndex').val(users[index].id);
        $('#updateUsername').val(users[index].username);
        $('#updatePhone').val(users[index].phone);
        $('#updateQq').val(users[index].qq);
        var selectPowers = document.getElementById('updatePower');
        for (var i = 0; i < selectPowers.length; i++) {
            if (selectPowers[i].value == users[index].power) {
                selectPowers[i].selected = true;
            }
        }
        //$('#updatePassword').val(users[index].password);
    },
    checkUpdateUserData: function (username, phone, qq, password) {
        if (username == null || username == ''
            || username.replace(/(^s*)|(s*$)/g, "").length == 0) {
            //TODO::信息校验
            $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                '                <p>'+'昵称不能为空'+'</p>');
            $('#loginModalErrorMessage').removeClass('hidden');
            return false;
        }
        if (phone == null || phone == ''
            || phone.replace(/(^s*)|(s*$)/g, "").length == 0) {
            $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                '                <p>'+'手机不能为空'+'</p>');
            $('#loginModalErrorMessage').removeClass('hidden');
            return false;
        }
        if (qq == null || qq == ''
            || qq.replace(/(^s*)|(s*$)/g, "").length == 0) {
            $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                '                <p>'+'QQ不能为空'+'</p>');
            $('#loginModalErrorMessage').removeClass('hidden');
            return false;
        }
        if (password == null || password == ''
            || password.replace(/(^s*)|(s*$)/g, "").length == 0) {
            $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                '                <p>'+'密码不能为空'+'</p>');
            $('#loginModalErrorMessage').removeClass('hidden');
            return false;
        }
        return true;
    },
    updateUserAction: function () {
        var index = $('#updateUserIndex').val();
        var username = $('#updateUsername').val();
        var phone = $('#updatePhone').val();
        var qq = $('#updateQq').val();
        var power = $('#updatePower').val();
        var password = $('#updatePassword').val();

        if (manageUserListPage.checkUpdateUserData(username, phone, qq, password)) {
            $.ajax({
                url : app.URL.updateUserUrl(),
                type : "POST",
                dataType: "json",
                contentType : "application/json;charset=UTF-8",
                <!-- 向后端传输的数据 -->
                data : JSON.stringify({
                    id: index,
                    username: username,
                    phone: phone,
                    qq: qq,
                    power: power,
                    password: password,
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
    deleteUserAction: function (index) {
        $.ajax({
            url : app.URL.deleteUserUrl()+index,
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
    freezeUserAction: function (index) {
        $.ajax({
            url : app.URL.freezeUserUrl()+index,
            type : "POST",
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
    unfreezeUserAction: function (index) {
        $.ajax({
            url : app.URL.unfreezeUserUrl()+index,
            type : "POST",
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


};