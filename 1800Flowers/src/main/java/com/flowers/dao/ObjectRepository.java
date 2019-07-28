package com.flowers.dao;

public interface ObjectRepository {
	
	int getCount();
	
	Object[] getUniqueUserIdCount();
	
	String updateObject();
}
