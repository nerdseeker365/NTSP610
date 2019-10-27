package com.nt.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicComboPopup;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.nt.bo.FootBallPlayerBO;

public class FootBallPlayerDAOImpl6 implements FootBallPlayerDAO {
	private  static final String  GET_PLAYER_BY_ID="SELECT PLAYERID,PLAYERNAME,ROLE,TEAMNAME,JERSYNO FROM FOOTBALLTEAM WHERE PLAYERID=?";
	private  static final String  GET_PLAYERS_BY_ROLE="SELECT PLAYERID,PLAYERNAME,ROLE,TEAMNAME,JERSYNO FROM FOOTBALLTEAM WHERE ROLE=?";
	private JdbcTemplate jt;

	public FootBallPlayerDAOImpl6(JdbcTemplate jt) {
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
		List<FootBallPlayerBO> listBO=new ArrayList();
		 jt.query(GET_PLAYERS_BY_ROLE, new FBPlayerRowCallbackHandler(listBO), role);
      return listBO;		
		
	}
	
	
	private static  class FBPlayerRowCallbackHandler implements RowCallbackHandler{
          List<FootBallPlayerBO> listBO=null;
		public FBPlayerRowCallbackHandler(List<FootBallPlayerBO> listBO) {
			this.listBO=listBO;
		}
		
		@Override
		public void processRow(ResultSet rs) throws SQLException {
			System.out.println("FootBallPlayerDAOImpl5.FBPlayerRowCallbackHandler.processRow(-)");
			 FootBallPlayerBO bo=null;
			 bo=new FootBallPlayerBO();
			 bo.setPlayerId(rs.getInt(1));
			 bo.setPlayerName(rs.getString(2));
			 bo.setRole(rs.getString(3));
			 bo.setTeamName(rs.getString(4));
			 bo.setJersyNo(rs.getInt(5));
			 listBO.add(bo);
		}
		
	}
	
	
		
	

}
