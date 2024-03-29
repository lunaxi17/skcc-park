package com.sk.donation.donate.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;

@MappedSuperclass
@EqualsAndHashCode
public abstract class AbstractEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long donateSeq;

	public Long getDonateSeq() {
		return donateSeq;
	}
}
