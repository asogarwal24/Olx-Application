/*package com.zensar.olxlogin.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.olxlogin.entity.User;

public interface LoginService {

	String getLogIn();

	User registerUser();

	String deleteAllUsers();

	String deleteUser(int id);

	List<User> getAllUsers();

	User getUser(int id);
}*/

package com.zensar.olxlogin.service;

import java.util.List;

import com.zensar.olxlogin.entity.User;

public interface LoginService {
	
	public User registerUser( User user);
	public User userAuthentication(User user, String token);
	public List<User> getAllUsers();
	public boolean deleteUser(String token);
}
