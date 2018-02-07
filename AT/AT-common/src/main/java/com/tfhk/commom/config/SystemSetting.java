package com.tfhk.commom.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemSetting {
	
	public static String SYS_ROOT_PATH;

	@Value("${system.root.path}")
	public void setSYS_ROOT_PATH(String sYS_ROOT_PATH) {
		SYS_ROOT_PATH = sYS_ROOT_PATH;
	}

}
