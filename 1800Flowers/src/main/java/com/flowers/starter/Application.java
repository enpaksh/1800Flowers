package com.flowers.starter;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.flowers.controller.JsonObjectController;
import com.flowers.model.JsonObjectModel;
import com.flowers.service.JsonObjectService;

@SpringBootApplication
@ComponentScan(basePackages = { "com.flowers.controller, com.flowers.model, com.flowers.service"} )
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		
	}

}
