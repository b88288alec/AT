package com.tfhk.account.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfhk.account.service.IAccontService;
import com.tfhk.cfguser.dao.ICfgUserDao;
import com.tfhk.cfguser.model.CfgUser;

@Service
public class AccountServiceImp implements IAccontService {

	@Autowired
	ICfgUserDao cfgUserDao;
	
	@Override
	public CfgUser getUser(String account) {
		return cfgUserDao.getUserInfo(account);
	}

}
