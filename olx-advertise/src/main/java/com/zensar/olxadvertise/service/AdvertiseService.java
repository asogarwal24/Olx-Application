package com.zensar.olxadvertise.service;

import java.util.List;

import com.zensar.olxadvertise.entity.Advertise;

public interface AdvertiseService {

	public List<Advertise> getAllAdvertises();

	public Advertise createAdvertise(Advertise advertise, String token);

	public Advertise updateAdvertise(int advertiseId, Advertise advertise);

	public List<Advertise> getAllAdvertisesByUser(String token);

	public Advertise getSpecificAdvertise(int postId, String token);

	public boolean deleteSpecificAdvertise(int postId, String token);

	public Advertise getAdvertise(int advertiseId);

	public Advertise filterBasedSearchAdvertise();

	public Advertise searchAdvertise();

	public List<Advertise> getAllAdvertises(int postId2, String token);
}
