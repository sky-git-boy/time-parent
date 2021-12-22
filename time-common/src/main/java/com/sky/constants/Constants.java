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
     * 验证码有效期（分钟）
     */
    long CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    String TOKEN = "token";
    String MENUS = "menus";
    String AUTHORITIES = "authorities";


    /************************************* REDIS KEY ************************************/

    /**
     * 短信验证码redis存储Key
     */
    String REDIS_KEY_SMS_CODE_KEY = "SMSCODE:";

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
    String INSIDE_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGwiXSwiZXhwIjozNzg3NjQ4NjE3LCJqdGkiOiI0MTk3ZTBkZS1iMTQ3LTRjNjAtYmM2MC0yNDQ2Y2M1NGM1YjAiLCJjbGllbnRfaWQiOiJpbnNpZGUtYXBwIn0.aBSeqQqNdBjUfSpalUO3zPmKcuNBjj_JWDswLLsHn2uRpjj5mSlnSabCgjP8FQ4Ktfs_0kkEWj0r8Svlc-jQclx_8MpyZZN6dupra9uHNA7lY7aGI9HsEts6uWXsX8a4ebdd5tmfsFiNM3QGIAc6TcWpa9jRVPBUcJ0e8R0ZTGFJlsIoTQ_oVAga4LlRx2dexp3o4pS4NSvKraSX_42uDPgDsVJsavj7JGCnKuzwc8_ZGA0Bi0ly4jPID9MRKzHgg6al_7nh_tnWeWrZfcXGt9djyxpEX8ka4Xj_ztsdu-vBL9g6W3kawPky72KzqjEhuca5ocgBMUaASGZ5-32QqQ";
    /**
     * 系统用户类型
     */
    String USER_ADMIN = "0";
    String USER_NORMAL = "1";

    /**
     * 返回检验码
     * 0注册验证码 1修改密码
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

    /**
     * 任务状态
     */
    String TASK_STATUS_TODO = "0";  // 待办
    String TASK_STATUS_DOING = "1"; // 进行中
    String TASK_STATUS_DONE = "2";  // 已办
    String TASK_STATUS_EXPIRE = "3";// 过期
}
