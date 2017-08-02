package cn.itcast.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Test
	public void demo1(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//--------------------------------------------------------------
		User u  = new User();
		
		u.setUser_name("tom");
		
		session.save(u);
		//--------------------------------------------------------------
		tx.commit();
		session.close();
		sf.close();
	}
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	
	@Test
	//测试spring中sessionFactory
	public void demo2(){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//--------------------------------------------------------------
		User u  = new User();
		
		u.setUser_name("rose");
		
		session.save(u);
		//--------------------------------------------------------------
		tx.commit();
		session.close();
		sf.close();
	}
	@Resource(name="userService")
	private UserService us;
	@Test
	//测试Service
	public void demo3(){
		User u  = new User();
		
		u.setUser_name("王东2");
		
		us.regist(u);
	}
}
