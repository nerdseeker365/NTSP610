package com.nt.service;

import java.util.List;

import com.nt.dto.FootBallPlayerDTO;

public interface FootBallPlayerService {
    public  FootBallPlayerDTO  searchPlayerById(int id);
    public  List<FootBallPlayerDTO> searchPlayerRole(String role);
    
}
