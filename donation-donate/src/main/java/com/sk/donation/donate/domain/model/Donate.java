package com.sk.donation.donate.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.donation.donate.base.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Donate extends AbstractEntity {
	// private int donateSeq;
	private String prodId;
	private String userId;
	private String mrchtId;
	// private Character donateState;
	private int amount;
	private Date regDate;

	@Enumerated(EnumType.STRING)
	private DonateState donateState;

	public Donate(String prodId, String userId, String mrchtId, int amount) {
		this(prodId, userId, mrchtId, DonateState.REQUEST, amount, getNow());
	}

	public Donate(String prodId, String userId, String mrchtId, DonateState donateState, int amount, Date regDate) {
		// this.donateSeq = donateSeq;
		this.prodId = prodId;
		this.userId = userId;
		this.mrchtId = mrchtId;
		this.donateState = donateState;
		this.amount = amount;
		this.regDate = regDate;
	}

	private static Date getNow() {
		Date date = new Date();
		return date;
	}

}
