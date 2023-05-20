package com.system.fileManagementApplication.entity.dto;

import com.system.fileManagementApplication.enums.ItemType;

public class ItemDto {

	private Long id;
	private String name;
	private ItemType itemType;
	private PermissionGroupDto permissionGroupDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public PermissionGroupDto getPermissionGroupDto() {
		return permissionGroupDto;
	}

	public void setPermissionGroupDto(PermissionGroupDto permissionGroupDto) {
		this.permissionGroupDto = permissionGroupDto;
	}

}
