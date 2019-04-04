package org.openedusoft.school.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "All details about the Employee. ")
public class School {
	
	@ApiModelProperty(notes = "generated school ID")
	long id;
	@ApiModelProperty(notes = "School Name")
	String name;
	@ApiModelProperty(notes = "School Category")
	String category;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
