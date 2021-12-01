package com.sky.constants;


/**
 * 常用的常量
 */
public interface Constants {
    /**
     * 登录方式
     */
    String grantType = "password";

    String loginType = "admin_type";
    String MemberType = "member_type";

    /**
     * 超管
     */
    String ROLE_ADMIN = "ROLE_ADMIN";

    /**
     * UTF-8 字符集
     */
    String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    String GBK = "GBK";

    /**
     * http请求
     */
    String HTTP = "http://";

    /**
     * https请求
     */
    String HTTPS = "https://";

    /**
     * 成功标记
     */
    Integer SUCCESS = 200;

    /**
     * 失败标记
     */
    Integer FAIL = 500;

    /**
     * 验证码 redis key
     */
    String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 验证码有效期（分钟）
     */
    long CAPTCHA_EXPIRATION = 2;

    /**
     * 数值类型精度
     */
    int SCALE = 8;

    int AGENT_TYPE = 2;

    String BCRYPT_SALT = "!waihui!_+waihui+-";

    /**
     * 首页Banner图
     */
    String CONFIG_WEB_BANNER = "WEB_BANNER";

    /**
     * 令牌
     */
    String TOKEN = "token";
    String MENUS = "menus";
    String AUTHORITIES = "authorities";


    /************************************* REDIS KEY ************************************/
    /**
     * 验证码redis存储Key
     */
    String REDIS_KEY_CAPTCHA_KEY = "CAPTCHA:";

    /**
     * 短信验证码redis存储Key
     */
    String REDIS_KEY_SMS_CODE_KEY = "SMSCODE:";

    /**
     * 登录设备存储key
     */
    String REDIS_KEY_DEVICES_KEY = "DEVICES";

    /**
     * 最大缓存数据量
     */
    long REDIS_MAX_CACHE_KLINE_SIZE = 10000L;

    /************************************* REDIS KEY ************************************/


    /************OAUTH*********************/
    String AUTHORIZATION_HEADER = "Authorization";

    String BEARER = "bearer ";
    /************OAUTH*********************/

    /**
     * 内置的Token
     */
    String INSIDE_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGwiXSwiZXhwIjoxNjA3MTYzNzgzLCJqdGkiOiI1Nzk0ZTY0MC01NDMxLTRkNDItOWZhNi04MWFkN2M4ODgzNjgiLCJjbGllbnRfaWQiOiJpbnNpZGUtYXBwIn0.KMm8fDnvXJ0o8RaCGeH8cG_LtE6Tt-hUVNGhlMbZEPBJjGnWUFc_2fzgLa51TAxpqYpswtT8_Dn8owakoAz6gAUC8XRl0sEteDW5_KZdFGxmWMObsL4EKOZtkpX1s-nJad6m_v4jLmc6RKipaqzXO_jC3yyPH5UvRle82-fkT7lLXsNfKLxfvrwjSpk-HlJMzCIi3KXJvqQYbakU-AukjpNuaC0-aG6Cvbg9t3PfMMzzKE4Q8hpSRN5yu_ySr1m246F-lRx9OCyhT20CQBX0lKRGnnM-GEka4dzw52hyZHvopTetdyNyGGkoWTi0X1GCirmS40gvQY-OjyovUhGWLA";

    /**
     * 系统用户类型
     */
    String USER_ADMIN = "0";
    String USER_NORMAL = "1";

    /**
     * 返回检验码
     */
    String UNIQUE = "0";
    String NOT_UNIQUE = "1";

    /**
     * 有效状态
     */
    String STATUS_TRUE = "0";
    String STATUS_FALSE = "1";

    /**
     * 删除状态
     */
    String DEL_FALSE = "0";
    String DEL_TRUE = "1";

    /**
     * 菜单类型
     */
    String MENU_TYPE_M = "0";
    String MENU_TYPE_C = "1";
    String MENU_TYPE_P = "2"; // 前台

    /**
     * 支付单状态状态，0未支付,1已支付，2支付超时
     */
    String ORDER_STATUS_0 = "0";
    String ORDER_STATUS_1 = "1";
    String ORDER_STATUS_2 = "2";

    /**
     * 订单子项目支付状态
     * 0未支付，1已支付，2，已退费  3，已完成
     */
    String ORDER_DETAILS_STATUS_0 = "0";
    String ORDER_DETAILS_STATUS_1 = "1";
    String ORDER_DETAILS_STATUS_2 = "2";
    String ORDER_DETAILS_STATUS_3 = "3";

    /**
     * 支付类型
     */
    String PAY_TYPE_0 = "0";//现金
    String PAY_TYPE_1 = "1";//支付宝

    /**
     * redis的字典前缀
     */
    String DICT_REDIS_PROFIX = "dict:";

    /**
     * 登陆状态  0 成功  1失败
     */
    String LOGIN_SUCCESS = "0";
    String LOGIN_ERROR = "1";

    /**
     * 登陆类型 0系统用户 1前台用户
     */
    String LOGIN_TYPE_SYSTEM = "0";
    String LOGIN_TYPE_MEMBER = "1";
}
