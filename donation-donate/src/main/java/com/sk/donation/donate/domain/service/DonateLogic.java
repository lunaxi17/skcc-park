package com.sk.donation.donate.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.donation.donate.domain.model.Donate;
import com.sk.donation.donate.domain.repository.DonateRepository;

@Service("accountLogic")
public class DonateLogic implements DonateService {
	@Autowired
	private DonateRepository donateRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Donate> findAll() {
		return (List<Donate>) donateRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Donate findByDonateSeq(int donateSeq) {
		return donateRepository.findByDonateSeq(donateSeq);
	}

	
	/*

	@Override
	@Transactional(readOnly=true)
	public List<Donate> findByNameLike(String name) {
		return accountRepository.findByNameLike(name);
	}

	@Override
	@Transactional(readOnly=true)
	public Donate findByEmail(String email) {
		return accountRepository.findByEmail(email);
	}
	


	
	@Override
	@Transactional(readOnly=true)
	public Page<Donate> findAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Donate register(Donate account) {
		return accountRepository.save(account);
	}

	@Override
	@Transactional
	public Donate update(Long id, Donate newAccount) {
		Donate oldAccount = accountRepository.findOne(id);
		if(oldAccount != null) {
			BeanUtils.copyProperties(newAccount,  oldAccount, "id");
			return accountRepository.save(oldAccount);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		accountRepository.delete(id);
	}
	*/
}
