package com.service;

import java.util.Set;

import com.bean.IBean;

// TODO: Auto-generated Javadoc
/**
 * The Class Service.
 */
public class Service {

	
	
	/**
	 * Adds the bean.
	 *
	 * @param bean the bean
	 * @param listeBean the liste bean
	 * @return true, if successful
	 */
	public static boolean addBean(IBean bean, Set<IBean> listeBean) {
		return listeBean.add(bean);
	}
	
	/**
	 * Delete bean.
	 *
	 * @param bean the bean
	 * @param listeBean the liste bean
	 * @return true, if successful
	 */
	public static boolean deleteBean(IBean bean, Set<IBean> listeBean) {
		return listeBean.remove(bean);
	}
	
	/**
	 * Gets the byid.
	 *
	 * @param id the id
	 * @param listeBean the liste bean
	 * @return the byid
	 */
	public static IBean getByid(int id, Set<IBean> listeBean) {
		for (IBean iBean : listeBean) {
			if (iBean.getId() == id) {
				return iBean;
			}
		}
		return null;
	}
	
	/**
	 * Update bean.
	 *
	 * @param bean the bean
	 * @param listeBean the liste bean
	 * @return true, if successful
	 */
	public static boolean updateBean(IBean bean, Set<IBean> listeBean) {
		for (IBean iBean : listeBean) {
			if (iBean.getId() == bean.getId()) {
				listeBean.remove(iBean);
				return listeBean.add(bean);
			}
		}
		return false;
	}

}
