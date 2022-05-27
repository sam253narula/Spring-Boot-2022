package com.microstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microstream.entity.Bookstore;

@Repository
public interface BookstoreRepository extends JpaRepository<Bookstore, Long>{
	

}
