package cn.itcast.dao;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	@Override
	public void save(User u) {
		getHibernateTemplate().save(u);
	}

	@Override
	public User getByUser_Code(String user_code) {
		//Criteria
		//创建离线Criteria查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		//添加参数
		dc.add(Restrictions.eq("user_code", user_code));
		//调用模板执行查询
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		return list!=null&&list.size()>0?list.get(0):null;
	}

}
