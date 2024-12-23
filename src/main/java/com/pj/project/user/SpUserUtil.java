package com.pj.project.user;

import cn.dev33.satoken.stp.StpUtil;
import com.pj.project.user.SpUser;
import com.pj.project.user.SpUserMapper;
import com.pj.utils.sg.AjaxError;
import com.pj.utils.sg.NbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * user工具类
 * @author kong
 *
 */
@Component
public class SpUserUtil {

	
	public static SpUserMapper spUserMapper;
	@Autowired
	public void setSpUserMapper(SpUserMapper spUserMapper) {
		SpUserUtil.spUserMapper = spUserMapper;
	}
	
	
	/**
	 * 当前admin
	 * @return
	 */
	public static SpUser getCurrUser() {
		long adminId = StpUtil.getLoginIdAsLong();
		return spUserMapper.getById(adminId);
	}
	
	/**
	 * 检查指定姓名是否合法 ,如果不合法，则抛出异常 
	 * @param adminId
	 * @param name
	 * @return
	 */
	public static boolean checkName(long adminId, String name) {
		if(NbUtil.isNull(name)) {
			throw AjaxError.get("账号名称不能为空");
		}
		if(NbUtil.isNumber(name)) {
			throw AjaxError.get("账号名称不能为纯数字");
		}
//		if(name.startsWith("a")) {
//			throw AjaxException.get("账号名称不能以字母a开头");
//		}
		// 如果能查出来数据，而且不是本人，则代表与已有数据重复
		SpUser a2 = spUserMapper.getByName(name);
		if(a2 != null && a2.getId() != adminId) {	
			throw AjaxError.get("账号名称已有账号使用，请更换");
		} 
		return true;
	}
	
	/**
	 * 检查整个admin是否合格 
	 * @param a
	 * @return
	 */
	public static boolean checkUser(SpUser a) {
		// 检查姓名 
		checkName(a.getId(), a.getName());
		// 检查密码 
		if(a.getPassword2().length() < 4) {
			throw new AjaxError("密码不得低于4位");
		}
		return true;
	}
	
	
	
	/**
	 * 指定的name是否可用 
	 * @param name
	 * @return
	 */
	public static boolean nameIsOk(String name) {
		SpUser a2 = spUserMapper.getByName(name);
		if(a2 == null) {
			return true;
		}
		return false;
	}
	
	






	
	
}
