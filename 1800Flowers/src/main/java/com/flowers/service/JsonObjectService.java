package com.flowers.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flowers.model.JsonObjectModel;

@Service
public class JsonObjectService {
	
	private List<JsonObjectModel> jsonObj = new ArrayList<>();
	
	@Value("${service.url}")
	private String url;

	public List<JsonObjectModel> getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(List<JsonObjectModel> jsonObj) {
		this.jsonObj = jsonObj;
	}

	public void clearList() {
		this.jsonObj.clear();
	}

	
	public void addObject(JsonObjectModel obj) {
		
		jsonObj.add(obj);
	}
	
	public int getCount() {
		return jsonObj.size();
	}
	
	public void parseList() {
		
		RestTemplate restTemplate = new RestTemplate();
		String resp = restTemplate.getForObject(url, String.class);

		JsonParser springParser = JsonParserFactory.getJsonParser();

		List<Object> list = springParser.parseList(resp);

		for(Object o : list) {
			if(o instanceof Map) {
				Map<String,Object> map = (Map<String,Object>) o;
				
				int userId = (int) map.get("userId");
				int id = (int) map.get("id");
				String title = (String) map.get("title");
				String body = (String) map.get("body");
				
				JsonObjectModel obj = new JsonObjectModel(userId, id, title, body);
				this.addObject(obj);

			}
		}
	}

	public int uniqueUserIdTotalCount() {
		HashSet<Integer> count = new HashSet<Integer>();
		for(JsonObjectModel obj: jsonObj) {
			count.add(obj.getUserId());
		}
		
		return count.size();
	}

	public Object[] getUniqueUserIdCount() {
		HashSet<Integer> count = new HashSet<Integer>();
		for(JsonObjectModel obj: jsonObj) {
			count.add(obj.getUserId());
		}
		return count.toArray();
	}

	public void updateObject(JsonObjectModel obj, Integer id) {
		JsonObjectModel model = jsonObj.get(id-1);
		model.setUserId(obj.getUserId());
		model.setId(obj.getId());
		model.setTitle(obj.getTitle());
		model.setBody(obj.getBody());
		return;
	}
	 
}
