package com.system.fileManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.fileManagementApplication.entity.PermissionGroup;

public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Long> {
}