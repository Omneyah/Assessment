package com.system.fileManagementApplication.entity.dto;

import com.system.fileManagementApplication.enums.PermissionLevel;

public class PermissionGroupDto {

	private String userEmail;
	private PermissionLevel permissionLevel;
	private Long group_id;
	private String name;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public PermissionLevel getPermissionLevel() {
		return permissionLevel;
	}

	public void setPermissionLevel(PermissionLevel permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public Long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
