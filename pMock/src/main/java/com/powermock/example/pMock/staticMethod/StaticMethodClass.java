package com.powermock.example.pMock.staticMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powermock.example.pMock.repo.RepositotryClass;

@Service
public class StaticMethodClass {
	@Autowired
	private RepositotryClass rclass; 
	
	public static String  staticMethod() {
		return "static method";
	}
	
	public final  String finalMethod() {
		
		return "final method";
	}
	
}
