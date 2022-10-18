package com.mmm.utils;

public interface StatusCodeConstant {

    //正常状态
    Integer STATUS_NORMAL = 0;

    //请求成功
    Integer STATUS_200 = 200;

    Integer STATUS_302 = 302;

    // 请求无法理解
    Integer STATUS_400 = 400;
    //需要身份认证
    Integer STATUS_401 = 401;
    //服务器拒绝请求
    Integer STATUS_403 = 403;
    // Not Found
    Integer STATUS_404 = 404;
    // not allow
    Integer STATUS_405 = 405;
    //服务器内部错误
    Integer STATUS_500 = 500;



}
