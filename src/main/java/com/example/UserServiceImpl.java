package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User create(User user) {
		return repository.insert(user);
	}

	@Override
	public void delete(String id) {
		repository.delete(id);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(String id) {
		return repository.findOne(id);
	}

	@Override
	public User update(User user) {
		return repository.save(user);
	}

}
