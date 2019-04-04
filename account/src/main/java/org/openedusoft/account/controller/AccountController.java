package org.openedusoft.account.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openedusoft.account.vo.Account;
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
public class AccountController {

	Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping(value = "/accounts/{accountId}", produces = {"application/JSON"})
    public Account getAccountDetail(@PathVariable(value = "accountId") long accountId) {
    	logger.debug("INSIDE getSchoolDetail");
    	logger.debug("productId:"+accountId);
        return new Account();
    }

    @PostMapping(value = "/accounts")
    public void createAccount(@RequestBody Account account){
    	logger.debug("inside createAccount" );
    	
    	//create entry in auth for the account user
    	//create organization 
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			logger.debug("school:"+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(account));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }

    @PutMapping(value = "/accounts/{accountId}/billing", consumes = {"application/JSON"})
    public void updateBillingInfo(@PathVariable(value = "accountId") long accountId, @RequestBody Account account) {
    	logger.debug("inside updateSchoolBillingInfo" );
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			logger.debug("accountId:"+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(accountId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    
    @PutMapping(value = "/accounts/{accountId}/contact", consumes = {"application/JSON"})
    public void updateContactInfo(@PathVariable(value = "accountId") long accountId, @RequestBody Account account) {
    	logger.debug("inside updateSchoolBillingInfo" );
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			logger.debug("product:"+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(accountId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    
    @DeleteMapping(value = "/accounts/{accountId}")
    public void removeAccount(@PathVariable(value = "accountId") long schoolId) {
        //remove all students as well
    	
    }
    
    @DeleteMapping(value = "/accounts/{accountId}/purge")
    public void purgeSchool(@PathVariable(value = "accountId") long schoolId) {
        //purge all students as well
    }
    
}