/**
 * 模块JavaScript
 */
var manageLoginPage = {
    /**
     * 初始化
     */
    init: function () {
        toastr.options.positionClass = 'toast-top-center';
        var phone = $.cookie('squirrelPhone');
        var password = $.cookie('squirrelPassword');
        $('#phone').val(phone);
        $('#password').val(password);
    },
    /**
     * 验证用户名和密码是否合法
     */
    checkPhoneAndPassword: function (phone, password) {
        if (phone == null || phone == ''
            || phone.replace(/(^s*)|(s*$)/g, "").length == 0) {
            $('#loginModalErrorMessage').html('<i class="close icon"></i><div class="header">错误提示</div>\n' +
                '                <p>'+'账号不能为空'+'</p>');
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
    /**
     * 验证登录
     */
    checkLogin: function () {
        var phone = $('#phone').val();
        var password = $('#password').val();
        if (manageLoginPage.checkPhoneAndPassword(phone, password)) {
            //调用后端API
            $.post(app.URL.checkLoginUrl(), {
                phone: phone,
                password: password
            }, function (result) {
                if (result && result['success']) {
                    if ($('#rememberMe').is(":checked")) {
                        // 把账号信息记入cookie
                        $.cookie('squirrelPhone', phone, {expires: 7, path: '/'});
                        $.cookie('squirrelPassword', password, {expires: 7, path: '/'});
                    }
                    // 验证通过 刷新页面
                    window.location.reload();
                } else {
                    toastr.error(result.message);
                }
            }, "json");
        }
    },
};