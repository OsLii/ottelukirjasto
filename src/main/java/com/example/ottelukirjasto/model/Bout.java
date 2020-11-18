package com.example.ottelukirjasto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Bout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String competitor1;
	private String competitor2;
	private String place;
	private String division;
	private String date;
	private String info;

	@ManyToOne
	@JoinColumn(name = "organizationid")
	@JsonManagedReference
	private Organization organization;

	public Bout() {
		super();

	}

	public Bout(String competitor1, String competitor2, Organization organization, String place, String division,
			String date, String info) {
		super();
		this.competitor1 = competitor1;
		this.competitor2 = competitor2;
		this.organization = organization;
		this.place = place;
		this.division = division;
		this.date = date;
		this.info = info;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
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

	@Override
	public String toString() {
		if (this.organization != null) {
			return "Bout [id=" + id + ", competitor1=" + competitor1 + ", competitor2=" + competitor2 + ", place="
					+ place + ", division=" + division + ", date=" + date + ", info=" + info + ", organization="
					+ ", getCategory()=" + this.getOrganization() + "]";
		} else {
			return "Bout [id=" + id + ", competitor1=" + competitor1 + ", competitor2=" + competitor2 + ", place="
					+ place + ", division=" + division + ", date=" + date + ", info=" + info + "]";

		}
	}

}
