package com.zensar.olxadvertise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zensar.olxadvertise.entity.Advertise;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	static List<Advertise> advertises = new ArrayList<>();
	static {
		advertises.add(new Advertise(1, "laptop", "54000", "Electronics Goods", "Intel Core 3 Sony Vaio", "anand",
				"xxx", "xxx", "Open"));
		advertises.add(new Advertise(2, "Computer", "59000", "Computer Goods", "Intel Core 9 Razor Gaming", "anand",
				"xxx", "xxx", "Open"));
	}

	@Override
	public List<Advertise> getAllAdvertises() {
		return advertises;
	}

	@Override
	public Advertise createAdvertise(Advertise advertise, String token) {
		if (token.equals("abhi12345")) {
			advertises.add(advertise);
		} else {
			return null;
		}
		return advertise;
	}

	@Override
	public Advertise updateAdvertise(int advertiseId, Advertise advertise) {
		Advertise availableAdvertise = getAdvertise(advertiseId);
		availableAdvertise.setAdvertiseTitle(advertise.getAdvertiseTitle());
		availableAdvertise.setAdvertisePrice(advertise.getAdvertisePrice());
		availableAdvertise.setAdvertiseCategory(advertise.getAdvertiseCategory());
		availableAdvertise.setAdvertiseStatus(advertise.getAdvertiseStatus());
		availableAdvertise.setAdvertiseDescription(advertise.getAdvertiseDescription());
		return availableAdvertise;
	}

	@Override
	public List<Advertise> getAllAdvertisesByUser(String token) {
		if (token.equals("abhi12345")) {
			return advertises;
		} else {
			return null;
		}
	}

	@Override
	public Advertise getSpecificAdvertise(int postId, String token) {
		if (token.equals("abhi12345")) {
			for (Advertise advertise : advertises)
				if (advertise.getAdvertiseId() == postId) {
					return advertise;
				} else {
					return null;
				}
		}
		return null;
	}

	@Override
	public boolean deleteSpecificAdvertise(int postId, String token) {
		if (token.equals("abhi12345")) {
			for (Advertise advertise : advertises)
				if (advertise.getAdvertiseId() == postId) {
					advertises.remove(advertise);
					return true;
				} else {
					return false;
				}
		}
		return false;
	}

	@Override
	public Advertise getAdvertise(long advertiseId) {
		for (Advertise advertise : advertises)
			if (advertise.getAdvertiseId() == advertiseId) {
				return advertise;
			}
		return null;
	}

	@Override
	public Advertise filterBasedSearchAdvertise() {
		String filterText = "open";
		Optional<Advertise> findAny = advertises.stream()
				.filter(criteria -> criteria.toString().toLowerCase().contains(filterText)).findAny();
		if (findAny.isPresent()) {
			return findAny.get();
		} else {
			return null;
		}
	}

	@Override
	public Advertise searchAdvertise() {
		String searchText = "closed";
		Optional<Advertise> findAny = advertises.stream()
				.filter(criteria -> criteria.toString().toLowerCase().contains(searchText)).findAny();
		if (findAny.isPresent()) {
			return findAny.get();
		} else {
			return null;
		}

	}

	@Override
	public List<Advertise> getAllAdvertises(int postId2, String token) {
		if (token.equals("abhi12345")) {
			for (Advertise advertise1 : advertises)
				if (advertise1.getAdvertiseId() == postId2) {
					return advertises;
				} else {
					return null;
				}
		}
		return null;
	}

}