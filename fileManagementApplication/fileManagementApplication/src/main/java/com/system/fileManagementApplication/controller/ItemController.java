package com.system.fileManagementApplication.controller;


import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.fileManagementApplication.entity.Item;
import com.system.fileManagementApplication.entity.dto.ItemDto;
import com.system.fileManagementApplication.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    
    @PostMapping("/spaces")
    public ResponseEntity<Item> createSpace() throws AccessDeniedException {
    	ItemDto itemDto = new ItemDto();
    	itemDto.setName("stc-assessments");
        Item space = itemService.createItem(null, null, itemDto);
        return new ResponseEntity<>(space, HttpStatus.CREATED);
    }

    @PostMapping("/spaces/{spaceId}/folders")
    public ResponseEntity<Item> createFolder(@PathVariable Long spaceId, @RequestBody ItemDto folderDto) throws AccessDeniedException {
        Item folder = itemService.createItem(spaceId, null, folderDto);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

    @PostMapping("/spaces/{spaceId}/folders/{folderId}/files")
    public ResponseEntity<Item> createFile(@PathVariable Long spaceId, @PathVariable Long folderId, @RequestBody ItemDto fileDto) throws AccessDeniedException {
        Item file = itemService.createItem(spaceId, folderId, fileDto);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}