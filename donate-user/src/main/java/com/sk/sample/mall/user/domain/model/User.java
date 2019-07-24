package com.sk.sample.mall.user.domain.model;

import javax.persistence.Entity;
import com.sk.sample.mall.shared.base.AbstractEntity;
import com.sk.sample.mall.user.domain.model.Address;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class User extends AbstractEntity {
	
	private String userid;	
	private String password;
	private String name;
	private String email;
	private String phone;
	private String regDate; 
	private String editDate;
	private Address address;	
	private String acticeYN;
	
	public User(String userid, String password, String name, String email, String phone, String regDate, String editDate, String acticeYN) {
		this.userid = userid;
		this.password = password;
		this.name = name; 
		this.email = email;
		this.phone = phone;
		this.regDate = regDate;
		this.editDate = editDate;		
		this.acticeYN = acticeYN;
	}

	public void setAddress(Address address2) {
		this.address = address2;
		
	}
}

