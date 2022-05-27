package com.microstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microstream.serviceImpl.BookstoreCRUDServiceImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootBookstoreDesignApplication implements CommandLineRunner {

	@Autowired
	BookstoreCRUDServiceImpl bookstoreCRUDServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBookstoreDesignApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
