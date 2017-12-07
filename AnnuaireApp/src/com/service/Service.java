package com.service;

import java.util.Set;

import com.bean.IBean;

public class Service {

	public static boolean addBean(IBean bean, Set<IBean> listeBean) {
		return listeBean.add(bean);
	}
	
	public static boolean deleteBean(IBean bean, Set<IBean> listeBean) {
		return listeBean.remove(bean);
	}
	
	public static IBean getByid() {
		return null;
	}
	
	// ??????????????????????????
	public static void updateBean() {
		
	}

}
