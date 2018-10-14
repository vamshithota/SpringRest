package com.javaArchitect.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaArchitect.models.Organization;
import com.javaArchitect.services.OrganizationService;

@Controller
@RequestMapping("/orgcontroller")
public class OrganizationController {
	private static final Logger logger = Logger.getLogger(OrganizationController.class);
    @Autowired
    OrganizationService orgservice;    
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public String orgsList(Model model){
	List<Organization> orgslist = orgservice.orgslist();
	model.addAttribute("orgList",orgslist);
	return "listOrganizations";
	}
	@RequestMapping("/hi")
	public String sayHi() {
		return "hi";
	}
	
//z	public String 
}
