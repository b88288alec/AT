package com.tfhk.cfguser.dao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tfhk.cfguser.dao.ICfgUserDao;
import com.tfhk.cfguser.model.CfgUser;

@Repository
public class CfgUserDaoImp implements ICfgUserDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	private final String GET_USER_INFO = "from CfgUser where account=:account";
	
	public CfgUser getUserInfo(String account) {
		CfgUser query = new CfgUser();
		query.setAccount(account);
		System.out.println(account);
		List<CfgUser> result =  (List<CfgUser>)hibernateTemplate.findByNamedParam(GET_USER_INFO, "account", account);
		return result.get(0);
	}

}
