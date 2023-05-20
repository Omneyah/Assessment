package com.system.fileManagementApplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "permission_group")
public class PermissionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "group_name")
    private String groupName;
   
	public PermissionGroup(String groupName) {
		this.groupName = groupName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

    
}