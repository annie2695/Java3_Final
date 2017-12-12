package com.service;

import java.util.Set;

import com.bean.IBean;
import com.bean.compte.Admin;
import com.bean.compte.User;

public class ServiceAuthentification {
	
	public static int validateUser(String username, String password, Set<IBean> listeUser){
		for (IBean user : listeUser) {
			if (((User) user).getCredentials().getUsername().equalsIgnoreCase("u"+username) && ((User) user).getCredentials().getPwd().equals(password)) {
				return user.getId();
			}
		}
		return -1;
	}
	
	public static int validateAdmin(String username, String password, Set<IBean> listeUser){
		for (IBean admin : listeUser) {
			if (((Admin) admin).getCredentials().getUsername().equalsIgnoreCase("a"+username) && ((Admin) admin).getCredentials().getPwd().equals(password)) {
				return admin.getId();
			}
		}
		return -1;
	}
	

	
}
