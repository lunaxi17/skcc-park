package com.sk.donation.donate.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.donation.donate.domain.model.Donate;

public interface DonateService {
	
	List<Donate> findAll();
	
	Page<Donate> findAll(Pageable pageable);
	
	Donate findByDonateSeq(Long donateSeq);
	
	Donate register(Donate donate);
	
	Donate update(Long donateSeq, Donate donate);
	
	void delete(Long donateSeq);
}
