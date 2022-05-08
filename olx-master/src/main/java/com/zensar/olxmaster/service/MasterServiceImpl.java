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

//	static List<Category> category = new ArrayList<>();
//	static List<Status> status = new ArrayList<>();
//	static {
//		category.add(new Category(1, "Furniture"));
//		category.add(new Category(2, "Cars"));
//		category.add(new Category(3, "Mobile Phones"));
//		category.add(new Category(4, "Real Estate"));
//		category.add(new Category(5, "Sports"));
//		status.add(new Status(201, "Open"));
//		status.add(new Status(202, "Closed"));
//		status.add(new Status(203, "Closed"));
//		status.add(new Status(204, "Open"));
//		status.add(new Status(205, "Open"));
//	}
	
	
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