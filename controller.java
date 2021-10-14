package com.assesment.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class controller {
	@GetMapping("/home")

	public String home() {
		return "this is home page";
	}
	
@GetMapping (value = "/callclienthello")

	private String getHelloClient() {

	String uri = "http://www.mocky.io/v2/5ecfd5dc3200006200e3d64b";

	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(uri, String.class);
	return result;
}
@GetMapping (value = "/callclienthello1")

private String getHelloClient1() {

String uri = "http://www.mocky.io/v2/5ecfd630320000f1aee3d64d";

RestTemplate restTemplate = new RestTemplate();
String result = restTemplate.getForObject(uri, String.class);
return result;
}
@GetMapping (value = "/callclienthello2")

private String getHelloClient2() {

String uri = "http://www.mocky.io/v2/5ecfd6473200009dc1e3d64e";

RestTemplate restTemplate = new RestTemplate();
String result = restTemplate.getForObject(uri, String.class);
return result;
}
}

@Service
 class client {
    RestTemplate restTemplate = new RestTemplate();

    @Async
    public CompletableFuture<List<controller>> getDetailsOfFirstApi(String language) {
        String url = "http://www.mocky.io/v2/5ecfd5dc3200006200e3d64b" + language + "?fields=name";
        controller[] response = restTemplate.getForObject(url, controller[].class);
        System.out.println("First");
        return CompletableFuture.completedFuture(Arrays.asList(response));
    }

    @Async
    public CompletableFuture<List<controller>> getDetailsOfSecondApi(String region) {
        String url = "http://www.mocky.io/v2/5ecfd630320000f1aee3d64d" + region + "?fields=name";
        controller[] response = restTemplate.getForObject(url, controller[].class);
        System.out.println("Second");
        return CompletableFuture.completedFuture(Arrays.asList(response));
    }
    @Async
    public CompletableFuture<List<controller>> getDetailsOfThirdApi(String region) {
        String url = "http://www.mocky.io/v2/5ecfd6473200009dc1e3d64e" + region + "?fields=name";
        controller[] response = restTemplate.getForObject(url, controller[].class);
System.out.println("Third");
        return CompletableFuture.completedFuture(Arrays.asList(response));
    }
  @GetMapping("/linking")
    public ResponseEntity<String> getAllapis() {
           		
    		CompletableFuture<List<controller>> callclienthello = getDetailsOfFirstApi("First api");
    		CompletableFuture<List<controller>> callclienthello1 = getDetailsOfSecondApi("Second api");
    		CompletableFuture<List<controller>> callclienthello2 = getDetailsOfThirdApi("Third api");
    		
    		CompletableFuture<Void> completableFutureCombined = CompletableFuture.allOf(callclienthello,callclienthello1,callclienthello2);
    		completableFutureCombined.join();
    		return new ResponseEntity<String>("",HttpStatus.OK);
    	}
    }

