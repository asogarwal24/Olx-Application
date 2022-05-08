package com.zensar.olxmaster.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int statusId;
	private String statusName;
}