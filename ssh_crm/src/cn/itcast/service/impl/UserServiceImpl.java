package cn.itcast.service.impl;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao ud;
	
	@Override
	@Transactional(readOnly=false)
	public void regist(User u) {
		//校验登录名不能重复
		User existU = ud.getByUser_Code(u.getUser_code());
		
		if(existU!=null){
			throw new RuntimeException("用户名已经存在!");
		}
		//调用Dao保存
		ud.save(u);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

}
