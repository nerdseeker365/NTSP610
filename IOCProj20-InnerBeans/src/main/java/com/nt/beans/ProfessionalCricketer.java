package com.nt.beans;

public class ProfessionalCricketer {
	private  String name;
	private  Bat  bat;
	
	public ProfessionalCricketer(String name, Bat bat) {
		this.name = name;
		this.bat = bat;
	}
	
	public  String batting() {
           int runs=0;
           runs=bat.scoreRuns();
           return name+" batsman has score "+runs +" runs";
	}

}
