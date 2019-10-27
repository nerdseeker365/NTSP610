package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.PassengerBO;

@Repository("agentDAO")
public class TravelAgentDAOImpl implements TravelAgentDAO {
	private  static  final  String  INSERT_PASSENGER="INSERT INTO TICKET_RESERVATION VALUES(TICKETID_SEQ.NEXTVAL,?,?,SEATNO_SEQ.NEXTVAL,?,?)";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int[] insertBatch(List<PassengerBO> listBO) {
		int result[]=null;
		result=jt.batchUpdate(INSERT_PASSENGER,
				  new BatchPreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps, int index) throws SQLException {
						System.out.println(
								"TravelAgentDAOImpl.insertBatch(...).new BatchPreparedStatementSetter() {...}.setValues()");
						 ps.setString(1, listBO.get(index).getPsngrName());
						 ps.setString(2,listBO.get(index).getGender());
						 ps.setString(3,listBO.get(index).getBoardingPlace());
						 ps.setString(4, listBO.get(index).getDestPlace());
					}
					
					@Override
					public int getBatchSize() {
						System.out.println(
								"TravelAgentDAOImpl.insertBatch(...).new BatchPreparedStatementSetter() {...}.getBatchSize()");
						return listBO.size();
					}
				}
        );
	
		return result;
	}

}
