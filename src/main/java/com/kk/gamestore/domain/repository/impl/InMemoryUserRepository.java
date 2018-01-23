package com.kk.gamestore.domain.repository.impl;


import java.util.List;

import com.kk.gamestore.domain.User;
import com.kk.gamestore.domain.repository.UserRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUserRepository implements UserRepository {
		
		private static final Logger logger = LoggerFactory.getLogger(InMemoryUserRepository.class);
		private SessionFactory sessionFactory;
		public void setSessionFactory(SessionFactory sf){
			this.sessionFactory = sf;
		}
		@Override
		public void addUser(User user) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(user);
			logger.info("Pomyœlne dodanie u¿ytkownika o danych: "+ user);
		}
		@Override
		public void updateUser(User user) {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(user);
			logger.info("Pomyœlna aktualizacja danych u¿ytkownika o danych: "+ user);
		}
		@SuppressWarnings("unchecked")
		@Override
		public List<User> userList() {
			Session session = this.sessionFactory.getCurrentSession();
			List<User> userList = session.createQuery("from User").list();
//			for(User u: userList){
//				logger.info("Lista u¿ytkowników: "+u);
//			}
			return userList;
		}
		@Override
		public User getUserById(int id) {
			Session session = this.sessionFactory.getCurrentSession();		
			User user = (User) session.load(User.class, new Integer(id));
			logger.info("U¿ytkownik o wskazanym id to: " + user);
			System.out.println(user.getName());
			return user;
		}
//		@Override
//		public User getUserById(int id) {
//			List<User> all = userList();
//			User user = new User();
//			for(User u : all) {
//				if(u.getId()==id) {
//					user=u;
//					break;
//				}
//			}
//			System.out.println(all);
//			System.out.println(user	.getName());
//			return user;
//		}
		@Override
		public void deleteUser(User user) {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(user);
		}
}