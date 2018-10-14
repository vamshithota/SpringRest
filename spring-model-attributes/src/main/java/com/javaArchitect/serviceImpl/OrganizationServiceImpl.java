package com.javaArchitect.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaArchitect.daos.OrganizationDAO;
import com.javaArchitect.models.Organization;
import com.javaArchitect.services.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationDAO orgdao;
	
	@Override
	@Transactional
	public List<Organization> orgslist() {
		List<Organization> orgslist = orgdao.getorgslist();
		return orgslist;
	}

}
