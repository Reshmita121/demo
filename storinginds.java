package com.assesment.demo.controller;

import java.util.Map;
import io.restassured.RestAssured;

public class storinginds {
		
		public static void main(String[] args) {
			
			Map jsonResponseAsMap = RestAssured
			.get("http://www.mocky.io/v2/5ecfd630320000f1aee3d64d")
			.as(Map.class);
			
			String firstname = (String) jsonResponseAsMap.get("first_name");
			System.out.println(firstname);
			jsonResponseAsMap.keySet().forEach(k -> System.out.println(k));
			
		}

	}
