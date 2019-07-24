package com.sk.donation.donate.domain.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.donation.donate.domain.model.Donate;

@RepositoryRestResource
public interface DonateRepository extends PagingAndSortingRepository<Donate, Long>,
                                           QueryDslPredicateExecutor<Donate> {
	
	List<Donate> findAll(Predicate predicate);
	
	//Donate findByDonateSeq(@Param("donateSeq") int donateSeq);
	
	/*
	List<Donate> findByNameLike(@Param("name") String name);
	List<Donate> findAll();
	
	List<Donate> findByAddressZipCode(@Param("zipCode") Integer zipCode);
	
	@Query("select a from Account a where a.address.homeAddress like %?1%")
	List<Donate> findByAddressHomeAddressLike(@Param("homeAddress") String homeAddress);
	

	*/
}
