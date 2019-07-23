package com.sk.donation.donate.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.sample.mall.shared.base.AbstractEntity;
import com.sk.sample.mall.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Donate extends AbstractEntity implements AggregateRoot {
	private int donateSeq;
	private String prodId;
	private String userId;
	private String mrchtId;
	//private Character donateState;
	private int amount;
	private Date regDate;
	
	@Enumerated(EnumType.STRING)
	private DonateState donateState;
	
	public Donate(int donateSeq, String prodId, String userId, String mrchtId, int amount, Date regDate) {
		this(donateSeq, prodId, userId, mrchtId, DonateState.REQUEST, amount, regDate);
	}
	
	public Donate(int donateSeq, String prodId, String userId, String mrchtId, DonateState donateState, int amount, Date regDate) {
		this.donateSeq = donateSeq;
		this.prodId = prodId;
		this.userId = userId;
		this.mrchtId = mrchtId;
		this.donateState = donateState;
		this.amount = amount;
		this.regDate = regDate;
	}
}

