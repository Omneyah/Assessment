package com.system.fileManagementApplication.service;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.fileManagementApplication.entity.Item;
import com.system.fileManagementApplication.entity.Permission;
import com.system.fileManagementApplication.entity.PermissionGroup;
import com.system.fileManagementApplication.entity.dto.ItemDto;
import com.system.fileManagementApplication.enums.ItemType;
import com.system.fileManagementApplication.repository.ItemRepository;
import com.system.fileManagementApplication.repository.PermissionGroupRepository;
import com.system.fileManagementApplication.repository.PermissionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private PermissionGroupRepository permissionGroupRepository;

	public Item createItem(Long spaceId, Long folderId, ItemDto itemDto) throws AccessDeniedException {
		boolean hasPermission = permissionRepository.checkPermission(itemDto.getPermissionGroupDto().getUserEmail(),
				spaceId, itemDto.getPermissionGroupDto().getPermissionLevel());
		if (!hasPermission) {
			throw new AccessDeniedException("Insufficient permissions to create a folder.");
		}

		switch (itemDto.getItemType()) {
		case SPACE:
			return createSpace(itemDto);

		case FOLDER:
			return createFolder(spaceId, itemDto);

		case FILE:
			return createFile(spaceId, folderId, itemDto);

		}

		return null;
	}

	private Item createSpace(ItemDto itemDto) {
		PermissionGroup permissionGroup = new PermissionGroup(itemDto.getPermissionGroupDto().getName());
		permissionGroupRepository.save(permissionGroup);
		Item item = new Item(ItemType.SPACE.toString(), itemDto.getName(), permissionGroup);
		itemRepository.save(item);
		Permission permission = new Permission(itemDto.getPermissionGroupDto().getUserEmail(), itemDto.getPermissionGroupDto().getPermissionLevel().toString(), permissionGroup, item);
		permissionRepository.save(permission);
		return item;
	}

	private Item createFolder(Long spaceId, ItemDto itemDto) {
		//:TODO
		return null;
	}

	private Item createFile(Long spaceId, Long folderId, ItemDto itemDto) {
		//:TODO
		return null;
	}

}