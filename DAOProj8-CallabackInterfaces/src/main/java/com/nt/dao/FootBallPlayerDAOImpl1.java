package com.nt.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.FootBallPlayerBO;

public class FootBallPlayerDAOImpl1 implements FootBallPlayerDAO {
	private  static final String  GET_PLAYER_BY_ID="SELECT PLAYERID,PLAYERNAME,ROLE,TEAMNAME,JERSYNO FROM FOOTBALLTEAM WHERE PLAYERID=?";
	private JdbcTemplate jt;

	public FootBallPlayerDAOImpl1(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public FootBallPlayerBO findPlayerById(int id) {
		FootBallPlayerBO bo=null;
		bo=jt.queryForObject(GET_PLAYER_BY_ID,
				 new RowMapper<FootBallPlayerBO>() {
					@Override
					public FootBallPlayerBO mapRow(ResultSet rs, int rowNum) throws SQLException {
					       FootBallPlayerBO bo=null;
					       bo=new FootBallPlayerBO();
					       bo.setPlayerId(rs.getInt(1));
					       bo.setPlayerName(rs.getString(2));
					       bo.setRole(rs.getString(3));
					       bo.setTeamName(rs.getString(4));
					       bo.setJersyNo(rs.getInt(5));
						return bo;
					}
			         }
				,id);
		return bo;
	}

	@Override
	public List<FootBallPlayerBO> findPlayersByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
