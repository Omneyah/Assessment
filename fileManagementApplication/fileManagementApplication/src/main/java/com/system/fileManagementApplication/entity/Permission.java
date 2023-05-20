package com.system.fileManagementApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissions")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "user_email")
	private String userEmail;

    @Enumerated(EnumType.STRING)
	@Column(name = "permission_level")
	private String permissionLevel;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private PermissionGroup group;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
    private Item item;
    
	public Permission(String userEmail, String permissionLevel, PermissionGroup group, Item item) {
		this.userEmail = userEmail;
		this.permissionLevel = permissionLevel;
		this.group = group;
		this.item = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPermissionLevel() {
		return permissionLevel;
	}

	public void setPermissionLevel(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public PermissionGroup getGroup() {
		return group;
	}

	public void setGroup(PermissionGroup group) {
		this.group = group;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	

}