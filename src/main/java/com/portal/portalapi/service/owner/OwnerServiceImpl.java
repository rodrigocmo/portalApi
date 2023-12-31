package com.portal.portalapi.service.owner;

import com.portal.portalapi.client.CarClient;
import com.portal.portalapi.db.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private CarClient carClient;


    @Override
    public void createOwner(Owner owner) {
        carClient.ownerPostClient(owner);
    }
}
