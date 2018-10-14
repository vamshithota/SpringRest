package com.javaArchitect.DAOImpls;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
/*import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
*/
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaArchitect.daos.OrganizationDAO;
import com.javaArchitect.models.Organization;

@Repository
public class OrganizationDaoImpl implements OrganizationDAO {

//private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
/*	@Autowired
	public void setDataSource(DataSource dataSource) {
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
*/	
	@Autowired
	private SessionFactory sesionfactory;
	
	
	
	
	@Override
	public List<Organization> getorgslist() {
//Session session = sesionfactory.getCurrentSession();
List<Organization> orgslist = sesionfactory.getCurrentSession().createCriteria(Organization.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
return orgslist;
	}

	
	
	
}
