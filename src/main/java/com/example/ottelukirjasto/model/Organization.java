package com.example.ottelukirjasto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long organizationid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
	@JsonIgnore
	private List<Bout> bouts;

	public Organization() {
		super();

	}

	public Organization(String name) {
		super();
		this.name = name;
	}

	public Long getOrganizationid() {
		return organizationid;
	}

	public void setOrganizationid(Long organizationid) {
		this.organizationid = organizationid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Bout> getBouts() {
		return bouts;
	}

	public void setBouts(List<Bout> bouts) {
		this.bouts = bouts;
	}

}
