
package com.zensar.olxlogin.service;

import java.util.List;

import com.zensar.olxlogin.entity.User;

public interface LoginService {

	public User registerUser(User user);

	public User userAuthentication(User user, String token);

	public List<User> getAllUsers();

	public boolean deleteUser(String token);
}
