package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserInfoDTO implements Serializable {
	private String uname;
	private String pwd;

}
