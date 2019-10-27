package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="USERLIST")
public class UserHLO implements Serializable  {
	@Id
	@Column(name="uname")
	@Type(type="string")
	private  String user;
	@Column(name="pwd")
	@Type(type="string")
	private String pwd;
}
