package com.nt.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicComboPopup;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.FootBallPlayerBO;

public class FootBallPlayerDAOImpl3 implements FootBallPlayerDAO {
	private  static final String  GET_PLAYER_BY_ID="SELECT PLAYERID,PLAYERNAME,ROLE,TEAMNAME,JERSYNO FROM FOOTBALLTEAM WHERE PLAYERID=?";
	private  static final String  GET_PLAYERS_BY_ROLE="SELECT PLAYERID,PLAYERNAME,ROLE,TEAMNAME,JERSYNO FROM FOOTBALLTEAM WHERE ROLE=?";
	private JdbcTemplate jt;

	public FootBallPlayerDAOImpl3(JdbcTemplate jt) {
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
		listBO=jt.query(GET_PLAYERS_BY_ROLE,
				rs->{
					List<FootBallPlayerBO> list=new ArrayList();
					while(rs.next()) {
						FootBallPlayerBO bo=new FootBallPlayerBO();
						bo.setPlayerId(rs.getInt(1));
						bo.setPlayerName(rs.getString(2));
						bo.setRole(rs.getString(3));
						bo.setTeamName(rs.getString(4));
						bo.setJersyNo(rs.getInt(5));
						list.add(bo);
					}
			 return list;
		},
		role);		
		return listBO;
	}
	
	
	

}
