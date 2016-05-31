package com.example;

import java.util.List;

public interface UserService {
	User create(User user);	 
    void delete(String id); 
    List<User> findAll(); 
    User findById(String id); 
    User update(User user);	
}
