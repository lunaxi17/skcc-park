package com.sk.sample.mall.user.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.mall.user.domain.model.User;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long>,
                                           QueryDslPredicateExecutor<User> {
	
	User findByEmail(@Param("email") String email);
	List<User> findByNameLike(@Param("name") String name);
	List<User> findAll();
	
	List<User> findByAddressZipCode(@Param("zipCode") Integer zipCode);
	
	@Query("select a from User a where a.address.homeAddress like %?1%")
	List<User> findByAddressHomeAddressLike(@Param("homeAddress") String homeAddress);
	

	List<User> findAll(Predicate predicate); 
	
}
