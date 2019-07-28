package com.flowers.mockito.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flowers.dao.ObjectRepository;
import com.flowers.model.JsonObjectModel;
import com.flowers.service.JsonObjectService;



@RunWith(SpringRunner.class)

@SpringBootTest(classes= {JsonObjectModel.class,JsonObjectService.class})
public class ApplicationTest {

	@Autowired
	JsonObjectService objService;
	
	@MockBean
	ObjectRepository mockRepository;
	
	@Test
	public void getCountTest() {
		JsonObjectModel obj = new JsonObjectModel(1,1,"Sample Title 1","Sample Description 1");
		objService.addObject(obj);
		when(mockRepository.getCount()).thenReturn(objService.getCount());
		assertEquals(1,mockRepository.getCount());
		objService.clearList();
	}
	
	@Test
	public void getUniqueUserIdCountTest() {
		JsonObjectModel obj = new JsonObjectModel(1,1,"Sample Title 1","Sample Description 1");
		JsonObjectModel obj1 = new JsonObjectModel(2,2,"Sample Title 2","Sample Description 2");
		JsonObjectModel obj2 = new JsonObjectModel(1,3,"Sample Title 3","Sample Description 3");
		JsonObjectModel obj3 = new JsonObjectModel(3,4,"Sample Title 4","Sample Description 4");
		objService.addObject(obj);
		objService.addObject(obj1);
		objService.addObject(obj2);
		objService.addObject(obj3);
		
		
		when(mockRepository.getUniqueUserIdCount()).thenReturn(objService.getUniqueUserIdCount());
		Object[] actual = new Object[] {1,2,3};
		assertArrayEquals(actual,mockRepository.getUniqueUserIdCount());
		objService.clearList();
	
	}

	@Test
	public void updateObject() {
		JsonObjectModel obj = new JsonObjectModel(1,1,"Sample Title 1","Sample Description 1");
		objService.addObject(obj);
		
		obj.setTitle("Sample Title 2");
		objService.updateObject(obj, 1);
		
		
		
		when(mockRepository.updateObject()).thenReturn(objService.getJsonObj().get(0).getTitle());
		
		assertEquals("Sample Title 2",mockRepository.updateObject());
		objService.clearList();
	
	}
}
