package com.sky.vo;

import com.sky.constants.HttpStatus;

import java.util.HashMap;

/**
 * 公用的返回 VO 对象
 * @author sky
 * @create 2020-10-30 21:52
 */
public class R extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 数据总条数
     */
    public static final String DATA_TOTAL = "total";

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表;''示一个空消息。
     */
    public R() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public R(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public R(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code  状态码
     * @param msg   返回内容
     * @param data  数据对象
     * @param total 数据总条数
     */
    public R(int code, String msg, Object data, Long total) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
        super.put(DATA_TOTAL, total);
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static R success() {
        return R.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static R success(Object data) {
        return R.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static R success(String msg) {
        return R.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static R success(String msg, Object data) {
        return new R(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static R success(String msg, Object data, Long total) {
        return new R(HttpStatus.SUCCESS, msg, data,total);
    }

    /**
     * 返回失败消息
     */
    public static R fail() {
        return R.fail("操作失败");
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static R fail(String msg) {
        return R.fail(msg, null);
    }

    /**
     * 返回失败消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static R fail(String msg, Object data) {
        return new R(HttpStatus.BAD_REQUEST, msg, data);
    }

    /**
     * 返回错误消息
     */
    public static R error() {
        return R.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static R error(String msg) {
        return R.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static R error(String msg, Object data) {
        return new R(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static R error(int code, String msg) {
        return new R(code, msg, null);
    }

    /**
     * 返回消息
     *
     * @param rows 状态码
     * @return 添加修改删除转化信息
     */
    public static R toAjax(int rows) {
        return rows > 0 ? R.success() : R.fail();
    }

}
