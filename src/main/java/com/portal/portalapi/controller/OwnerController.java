package com.portal.portalapi.controller;

import com.portal.portalapi.db.Owner;
import com.portal.portalapi.service.OwnerService.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public ResponseEntity createOwnerCar(@RequestBody Owner owner){
        ownerService.createOwner(owner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

