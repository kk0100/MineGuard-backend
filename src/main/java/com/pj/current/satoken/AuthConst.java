package com.pj.current.satoken;

/**
 * 权限码常量  
 * @author kong
 *
 */
public final class AuthConst {

	/**
	 *  私有构造方法 
	 */
	private AuthConst() {
	}
	
	
	// --------------- 代表身份的权限 --------------- 
	
	public static final String BAS = "bas"; 			 // 身份相关 
	public static final String DEV = "dev"; 			 // 开发者权限 	--- 系统最高权限
	public static final String IN_SYSTEM = "in-system";		  // 进入后台权限，没有此权限无法进入后台管理
	
	
	// --------------- 所有权限码 --------------- 

	public static final String AUTH = "auth";		   // 权限管理
	public static final String ROLE_LIST = "role-list";		    // 权限管理 - 角色管理
	public static final String MENU_LIST = "menu-list";		   // 权限管理 - 菜单列表
	public static final String ADMIN_LIST = "admin-list";		   // 权限管理 - 管理员列表
	public static final String ADMIN_ADD = "admin-add";		   // 权限管理 - 管理员添加

	public static final String CONSOLE = "console";		   // 监控中心
	public static final String SQL_CONSOLE = "sql-console";		      // 监控中心 - SQL监控
	public static final String REDIS_CONSOLE = "redis-console";		   // 监控中心 - Redis 控制台
	public static final String APILOG_LIST = "apilog-list";		   // 监控中心 - API 请求日志

	public static final String SP_CFG = "sp-cfg";		  	 // 系统配置
	public static final String SP_CFG_APP = "sp-cfg-app";		  	 // 系统配置 - 系统对公配置
	public static final String SP_CFG_SERVER = "sp-cfg-server";		   // 系统配置 - 服务器私有配置

	public static final String SP_USER_LOGIN = "sp-user-login";
	public static final String USER_LIST = "user-list";
	public static final String USER_ADD = "user-add";
	// --------------- 其它常量 --------------- 
	
	/** 在 SaSession 上存储 角色id 使用的key */
	public static final String ROLE_ID_KEY = "ROLE_ID";		   
	
}
