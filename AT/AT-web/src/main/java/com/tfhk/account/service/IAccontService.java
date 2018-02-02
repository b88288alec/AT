package com.tfhk.account.service;

import com.tfhk.jpa.model.CfgUser;

public interface IAccontService {
	public CfgUser getUser(String account);
}
