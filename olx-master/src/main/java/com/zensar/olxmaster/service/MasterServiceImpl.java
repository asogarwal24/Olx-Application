package com.zensar.olxmaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxmaster.entity.Category;
import com.zensar.olxmaster.entity.Status;
import com.zensar.olxmaster.repository.CategoryRepository;
import com.zensar.olxmaster.repository.StatusRepository;

@Service
public class MasterServiceImpl implements MasterService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	private StatusRepository statusRepository;


	
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public List<Status> getAllStatuses() {
		// TODO Auto-generated method stub
		return statusRepository.findAll();
	}

}