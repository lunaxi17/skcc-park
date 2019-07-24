package com.sk.sample.mall.user;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sk.sample.mall.user.domain.model.QUser;
import com.sk.sample.mall.user.domain.model.Address;
import com.sk.sample.mall.user.domain.model.User;
import com.sk.sample.mall.user.domain.repository.UserRepository;

@SpringBootApplication
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(UserRepository userRepository) {	
		return (args) -> {
			insertUsers(userRepository);
			displayUsers(userRepository);
			
			executeExample1(userRepository);
		};
	}
		
	public void insertUsers(UserRepository userRepository) {
		
		User user1 = new User("1001", "1001", "홍길동", "hong@sk.com", "010-4444-1111", "2019-07-19", "2019-07-19", "Y");
		userRepository.save(user1);
		
		User user2 = new User("1002", "1002", "김길동", "kim@sk.com", "010-4444-2222", "2019-07-19", "2019-07-19", "Y");
		user2.setAddress(new Address(12345, "서울시 강남구"));
		userRepository.save(user2);
		
		User user3 = new User("1003", "1003", "박길동", "park@sk.com", "010-4444-3333", "2019-07-19", "2019-07-19", "Y");
		user3.setAddress(new Address(10000, "경기도 성남시"));
		userRepository.save(user3);
		
	}
	
	public void displayUsers(UserRepository userRepository) {
		System.out.println("***************************************************************");
		
		Iterable<User> userList = userRepository.findAll();
		for(User user : userList) {
			System.out.println(user.toString());	
		}
		
		System.out.println("***************************************************************");
	}
	
	
	public void executeExample1(UserRepository userRepository) {
		User user = userRepository.findByEmail("hong@sk.com");
		
		user.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
		userRepository.save(user);
		
		displayUsers(userRepository);
	}
	
	public void executeExample2(UserRepository userRepository) {
		List<User> user = userRepository.findByAddressZipCode(12345);
		System.out.println("Result: " + user.toString());
	}
	
	public void executeExample3(UserRepository userRepository) {
		List<User> user = userRepository.findByAddressHomeAddressLike("성남");
		System.out.println("Result: " + user.toString());
	}
	
	public void executeExample4(UserRepository userRepository) {
		QUser.user.name.like("강%");
		User user = userRepository.findOne(QUser.user.email.eq("hong@sk.com"));
		
		user.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
		userRepository.save(user);
		
		displayUsers(userRepository);
	}
	
	public void executeExample5(UserRepository userRepository) {
		List<User> user = userRepository.findAll(QUser.user.address.zipCode.eq(12345));
		System.out.println("Result: " + user.toString());
	}
	
	public void executeExample6(UserRepository userRepository) {
		List<User> user = userRepository.findAll(QUser.user.address.homeAddress.like("성남"));
		System.out.println("Result: " + user.toString());
	}
	
	
	/*
	@Bean
	public CommandLineRunner execSampleCode2(@Qualifier("userLogic") UserService userService) {
		return (args) -> {
			User user = new User("iu@sk.com", "아이유", MemberType.BUYER, MembershipLevelType.VIP);
			userService.register(user);
			
			User result = userService.findByEmail("iu@sk.com");
			System.out.println("Component API Result - " + result);
			
			result.setAddress(new Address(11111, "서울시 영등포구"));
			userService.update(result.getId(), result);
			
			User result2 = userService.findByEmail("iu@sk.com");
			System.out.println("Component API Result2 - " + result2);
		};
	}
	*/
}
