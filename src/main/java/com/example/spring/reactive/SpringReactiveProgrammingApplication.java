package com.example.spring.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.example.spring.reactive.model.Stock;
import com.example.spring.reactive.repository.StockMongoReactiveCrudRepository;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringReactiveProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveProgrammingApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(StockMongoReactiveCrudRepository mongoRepository) {
		return (p) -> {
			mongoRepository.deleteAll().block();
			mongoRepository.save(new Stock("IBM", "IBM Corporation", "Desc")).block();
			mongoRepository.save(new Stock("GGL", "Google", "Desc")).block();
			mongoRepository.save(new Stock("MST", "Microsoft", "Desc")).block();
		};
	}

}