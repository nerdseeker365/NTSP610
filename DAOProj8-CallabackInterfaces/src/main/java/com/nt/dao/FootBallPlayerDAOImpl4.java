package com.nt.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicComboPopup;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.nt.bo.FootBallPlayerBO;

public class FootBallPlayerDAOImpl4 implements FootBallPlayerDAO {
	private  static final String  GET_PLAYER_BY_ID="SELECT PLAYERID,PLAYERNAME,ROLE,TEAMNAME,JERSYNO FROM FOOTBALLTEAM WHERE PLAYERID=?";
	private  static final String  GET_PLAYERS_BY_ROLE="SELECT PLAYERID,PLAYERNAME,ROLE,TEAMNAME,JERSYNO FROM FOOTBALLTEAM WHERE ROLE=?";
	private JdbcTemplate jt;

	public FootBallPlayerDAOImpl4(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public FootBallPlayerBO findPlayerById(int id) {
		FootBallPlayerBO bo=null;
		BeanPropertyRowMapper bprm=null;
		bprm=new BeanPropertyRowMapper(FootBallPlayerBO.class);
		
		bo=(FootBallPlayerBO) jt.queryForObject(GET_PLAYER_BY_ID,bprm,id);
		return bo;
	}

	@Override
	public List<FootBallPlayerBO> findPlayersByRole(String role) {
		List<FootBallPlayerBO> listBO=null;
		RowMapperResultSetExtractor<FootBallPlayerBO> rmrse=null;
		BeanPropertyRowMapper<FootBallPlayerBO> bprm=null;
		bprm=new BeanPropertyRowMapper(FootBallPlayerBO.class);
		rmrse=new RowMapperResultSetExtractor(bprm);
		listBO=jt.query(GET_PLAYERS_BY_ROLE, rmrse,role);
		return listBO;
	}
	
	
	

}
