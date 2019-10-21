package com.example.spring.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.spring.reactive.model.Stock;

public interface StockMongoReactiveCrudRepository extends ReactiveCrudRepository<Stock, String> {

}
