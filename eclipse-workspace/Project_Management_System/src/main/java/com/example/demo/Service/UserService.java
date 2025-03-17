package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.User;

public interface UserService {
	
	User SaveUser(User user);
	
	List<User> getUsers();

}
