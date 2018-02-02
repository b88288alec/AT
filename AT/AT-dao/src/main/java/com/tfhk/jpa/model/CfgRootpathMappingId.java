package com.tfhk.jpa.model;
// Generated 2018/2/2 �U�� 02:52:19 by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CfgRootpathMappingId generated by hbm2java
 */
@Embeddable
public class CfgRootpathMappingId implements java.io.Serializable {

	private String rootPath;
	private String account;

	public CfgRootpathMappingId() {
	}

	public CfgRootpathMappingId(String rootPath, String account) {
		this.rootPath = rootPath;
		this.account = account;
	}

	@Column(name = "ROOT_PATH", nullable = false, length = 50)
	public String getRootPath() {
		return this.rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	@Column(name = "account", nullable = false, length = 30)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CfgRootpathMappingId))
			return false;
		CfgRootpathMappingId castOther = (CfgRootpathMappingId) other;

		return ((this.getRootPath() == castOther.getRootPath()) || (this.getRootPath() != null
				&& castOther.getRootPath() != null && this.getRootPath().equals(castOther.getRootPath())))
				&& ((this.getAccount() == castOther.getAccount()) || (this.getAccount() != null
						&& castOther.getAccount() != null && this.getAccount().equals(castOther.getAccount())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRootPath() == null ? 0 : this.getRootPath().hashCode());
		result = 37 * result + (getAccount() == null ? 0 : this.getAccount().hashCode());
		return result;
	}

}