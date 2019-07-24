package com.sk.sample.mall.user.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.sample.mall.user.domain.model.User;

public interface UserService {
	User findById(Long id);
	List<User> findAll();
	Page<User> findAll(Pageable pageable);
	
	List<User> findByNameLike(String name);
	User findByEmail(String email);
	
	User register(User user);
	User update(Long id, User user);

	void delete(Long id);
}
