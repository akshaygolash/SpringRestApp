package com.akshay.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.akshay.entity.User;

@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> getAll() {
		TypedQuery<User> query = em.createNamedQuery("User.getAll",User.class);
		return query.getResultList();
	}

	@Override
	public User getUserById(String userId) {
		return em.find(User.class,userId);
	}

	@Override
	public User getUserByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.getByEmail",User.class);
		query.setParameter("uEmail", email);
		List<User> users = query.getResultList();
		if(users.size() == 1){
			return users.get(0);
		}else{
			return null;
		}
	
	}

	@Override
	public User crateUser(User user) {
	em.persist(user);
	return user;
	}

	@Override
	public User updateUser(User user) {
		return em.merge(user);
	}

	@Override
	public void deleteUser(User existingUser) {
		em.remove(existingUser);
		
	}

}
