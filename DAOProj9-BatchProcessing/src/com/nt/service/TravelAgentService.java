package com.nt.service;

import java.util.List;

import com.nt.dto.PassengerDTO;

public interface TravelAgentService {
    public  String   doGroupReservation(List<PassengerDTO> listDTO);
}
