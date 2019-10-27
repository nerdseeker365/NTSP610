package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class FootBallPlayerDTO implements Serializable {
	private int playerId;
	private String playerName;
	private  String role;
	private  String teamName;
	private  int jersyNo;

}
