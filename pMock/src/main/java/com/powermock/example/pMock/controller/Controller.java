package com.powermock.example.pMock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.powermock.example.pMock.staticMethod.StaticMethodClass;

@RestController
public class Controller {
	@Autowired
	private StaticMethodClass sCLass;
	@GetMapping("/static")
public String Staticmethod() {
	return  StaticMethodClass.staticMethod();
}
	@GetMapping("/final")
public String finalmethod() {
	
	return sCLass.finalMethod(); 
}
	
}
