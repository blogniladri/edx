package org.openedusoft.school.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openedusoft.school.exception.RecordNotFoundException;
import org.openedusoft.school.vo.School;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RequestMapping("/api")
@RestController
@Api(value="School Management", description="Operations pertaining to schools")
public class SchoolController {

	Logger logger = LoggerFactory.getLogger(SchoolController.class);
	
	@ApiOperation(value = "View a list of available schools", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping(value = "/schools", produces = {"application/JSON"})
    public List<School> searchSchool(
    		@ApiParam(value = "tag1 field of school", required = false)
    		@RequestParam(value = "tag1", required=false) final String tag1,
    		@RequestParam(value = "tag2", required=false) final String tag2,
    		@RequestParam(value = "tag3", required=false) final String tag3,
    		@RequestParam(value = "tag4", required=false) final String tag4,
    		@RequestParam(value = "tag5", required=false) final String tag5,
    		@RequestParam(value = "sort", required=false) final String sort,
    		@RequestParam(value = "offset", required=false, defaultValue = "0") final int offset,
    		@RequestParam(value = "limit", required=false, defaultValue = "100") final int limit,
    		@RequestParam(value = "fields", required=false) final String fields) {
        
    	logger.debug("INSIDE searchSchool");
    	logger.debug("tag1:"+tag1);
    	logger.debug("tag1:"+tag2);
    	logger.debug("tag1:"+tag3);
    	logger.debug("tag1:"+tag4);
    	logger.debug("tag1:"+tag5);
    	logger.debug("sort:"+sort);
    	logger.debug("offset:"+offset);
    	logger.debug("limit:"+limit);
    	logger.debug("fields:"+fields);    	
    	
		List<School> list = new ArrayList();
		return list;
    }
	
	
	@GetMapping(value = "/schools/export", produces = {"application/JSON"})
    public List<School> exportSchool(
    		@RequestParam(value = "tag1", required=false) final String tag1,
    		@RequestParam(value = "tag2", required=false) final String tag2,
    		@RequestParam(value = "tag3", required=false) final String tag3,
    		@RequestParam(value = "tag4", required=false) final String tag4,
    		@RequestParam(value = "tag5", required=false) final String tag5,
    		@RequestParam(value = "sort", required=false) final String sort,
    		@RequestParam(value = "fields", required=false) final String fields,
    		@RequestParam(value = "format", required=false, defaultValue = "excel") final String format) {
        
    	logger.debug("INSIDE exportSchool");
    	logger.debug("tag1:"+tag1);
    	logger.debug("tag1:"+tag2);
    	logger.debug("tag1:"+tag3);
    	logger.debug("tag1:"+tag4);
    	logger.debug("tag1:"+tag5);
    	logger.debug("sort:"+sort);
    	logger.debug("format:"+format);
    	logger.debug("fields:"+fields);    	
    	
    	//need to use a data formatter
    	
		List<School> list = new ArrayList();
		return list;
    }
	
    @GetMapping(value = "/schools/{schoolId}", produces = {"application/JSON"})
    public School getSchoolDetail(@PathVariable(value = "schoolId") long schoolId) throws RecordNotFoundException {
    	logger.debug("INSIDE getSchoolDetail");
    	logger.debug("productId:"+schoolId);
    	
    	if(true) {
    		throw new RecordNotFoundException("Given schoolId "+schoolId+" not found or you might not have access to this record.");
    	}
        return new School();
    }

    @PostMapping(value = "/schools")
    public void createSchool(@RequestBody School school){
    	logger.debug("inside createProduct" );
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			logger.debug("school:"+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(school));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }

    @PutMapping(value = "/schools", consumes = {"application/JSON"})
    public void updateSchool(@PathVariable(value = "schoolId") long productId, @RequestBody School school) throws RecordNotFoundException {
    	logger.debug("inside updateSchool" );
    	
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			logger.debug("product:"+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(school));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    @DeleteMapping(value = "/schools/{schoolId}")
    public void removeSchool(@PathVariable(value = "schoolId") long schoolId) throws RecordNotFoundException {
        //remove all students as well
    	
    }
    
    @DeleteMapping(value = "/schools/{schoolId}/purge")
    public void purgeSchool(@PathVariable(value = "schoolId") long schoolId) throws RecordNotFoundException {
        //purge all students as well
    }
    
}