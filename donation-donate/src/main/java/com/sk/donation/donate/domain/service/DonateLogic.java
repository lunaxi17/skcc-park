package com.sk.donation.donate.domain.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sk.donation.donate.domain.model.Donate;
import com.sk.donation.donate.domain.repository.DonateRepository;
import com.sk.donation.donate.util.DateUtil;

@Service("accountLogic")
public class DonateLogic implements DonateService {
	@Autowired
	private DonateRepository donateRepository;
	
	@Autowired
	private static DateUtil dateUtil;
	
	@Override
	@Transactional(readOnly=true)
	public List<Donate> findAll() {
		return (List<Donate>) donateRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<Donate> findAll(Pageable pageable) {
		return donateRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Donate findByDonateSeq(Long donateSeq) {
		return donateRepository.findByDonateSeq(donateSeq);
	}

	@Override
	@Transactional
	public Donate register(Donate donate) {
		Donate reqDonate = new Donate(donate.getProdId(), donate.getUserId(), donate.getMrchtId(), donate.getAmount());
		return donateRepository.save(reqDonate);
	}
	
	@Override
	@Transactional
	public Donate update(Long donateSeq, Donate newDonate) {
		Donate oldDonate = donateRepository.findOne(donateSeq);
		if(oldDonate != null) {
			if(!"".equals(newDonate.getDonateState()) && null != newDonate.getDonateState()) {
				oldDonate.setDonateState(newDonate.getDonateState());
			}
			
			if(!"".equals(newDonate.getAmount())) {
				oldDonate.setAmount(newDonate.getAmount());
			}
			
			oldDonate.setUpdDate(dateUtil.getNow());
			
			return donateRepository.save(oldDonate);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional
	public void delete(Long donateSeq) {
		donateRepository.delete(donateSeq);
	}
}
