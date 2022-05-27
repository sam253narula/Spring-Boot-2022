package com.example.security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.entity.InventoryDetails;
import com.example.security.entity.YearlyFinancialReport;
import com.example.security.repository.EmployeeRepository;
import com.example.security.repository.InventoryDetailsRepository;
import com.example.security.repository.YearlyFinancialReportRepository;
import com.example.security.service.RetailStoreService;

@Service
public class RetailStoreServiceImpl implements RetailStoreService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	InventoryDetailsRepository inventoryDetailsRepository;

	@Autowired
	YearlyFinancialReportRepository yearlyFinancialReportRepository;
	
	@Override
	public boolean checkInventoryExist(int id) {
		return inventoryDetailsRepository.existsById(id);
	}
	
	@Override
	public List<InventoryDetails> viewInventory() {
		return inventoryDetailsRepository.findAll();
	}
	
	@Override
	public String makeAnnouncement(String discount) {
		return discount +"% off";
	}

	@Override
	public List<YearlyFinancialReport> viewFinancials() {
		return yearlyFinancialReportRepository.findAll();
	}
	
	@Override
	public String doCheckout() {
		return "fake Checkout";
	}
	
}
