package com.example.security.service;

import java.util.List;

import com.example.security.entity.InventoryDetails;
import com.example.security.entity.YearlyFinancialReport;

public interface RetailStoreService {

	boolean checkInventoryExist(int id);

	List<InventoryDetails> viewInventory();

	String makeAnnouncement(String discount);

	List<YearlyFinancialReport> viewFinancials();

	String doCheckout();

}