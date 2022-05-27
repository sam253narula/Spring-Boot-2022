package com.microstream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microstream.model.FullName;
import com.microstream.model.MicroStream;
import com.microstream.service.MicrostreamService;

//@Controller
@RestController
public class MicrostreamController {

//	@Autowired
//	MicrostreamService microstreamService;
//
//	@GetMapping("/info")
//	// @ResponseBody
//	public MicroStream getInfo() {
//		return microstreamService.getInfo();
//	}
//
//	@PostMapping("/customInfo")
//	public MicroStream getCustomInfo(String courseName, String courseType, String instructorName) {
//		return microstreamService.getCustomInfo(courseName, courseType, instructorName);
//	}
}
