package com.nt.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.FootBallPlayerBO;

public class FootBallPlayerDAOImpl2 implements FootBallPlayerDAO {
	private  static final String  GET_PLAYER_BY_ID="SELECT PLAYERID,PLAYERNAME,ROLE,TEAMNAME,JERSYNO FROM FOOTBALLTEAM WHERE PLAYERID=?";
	private JdbcTemplate jt;

	public FootBallPlayerDAOImpl2(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public FootBallPlayerBO findPlayerById(int id) {
		FootBallPlayerBO bo=null;
		bo=jt.queryForObject(GET_PLAYER_BY_ID,
							(ResultSet rs, int rowNum)->{
					       FootBallPlayerBO fbo=null;
					       fbo=new FootBallPlayerBO();
					       fbo.setPlayerId(rs.getInt(1));
					       fbo.setPlayerName(rs.getString(2));
					       fbo.setRole(rs.getString(3));
					       fbo.setTeamName(rs.getString(4));
					       fbo.setJersyNo(rs.getInt(5));
						  return fbo;
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
