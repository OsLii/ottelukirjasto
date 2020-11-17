package com.example.ottelukirjasto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String competitor1;
	private String competitor2;
	private String organization;
	private String place;
	private String division;
	private String date;
	private String info;

	public Bout() {
		super();

	}

	public Bout(String competitor1, String competitor2, String organization, String place, String division, String date,
			String info) {
		super();
		this.competitor1 = competitor1;
		this.competitor2 = competitor2;
		this.organization = organization;
		this.place = place;
		this.division = division;
		this.date = date;
		this.info = info;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompetitor1() {
		return competitor1;
	}

	public void setCompetitor1(String competitor1) {
		this.competitor1 = competitor1;
	}

	public String getCompetitor2() {
		return competitor2;
	}

	public void setCompetitor2(String competitor2) {
		this.competitor2 = competitor2;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
