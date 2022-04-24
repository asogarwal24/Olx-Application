package com.zensar.olxlogin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.olxlogin.entity.User;

@Service
public class LoginServiceImpl implements LoginService {

	static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1, "Anand", "Kulkarni", "anand", "anand123", "anand@gmail.com", "12345"));
	}

	@Override
	public User registerUser(User user) {
		users.add(user);
		return user;
	}

	@Override
	public User userAuthentication(User user, String token) {
		for (User verifiedUser : users) {
			if (verifiedUser.getUserName() == "anand" && verifiedUser.getPassword() == "anand123")
				return user;
		}

		return null ;
	}

	@Override
	public List<User> getAllUsers() {

		return users;
	}

	@Override
	public boolean deleteUser(String token) {
		if (token.equals("abhi12345")) {
			return true;
		} else {
			return false;
		}
	}

}
