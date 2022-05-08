package com.zensar.olxadvertise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertise.entity.Advertise;
import com.zensar.olxadvertise.service.AdvertiseService;

@RestController

public class OlxAdvertiseController {

	@Autowired
	private AdvertiseService advertiseService;

	@GetMapping(value = "/advertise", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Advertise> getAllAdvertises() {
		return advertiseService.getAllAdvertises();
	}

	@PostMapping(value = "/advertise", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Advertise createStock(@RequestBody Advertise advertise, @RequestHeader("auth-token") String token) {

		return advertiseService.createAdvertise(advertise, token);

	}

	@GetMapping(value = "/advertise/{advertiseId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Advertise getAdvertise(@PathVariable int advertiseId) {
		return advertiseService.getAdvertise(advertiseId);
	}

	@PutMapping(value = "/advertise/{advertiseId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Advertise updateStock(@PathVariable int advertiseId, @RequestBody Advertise advertise) {
		return advertiseService.updateAdvertise(advertiseId, advertise);
	}

	@GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Advertise> getAllAdvertisesByUser(@RequestHeader("auth-token") String token) {
		return advertiseService.getAllAdvertises();
	}

	@GetMapping(value = "/user/advertise/{postId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Advertise getSpecificAdvertise(@PathVariable int postId, @RequestHeader("auth-token") String token) {
		return advertiseService.getSpecificAdvertise(postId, token);
	}

	@DeleteMapping("/user/advertise/{postId}")
	public boolean deleteSpecificAdvertise(@PathVariable int postId, @RequestHeader("auth-token") String token) {
		return advertiseService.deleteSpecificAdvertise(postId, token);
	}

	@GetMapping(value = "/advertise/search/filtercriteria", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Advertise filterBasedSearchAdvertise() {
		return advertiseService.filterBasedSearchAdvertise();
	}

	@GetMapping(value = "/advertise/search", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Advertise searchAdvertise() {
		return advertiseService.searchAdvertise();
	}

	@GetMapping("/advertise/{postId2}")
	public List<Advertise> getAllAdvertises(@PathVariable int postId2, @RequestHeader("auth-token") String token) {
		return advertiseService.getAllAdvertises();
	}
}
