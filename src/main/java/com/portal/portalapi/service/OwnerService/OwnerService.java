package com.portal.portalapi.service.OwnerService;

import com.portal.portalapi.db.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {

    void createOwner(Owner owner);

}
