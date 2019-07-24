package com.sk.donation.merchant.application.sp.web;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.donation.merchant.domain.model.Merchant;
import com.sk.donation.merchant.domain.service.MerchantService;

@RestController
@RequestMapping("/v1/merchants")
public class MerchantRestController implements MerchantService {
	@Autowired
	private MerchantService merchantService;

	@Override
	@GetMapping
	public List<Merchant> findAll() {
		return merchantService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Merchant findById(@PathVariable("id") Long id) {
		return merchantService.findById(id);
	}

	@Override
	@PostMapping
	public Merchant register(@RequestBody Merchant merchant) {
		return merchantService.register(merchant);
	}

	@Override
	@PutMapping("/{id}")
	public Merchant update(@PathVariable("id") Long id, @RequestBody Merchant merchant) {
		return merchantService.update(id, merchant);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		merchantService.delete(id);
	}
	
	@Override
	@GetMapping("/search/name")
	public List<Merchant> findByNameLike(@RequestParam("name") String name) {
		return merchantService.findByNameLike(name);
	}

	@Override
	@GetMapping("/search/email")
	public Merchant findByEmail(@RequestParam("email") String email) {
		return merchantService.findByEmail(email);
	}

	@Override
	//@GetMapping
	public Page<Merchant> findAll(Pageable pageable) {
		return merchantService.findAll(pageable); 
	}

	@Override
	public Merchant findByUserIdAndPassword(@RequestParam("userId") String userId, @RequestParam("password") String password) {
		return merchantService.findByUserIdAndPassword(userId, password);
	}

	@Override
	public Merchant findByUserId(String userId) {
		return merchantService.findByUserId(userId);
	}

}
