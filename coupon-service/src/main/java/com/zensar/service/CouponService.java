package com.zensar.service;

import java.util.List;

import com.zensar.entity.Coupon;
import com.zensar.entity.CouponDto;

public interface CouponService {

	List<CouponDto> getAllCoupon();

	CouponDto createCoupon(CouponDto coupon, String token);

	CouponDto updateCoupon(Integer couponId, CouponDto coupon);

	String deleteAllCoupon();

	String deleteCoupon(Integer id);

	CouponDto findBycouponCode(String couponCode);

}