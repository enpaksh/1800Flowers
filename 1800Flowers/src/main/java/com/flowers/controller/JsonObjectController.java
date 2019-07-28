package com.flowers.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flowers.model.JsonObjectModel;
import com.flowers.service.JsonObjectService;

@RestController
public class JsonObjectController {

	@Autowired
	JsonObjectService objService;

	
	@RequestMapping("/count")
	public Map getAllRecords() {
		return Collections.singletonMap("count", objService.getCount());
	}
	
	@RequestMapping("/count/unique/userid")
	public Map countUniqueUserId() {
		return Collections.singletonMap("count", objService.uniqueUserIdTotalCount());
	}
	
	@RequestMapping("/unique/userid")
	public Map getUniqueUserId() {
		return Collections.singletonMap("userid", objService.getUniqueUserIdCount());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/object")
	public void addObjects(@RequestBody JsonObjectModel obj) {
		objService.addObject(obj);
	}
	
	@PatchMapping("/object/{id}")
	public void updateObjFields(@RequestBody JsonObjectModel obj, @PathVariable("id") Integer id) {
		objService.updateObject(obj, id);
	}
	
	@RequestMapping("/objects")
	public List<JsonObjectModel> getAllObjects() {
		return objService.getJsonObj();
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/object/list")
	public void loadMultipleJsonObj() {
		objService.parseList();
		return;
	}
}
