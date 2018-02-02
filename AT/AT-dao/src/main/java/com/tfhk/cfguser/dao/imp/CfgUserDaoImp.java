package com.tfhk.cfguser.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tfhk.cfguser.dao.ICfgUserDao;
import com.tfhk.jpa.model.CfgUser;

@Repository
public class CfgUserDaoImp implements ICfgUserDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	private final String GET_USER_INFO = "from CfgUser where account=:account";
	
	public CfgUser getUserInfo(String account) {
		System.out.println(account);
		Query query = entityManager.createQuery(GET_USER_INFO);
		query.setParameter("account", account);
		List<CfgUser> result = (List<CfgUser>)query.getResultList();
		return result.get(0);
	}

}
