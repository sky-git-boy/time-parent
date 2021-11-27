package com.sky.constants;

/**
 * 登录相关常量
 *
 * @author sky
 * @create 2021-11-19 18:01
 */
public interface LoginConstants {

    /**
     * 后台用户登录
     */
    String MEMBER_TYPE = "MEMBER_TYPE";

    /**
     * 后台用户登录
     */
    String ADMIN_TYPE = "ADMIN_TYPE";

    /**
     * 授权类型
     */
    String REFRESH_TYPE = "REFRESH_TYPE";

    /**
     * 查询用户 SQL
     */
    String QUERY_USER_BY_PHONE = "SELECT `user_id` ,`user_name`, `password`, `user_type`, `status`, `del_flag` FROM sys_user WHERE phone = ? ";

    /**
     * 通过 id 查询用户
     */
    String QUERY_USER_BY_ID = "select phone fro sys_user where id = ?";

    /**
     * 管理员code
     */
    String ADMIN_ROLE_CODE = "ROLE_ADMIN";

    /**
     * 获取用户角色code
     */
    String QUERY_ROLE_CODE_SQL
            = "SELECT `role_code` FROM sys_role LEFT JOIN sys_user_role ON sys_role.role_id = sys_user_role.role_id WHERE sys_user_role.user_id= ?";

    /**
     * 获取所有菜单的权限标识
     */
    String QUERY_ALL_PERMISSIONS
            = "SELECT `percode` FROM sys_menu";

    /**
     * 对于我们非超级用户，我们需要先查询 role->menuId->permission
     */
    String QUERY_PERMISSION_SQL =
            "SELECT `percode` FROM sys_menu LEFT JOIN sys_role_menu ON sys_role_menu.menu_id = sys_menu.menu_id LEFT JOIN sys_user_role ON sys_role_menu.role_id = sys_user_role.role_id WHERE sys_user_role.user_id = ?";

}
