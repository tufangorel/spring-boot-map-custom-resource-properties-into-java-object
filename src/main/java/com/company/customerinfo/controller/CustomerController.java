package com.company.customerinfo.controller;

import com.company.customerinfo.CustomerInfoApplication;
import com.company.customerinfo.config.AuthenticationProperties;
import com.company.customerinfo.config.Directory;
import com.company.customerinfo.model.Customer;
import com.company.customerinfo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerInfoApplication.class);

    @Autowired
    private AuthenticationProperties authenticationProperties;

    @Autowired
    private CustomerService customerService;


    @PostMapping("/customer/save")
    public ResponseEntity<?> save(@RequestBody Customer customer) {

        LOGGER.info(authenticationProperties.getUsername());
        LOGGER.info(authenticationProperties.getPassword());

        List<Boolean> enabledPorts = authenticationProperties.getEnabledports();
        for( Boolean port : enabledPorts )
            LOGGER.info(String.valueOf(port));

        Map<String,Boolean> additionalRights = authenticationProperties.getAdditionalRights();
        for (Map.Entry<String, Boolean> entry : additionalRights.entrySet()) {
            LOGGER.info(entry.getKey() + "/" + entry.getValue());
        }

        Directory directory = authenticationProperties.getDirectory();
        LOGGER.info(directory.getPath());
        LOGGER.info(String.valueOf(directory.isListing()));

        Customer response = customerService.save(customer);
        return new ResponseEntity<Customer>( response, HttpStatus.OK );
    }

}
