package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDTO implements Serializable {
	private  String user;
	private String pwd;
}
