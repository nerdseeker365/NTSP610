package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.entity.UserHLO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	private static final String  HQL_AUTH_QUERY="SELECT COUNT(*) FROM UserHLO WHERE user=:un AND pwd=:pass";
	@Autowired
	private  HibernateTemplate ht;

	@Override
	public long authenticate(UserHLO bo) {
		long  count=0;
		List<Long> list=null;
		list=(List<Long>) ht.findByNamedParam(HQL_AUTH_QUERY,new String[] {"un","pass"},new Object[] {bo.getUser(),bo.getPwd()});
		count=list.get(0);
		return count;
	}

}
