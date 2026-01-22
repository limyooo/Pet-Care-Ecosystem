package com.petcare.boot;

import Business.ConfigureABusiness;
import Business.Petsystem;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/api/status")
    public Map<String, Object> status() {
        Petsystem system = ConfigureABusiness.configure();
        return Map.of(
                "networks", system.getNetworkList().size(),
                "employees", system.getEmployeeDirectory().getEmployeeList().size(),
                "petOwners", system.getPetOwnerDirectory().getOwnerList().size()
        );
    }
}
