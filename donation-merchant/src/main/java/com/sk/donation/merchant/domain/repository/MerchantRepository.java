package com.sk.donation.merchant.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.donation.merchant.domain.model.Merchant;

@RepositoryRestResource
public interface MerchantRepository extends PagingAndSortingRepository<Merchant, Long>,
                                           QueryDslPredicateExecutor<Merchant> {
	
	Merchant findByEmail(@Param("email") String email);
	List<Merchant> findByNameLike(@Param("name") String name);
	List<Merchant> findAll();
	
	List<Merchant> findByAddressZipCode(@Param("zipCode") Integer zipCode);
	
	@Query("select a from Merchant a where a.address.homeAddress like %?1%")
	List<Merchant> findByAddressHomeAddressLike(@Param("homeAddress") String homeAddress);
	
	List<Merchant> findAll(Predicate predicate);
	
	
	Merchant findByUserIdAndPassword(@Param("userId") String userId, @Param("password") String password);
	
	Merchant findByUserId(@Param("userId") String userId);
	
}
