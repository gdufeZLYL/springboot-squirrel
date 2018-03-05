package com.squirrel.common;

public class GgeeConst {
    //本地服务器-文件,图片所在位置
//    public static final String UPLOAD_FILE_PATH = "file:D:/IdeaProjects/data/springboot-squirrel/upload/";
//    public static final String UPLOAD_FILE_IMAGE_PATH = "D:/IdeaProjects/data/springboot-squirrel/upload/images/";

    //云服务器
    public static final String UPLOAD_FILE_PATH = "file:/root/Java/data/springboot-squirrel/upload/";
    public static final String UPLOAD_FILE_IMAGE_PATH = "/root/Java/data/springboot-squirrel/upload/images/";

    // Session
    public final static String CUR_USER = "cur_user";
    //分页数据
    public final static String DATA = "data";

    public static final int userPageSize = 10;
    public static final int goodsPageSize = 16;
}
