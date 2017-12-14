package com.service;

import java.util.Set;

import com.bean.IBean;
import com.bean.compte.Admin;
import com.bean.compte.User;

public class ServiceAuthentification {
	
	public static int validateUser(String username, String password, Set<IBean> listeUser){
		for (IBean user : listeUser) {
			if (((User) user).getCredentials().getUsername().equalsIgnoreCase(username) && ((User) user).getCredentials().getPwd().equals(password)) {
				return user.getId();
			}
		}
		return -1;
	}
	
	public static int validateAdmin(String username, String password, Set<IBean> listeAdmin){
		for (IBean admin : listeAdmin) {
			if (((Admin) admin).getCredentials().getUsername().equalsIgnoreCase(username) && ((Admin) admin).getCredentials().getPwd().equals(password)) {
				return admin.getId();
			}
		}
		return -1;
	}
	
	public static boolean validerMotDePasse(String pwd1, String pwd2){
		return (pwd1.equals(pwd2));
	}
	

	
}
