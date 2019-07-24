package com.sk.donation.donate.account.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	/*
	@Override
	@GetMapping("/search/donateSeq")
	public Donate findByDonateSeq(@PathVariable("donateSeq") int donateSeq) {
		return donateService.findByDonateSeq(donateSeq);
	}
	*/

	@Override
	@PostMapping
	public Donate register(@RequestBody Donate donate) {
		Donate reqDonate = new Donate(donate.getProdId(), donate.getUserId(), donate.getMrchtId(), donate.getAmount());
		return donateService.register(reqDonate);
	}
	/*

	@Override
	@PutMapping("/{id}")
	public Donate update(@PathVariable("id") Long id, @RequestBody Donate account) {
		return accountService.update(id, account);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		accountService.delete(id);
	}
	
	@Override
	@GetMapping("/search/name")
	public List<Donate> findByNameLike(@RequestParam("name") String name) {
		return accountService.findByNameLike(name);
	}

	@Override
	@GetMapping("/search/email")
	public Donate findByEmail(@RequestParam("email") String email) {
		return accountService.findByEmail(email);
	}

	 */

}
