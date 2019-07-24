package com.sk.donation.merchant.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.donation.merchant.domain.model.Merchant;
import com.sk.donation.merchant.domain.repository.MerchantRepository;

@Service("MerchantLogic")
public class MerchantLogic implements MerchantService {
	@Autowired
	private MerchantRepository merchantRepository;

	@Override
	@Transactional(readOnly=true)
	public Merchant findById(Long id) {
		return merchantRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Merchant> findByNameLike(String name) {
		return merchantRepository.findByNameLike(name);
	}

	@Override
	@Transactional(readOnly=true)
	public Merchant findByEmail(String email) {
		return merchantRepository.findByEmail(email);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Merchant> findAll() {
		return merchantRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Merchant> findAll(Pageable pageable) {
		return merchantRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Merchant register(Merchant merchant) {
		return merchantRepository.save(merchant);
	}

	@Override
	@Transactional
	public Merchant findByUserId(String userId) {
		if(!userId.equals(null)) {
			return merchantRepository.findByUserId(userId);
		}else {
			return null;
		}
	}
	
	@Override
	@Transactional
	public Merchant findByUserIdAndPassword(String userId, String password) {
		if(!userId.equals(null) && !password.equals(null)) {
			return merchantRepository.findByUserIdAndPassword(userId, password);
		}else{
			return null;
		}
	}
	
	
	@Override
	@Transactional
	public Merchant update(Long id, Merchant newMerchant) {
		Merchant oldMerchant = merchantRepository.findOne(id);
		if(oldMerchant != null) {
			BeanUtils.copyProperties(newMerchant,  oldMerchant, "id");
			return merchantRepository.save(oldMerchant);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		merchantRepository.delete(id);
	}
}
