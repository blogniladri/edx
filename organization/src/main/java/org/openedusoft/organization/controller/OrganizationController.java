package org.openedusoft.organization.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openedusoft.organization.vo.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class OrganizationController {

	Logger logger = LoggerFactory.getLogger(OrganizationController.class);
	
	@GetMapping(value = "/organizations/{orgId}", produces = {"application/JSON"})
    public Organization getOrganizationDetail(@PathVariable(value = "orgId") long orgId) {
    	logger.debug("INSIDE getOrganizationDetail");
    	logger.debug("orgId:"+orgId);
        return new Organization();
    }

    @PostMapping(value = "/organizations")
    public void createOrganization(@RequestBody Organization org){
    	logger.debug("inside createOrganization" );
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			logger.debug("school:"+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(org));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }

    @PutMapping(value = "/organizations/{orgId}", consumes = {"application/JSON"})
    public void renameOrganization(@PathVariable(value = "orgId") long orgId, @RequestBody Organization org) {
    	logger.debug("inside renameOrganization" );
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			logger.debug("accountId:"+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orgId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    @PostMapping(value = "/organizations/{orgId}/users", consumes = {"application/JSON"})
    public void addUserToOrganization(@PathVariable(value = "orgId") long orgId, @RequestBody Organization org) {
    	logger.debug("inside renameOrganization" );
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			logger.debug("accountId:"+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orgId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    @DeleteMapping(value = "/organizations/{orgId}/users/{userId}")
    public void removeOrganizationUser(@PathVariable(value = "orgId") long orgId,@PathVariable(value = "userId") long userId) {
        //remove all students as well
    }
    
    @DeleteMapping(value = "/organizations/{orgId}")
    public void removeOrganization(@PathVariable(value = "orgId") long orgId) {
        //remove all students as well
    	
    }
    
    @DeleteMapping(value = "/organizations/{orgId}/purge")
    public void purgeOrganization(@PathVariable(value = "orgId") long orgId) {
        //purge all students as well
    }
    
}