package com.example.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.entity.InventoryDetails;
import com.example.security.entity.YearlyFinancialReport;
import com.example.security.service.RetailStoreService;

@RestController
@RequestMapping("/organicVeggies")
public class RetailStoreController {

	@Autowired
	RetailStoreService retailStoreService;
	
	@GetMapping("/checkInventory")
	public boolean checkInventoryExist(int id) {
		return retailStoreService.checkInventoryExist(id);
	}

	@GetMapping("/viewInventory")
	public List<InventoryDetails> viewInventory() {
		return retailStoreService.viewInventory();
	}

	@PostMapping("/makeAnnouncement")
	public String makeAnnouncement(String discount) {
		return retailStoreService.makeAnnouncement(discount);
	}

	@GetMapping("/viewFinancials")
	public List<YearlyFinancialReport> viewFinancials() {
		return retailStoreService.viewFinancials();
	}

	@PostMapping("/doCheckout")
	public String doCheckout() {
		return retailStoreService.doCheckout();
	}

}
