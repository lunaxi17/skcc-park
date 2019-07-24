package com.sk.sample.mall.user.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sample.mall.user.domain.model.User;
import com.sk.sample.mall.user.domain.repository.UserRepository;

@Service("userLogic")
public class UserLogic implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly=true)
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> findByNameLike(String name) {
		return userRepository.findByNameLike(name);
	}

	@Override
	@Transactional(readOnly=true)
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return userRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public User register(User account) {
		return userRepository.save(account);
	}

	@Override
	@Transactional
	public User update(Long id, User newAccount) {
		User oldAccount = userRepository.findOne(id);
		if(oldAccount != null) {
			BeanUtils.copyProperties(newAccount,  oldAccount, "id");
			return userRepository.save(oldAccount);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userRepository.delete(id);
	}
}
