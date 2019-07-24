package com.sk.donation.merchant;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sk.donation.merchant.domain.model.Address;
import com.sk.donation.merchant.domain.model.Merchant;
import com.sk.donation.merchant.domain.repository.MerchantRepository;

@SpringBootApplication
public class MerchantApplication {
	public static void main(String[] args) {
		SpringApplication.run(MerchantApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(MerchantRepository merchantRepository) {
		return (args) -> {
			insertAccounts(merchantRepository);
			displayAccounts(merchantRepository);
		};
	}

	public void insertAccounts(MerchantRepository merchantRepository) {
		Date date = new Date();

		Merchant merchant1 = new Merchant("hong@sk.com", "홍길동", "testid1", "password1", "000-0000-0000", "ASDASD1",
				date);
		merchant1.setAddress(new Address(12345, "서울시 강남구"));
		merchantRepository.save(merchant1);

		Merchant merchant2 = new Merchant("kang@sk.com", "강호동", "testid2", "password2", "000-0000-0000", "ASDASD2",
				date);
		merchant2.setAddress(new Address(10000, "경기도 성남시"));
		merchantRepository.save(merchant2);

		Merchant merchant3 = new Merchant("yu@gmail.com", "유재석", "testid3", "password3", "000-0000-0000", "ASDASD3",
				date);
		merchantRepository.save(merchant3);

		Merchant merchant4 = new Merchant("shin@sk.com", "신동엽", "testid4", "password4", "000-0000-0000", "ASDASD4",
				date);
		merchant4.setAddress(new Address(12345, "서울시 강남구"));
		merchantRepository.save(merchant4);

	}

	public void displayAccounts(MerchantRepository merchantRepository) {
		System.out.println("***************************************************************");

		Iterable<Merchant> merchantList = merchantRepository.findAll();
		for (Merchant merchant : merchantList) {
			System.out.println(merchant.toString());
		}

		System.out.println("***************************************************************");
	}

}
