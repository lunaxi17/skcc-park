package com.sk.sample.mall.user.application.sp.web;

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

import com.sk.sample.mall.user.domain.model.User;
import com.sk.sample.mall.user.domain.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserRestController implements UserService {
	@Autowired
	private UserService userService;

	@Override
	@GetMapping
	public List<User> findAll() {
		return userService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}

	@Override
	@PostMapping
	public User register(@RequestBody User account) {
		return userService.register(account);
	}

	@Override
	@PutMapping("/{id}")
	public User update(@PathVariable("id") Long id, @RequestBody User account) {
		return userService.update(id, account);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		userService.delete(id);
	}
	
	@Override
	@GetMapping("/search/name")
	public List<User> findByNameLike(@RequestParam("name") String name) {
		return userService.findByNameLike(name);
	}

	@Override
	@GetMapping("/search/email")
	public User findByEmail(@RequestParam("email") String email) {
		return userService.findByEmail(email);
	}

	@Override
	//@GetMapping
	public Page<User> findAll(Pageable pageable) {
		return userService.findAll(pageable); 
	}


}
