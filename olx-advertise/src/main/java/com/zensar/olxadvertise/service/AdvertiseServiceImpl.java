package com.zensar.olxadvertise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxadvertise.entity.Advertise;
import com.zensar.olxadvertise.repository.AdvertiseRepository;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	@Autowired
	private AdvertiseRepository advertiseRepository;
//	static List<Advertise> advertises = new ArrayList<>();
//	static {
//		advertises.add(new Advertise(1, "laptop", "54000", "Electronics Goods", "Intel Core 3 Sony Vaio", "anand",
//				"xxx", "xxx", "Open"));
//		advertises.add(new Advertise(2, "Computer", "59000", "Computer Goods", "Intel Core 9 Razor Gaming", "anand",
//				"xxx", "xxx", "Open"));
//	}
	
	@Override
	public List<Advertise> getAllAdvertises() {
		return advertiseRepository.findAll();
	}

	@Override
	public Advertise createAdvertise(Advertise advertise, String token) {
		if (token.equals("abhi12345")) {
			advertiseRepository.save(advertise);
		} else {
			return null;
		}
		return advertise;
	}

	@Override
	public Advertise getAdvertise(int advertiseId) {
		Optional<Advertise> findById = advertiseRepository.findById(advertiseId);
		if(findById.isPresent()) {
			Advertise advertise = findById.get();
			return advertise;
			}
			else return null;
	}

	@Override
	public Advertise updateAdvertise(int advertiseId, Advertise advertise) {
		Advertise availableAdvertise = getAdvertise(advertiseId);
		return advertiseRepository.save(advertise);
	}

	@Override
	public List<Advertise> getAllAdvertisesByUser(String token) {
		if(token.equals("abhi12345"))
		{
			return advertiseRepository.findAll();
		}
		else
		{
			return null;
		}
	}

	@Override
	public Advertise getSpecificAdvertise(int postId, String token) {
		if(token.equals("abhi12345"))
		{
			Optional<Advertise> findById = advertiseRepository.findById(postId);
			if(findById.isPresent()) {
				Advertise advertise = findById.get();
				return advertise;
				}
				else return null;
		}
		return null;
	}

	@Override
	public boolean deleteSpecificAdvertise(int postId, String token) {
		if(token.equals("abhi12345"))
		{
			advertiseRepository.deleteById(postId);
			return true;
		}
		return false;
	}

	@Override
	public Advertise filterBasedSearchAdvertise() {

		return null;
	}

	@Override
	public Advertise searchAdvertise() {

		return null;
	}

	@Override
	public List<Advertise> getAllAdvertises(int postId2, String token) {
		
			return advertiseRepository.findAll();
		
	}

}