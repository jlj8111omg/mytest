package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	
	private UserService userService;
	
	public String regist() throws Exception {
		//调用Service保存User对象
		userService.regist(user);
		//重定向到登陆页面
		return "toLogin";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		return user;
	}

	
	
}
