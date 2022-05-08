package com.zensar.olxlogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxlogin.entity.User;
import com.zensar.olxlogin.repository.LoginRepository;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	
	@Override
	public List<User> getAllUsers() {
		
		return loginRepository.findAll();
	}

	@Override
	public User userAuthentication(User user, String token) {

		return null;
	}

	@Override
	public User registerUser(User user) {
		return loginRepository.save(user);
	}

	@Override
	public boolean deleteUser(String token) {
		if(token.equals("abhi12345"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}


