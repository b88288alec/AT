package com.tfhk.cfguser.dao;

import com.tfhk.jpa.model.CfgUser;

public interface ICfgUserDao {
	public CfgUser getUserInfo(String account);
}
