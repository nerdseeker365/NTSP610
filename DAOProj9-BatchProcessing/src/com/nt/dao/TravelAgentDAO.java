package com.nt.dao;

import java.util.List;

import com.nt.bo.PassengerBO;

public interface TravelAgentDAO {
     public   int[]   insertBatch(List<PassengerBO> listBO);
}
