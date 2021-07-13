package com.zadatak15.DatabaseLayer;
import DataLayer.UserType;

public interface ILoginRepository {
	
	public UserType getUsertype(String username, String password);
	
}
