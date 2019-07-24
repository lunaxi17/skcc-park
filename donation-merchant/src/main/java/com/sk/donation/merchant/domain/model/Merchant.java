package com.sk.donation.merchant.domain.model;

import java.util.Date;
import javax.persistence.Entity;

import com.sk.donation.merchant.base.AbstractEntity;
import com.sk.donation.merchant.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Merchant extends AbstractEntity implements AggregateRoot {
	private String userId;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String corpNum;
	private Date regDate;
	private Date editDate;
	
	private Address address;
	
	public Merchant(String email, String name, String userId, String password, String phone, String corpNum, Date regDate) {
		this.email = email;
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.phone = phone;
		this.corpNum = corpNum;
		this.regDate = regDate;
		this.editDate = regDate;
	}
}

