package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {
	
	void save(User u);

	User getByUser_Code(String user_code);
	
}
