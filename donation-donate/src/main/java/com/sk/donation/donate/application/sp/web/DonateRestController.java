package com.sk.donation.donate.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.donation.donate.domain.model.Donate;
import com.sk.donation.donate.domain.service.DonateService;

@RestController
@RequestMapping("/v1/donate")
public class DonateRestController implements DonateService {
	@Autowired
	private DonateService donateService;

	@Override
	@GetMapping
	public List<Donate> findAll() {
		return donateService.findAll(); 
	}
	
	@Override
	public Page<Donate> findAll(Pageable pageable) {
		return donateService.findAll(pageable); 
	}
	
	@Override
	@GetMapping("/{donateSeq}")
	public Donate findByDonateSeq(@PathVariable("donateSeq") Long donateSeq) {
		return donateService.findByDonateSeq(donateSeq);
	}

	@Override
	@PostMapping
	public Donate register(@RequestBody Donate donate) {
		return donateService.register(donate);
	}

	@Override
	@PutMapping("/{donateSeq}")
	public Donate update(@PathVariable("donateSeq") Long donateSeq, @RequestBody Donate donate) {
		return donateService.update(donateSeq, donate);
	}

	@Override
	@DeleteMapping("/{donateSeq}")
	public void delete(@PathVariable("donateSeq") Long donateSeq) {
		donateService.delete(donateSeq);
	}
	
}
