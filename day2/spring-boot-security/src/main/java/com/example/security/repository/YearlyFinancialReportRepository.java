package com.example.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.entity.YearlyFinancialReport;

@Repository
public interface YearlyFinancialReportRepository extends JpaRepository<YearlyFinancialReport,Integer>{

}
