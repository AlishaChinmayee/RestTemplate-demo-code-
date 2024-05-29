package com.spring.rest.template;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestConsumer {
	
//	//   invoking an HTTP GET request to fetch the response body as a raw JSON string
//    public void getProductAsJson() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String resourceUrl
//          = "http://localhost:8080/products";
//
//        // Fetch JSON response as String wrapped in ResponseEntity
//        ResponseEntity<String> response
//          = restTemplate.getForEntity(resourceUrl, String.class);
//        
//        String productsJson = response.getBody();
//        
//        System.out.println(productsJson);
//    }  
//	
	
//	// get the response as a POJO class
//	public void getProducts() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String resourceUrl
//          = "http://localhost:8080/products";
//
//        // Fetch response as List wrapped in ResponseEntity
//        ResponseEntity<List> response
//          = restTemplate.getForEntity(resourceUrl, List.class);
//        
//        List<Product> products = response.getBody();
//        System.out.println(products);
//    }
	
	
//	//Instead of using getForEntity() method, using the getForObject() method
//	  public void getProductObjects() {
//	       
//	        RestTemplate restTemplate = new RestTemplate();
//
//	        String resourceUrl
//	          = "http://localhost:8080/products";
//
//	        // Fetching response as Object  
//	        List<?> products
//	          = restTemplate.getForObject(resourceUrl, List.class);
//	        
//	        System.out.println(products);
//	    }
	
//	//invoking an HTTP POST method on a REST API with the postForObject() method
//	public void createProduct() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String resourceUrl
//          = "http://localhost:8080/products";
//
//        // Create the request body by wrapping
//        // the object in HttpEntity 
//        HttpEntity<Product> request = new HttpEntity<Product>(
//            new Product("Television", "Samsung",1145.67,"S001"));
//
//        // Send the request body in HttpEntity for HTTP POST request
//        String productCreateResponse = restTemplate
//               .postForObject(resourceUrl, request, String.class);
//        
//        System.out.println(productCreateResponse);
//    }
	
//	//Using exchange() for POST
//	  public void createProductWithExchange() {
//	        RestTemplate restTemplate = new RestTemplate();
//
//	        String resourceUrl
//	          = "http://localhost:8080/products";
//
//	        // Create the request body by wrapping
//	        // the object in HttpEntity   
//	        HttpEntity<Product> request = 
//	          new HttpEntity<Product>(
//	            new Product("Television", "Samsung",1145.67,"S001"));
//
//	        ResponseEntity<String> productCreateResponse = 
//	               restTemplate
//	                .exchange(resourceUrl, 
//	                    HttpMethod.POST, 
//	                    request, 
//	                    String.class);
//	            
//	        System.out.println(productCreateResponse);
//	    }
	  
//	 //Using exchange() for PUT with an Empty Response Body
//	 public void updateProductWithExchange() {
//	        RestTemplate restTemplate = new RestTemplate();
//
//	        String resourceUrl
//	          = "http://localhost:8080/products";
//
//	        // Create the request body by wrapping
//	        // the object in HttpEntity 
//	        HttpEntity<Product> request = new HttpEntity<Product>(
//	            new Product("Television", "Samsung",1145.67,"S001"));
//
//	        // Send the PUT method as a method parameter
//	        restTemplate.exchange(
//	            resourceUrl, 
//	            HttpMethod.PUT, 
//	            request, 
//	            Void.class);
//	        
//	        
//	    }
	
//	//Using execute() for Downloading Large Files
//	public void getProductasStream() {
//        final Product fetchProductRequest = 
//        new Product("Television", "Samsung",1145.67,"S001");
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        String resourceUrl
//          = "http://localhost:8080/products";
//    
//        // Set HTTP headers in the request callback
//        RequestCallback requestCallback = request -> {
//            ObjectMapper mapper = new ObjectMapper();
//                mapper.writeValue(request.getBody(), 
//                        fetchProductRequest);
//
//                request.getHeaders()
//                 .setAccept(Arrays.asList(
//                         MediaType.APPLICATION_OCTET_STREAM, 
//                         MediaType.ALL));
//                };
//
//        // Processing the response. Here we are extracting the 
//        // response and copying the file to a folder in the server.
//        ResponseExtractor<Void> responseExtractor = response -> {
//                 Path path = Paths.get("some/path");
//                 Files.copy(response.getBody(), path);
//                 return null;
//             };
//
//        restTemplate.execute(resourceUrl, 
//            HttpMethod.GET, 
//            requestCallback, 
//            responseExtractor );    
//        
//    }
	
	//Invoking APIs with application/form Type Input
	 public void submitProductForm() {
	        RestTemplate restTemplate = new RestTemplate();

	        String resourceUrl
	          = "http://localhost:8080/products";
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        
	        // Set the form inputs in a multivaluemap
	        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
	        map.add("sku", "S34455");
	        map.add("name", "Television");
	        map.add("brand", "Samsung");
	        
	        // Create the request body by wrapping
	        // the MultiValueMap in HttpEntity  
	        HttpEntity<MultiValueMap<String, String>> request = 
	            new HttpEntity<>(map, headers);
	        
	        ResponseEntity<String> response = restTemplate.postForEntity(
	                  resourceUrl+"/form", request , String.class); 

	        System.out.println(response.getBody());
	    }
	

}
