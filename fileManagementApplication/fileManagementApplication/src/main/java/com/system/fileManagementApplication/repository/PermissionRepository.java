package com.system.fileManagementApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.fileManagementApplication.entity.Permission;
import com.system.fileManagementApplication.enums.PermissionLevel;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END " +
           "FROM Permission p WHERE p.userEmail = :userEmail " +
           "AND p.itemId = :itemId AND p.permissionLevel >= :requiredPermissionLevel")
    boolean checkPermission(@Param("userEmail") String userEmail,
                            @Param("itemId") Long itemId,
                            @Param("requiredPermissionLevel") PermissionLevel requiredPermissionLevel);

}
