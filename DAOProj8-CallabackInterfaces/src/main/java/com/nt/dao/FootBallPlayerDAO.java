package com.nt.dao;

import java.util.List;

import com.nt.bo.FootBallPlayerBO;

public interface FootBallPlayerDAO {
     public   FootBallPlayerBO  findPlayerById(int id);
     public   List<FootBallPlayerBO> findPlayersByRole(String role);
}
