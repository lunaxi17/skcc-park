package com.sk.donation.merchant.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.donation.merchant.domain.model.Merchant;

public interface MerchantService {
	Merchant findById(Long id);
	List<Merchant> findAll();
	Page<Merchant> findAll(Pageable pageable);
	
	List<Merchant> findByNameLike(String name);
	Merchant findByEmail(String email);
	
	Merchant register(Merchant merchant);
	Merchant update(Long id, Merchant merchant);

	void delete(Long id);
	Merchant findByUserId(String userId);
	Merchant findByUserIdAndPassword(String userId, String password);
}
