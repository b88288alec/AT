package com.tfhk.jpa.model;
// Generated 2018/2/2 �U�� 02:52:19 by Hibernate Tools 5.2.8.Final

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CfgFolder generated by hbm2java
 */
@Entity
@Table(name = "cfg_folder", schema = "TFHK")
public class CfgFolder implements java.io.Serializable {

	private CfgFolderId id;
	private String folderName;
	private String rootPath;
	private Date updateDate;
	private Date createDate;
	private String fileType;

	public CfgFolder() {
	}

	public CfgFolder(CfgFolderId id, String folderName) {
		this.id = id;
		this.folderName = folderName;
	}

	public CfgFolder(CfgFolderId id, String folderName, String rootPath, Date updateDate, Date createDate,
			String fileType) {
		this.id = id;
		this.folderName = folderName;
		this.rootPath = rootPath;
		this.updateDate = updateDate;
		this.createDate = createDate;
		this.fileType = fileType;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "folderPath", column = @Column(name = "FOLDER_PATH", nullable = false, length = 50)),
			@AttributeOverride(name = "account", column = @Column(name = "account", nullable = false, length = 30)) })
	public CfgFolderId getId() {
		return this.id;
	}

	public void setId(CfgFolderId id) {
		this.id = id;
	}

	@Column(name = "FOLDER_NAME", nullable = false, length = 50)
	public String getFolderName() {
		return this.folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	@Column(name = "ROOT_PATH", length = 50)
	public String getRootPath() {
		return this.rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "update_date", length = 10)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date", length = 10)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "FILE_TYPE", length = 50)
	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}
