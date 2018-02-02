package com.tfhk.account.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfhk.account.service.IAccontService;
import com.tfhk.jpa.model.CfgUser;

@Controller
@Scope(value = "prototype")
@RequestMapping("/account")
public class AccountAction {

	@Autowired
	private IAccontService accountService;

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public void getUser(@RequestParam(required = true, value = "account") String account, ModelMap modelMap) {
		CfgUser cfgUser = accountService.getUser(account);
		System.out.println(cfgUser.getAccount());
		System.out.println(cfgUser.getNameCh());
		System.out.println(cfgUser.getNameEn());
		System.out.println(cfgUser.getPassword());
		modelMap.addAttribute(cfgUser);
	}

}
