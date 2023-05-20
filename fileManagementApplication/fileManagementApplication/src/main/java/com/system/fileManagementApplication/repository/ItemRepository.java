package com.system.fileManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.fileManagementApplication.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}