package com.example.ottelukirjasto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ottelu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String ottelija1;
	private String ottelija2;
	private String organisaatio;
	private String paikka;
	private String painoluokka;
	private String pvm;
	private String lisätietoja;

	public Ottelu() {
		super();

	}

	public Ottelu(String ottelija1, String ottelija2, String organisaatio, String paikka, String painoluokka,
			String pvm, String lisätietoja) {
		super();
		this.ottelija1 = ottelija1;
		this.ottelija2 = ottelija2;
		this.organisaatio = organisaatio;
		this.paikka = paikka;
		this.painoluokka = painoluokka;
		this.pvm = pvm;
		this.lisätietoja = lisätietoja;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOttelija1() {
		return ottelija1;
	}

	public void setOttelija1(String ottelija1) {
		this.ottelija1 = ottelija1;
	}

	public String getOttelija2() {
		return ottelija2;
	}

	public void setOttelija2(String ottelija2) {
		this.ottelija2 = ottelija2;
	}

	public String getOrganisaatio() {
		return organisaatio;
	}

	public void setOrganisaatio(String organisaatio) {
		this.organisaatio = organisaatio;
	}

	public String getPaikka() {
		return paikka;
	}

	public void setPaikka(String paikka) {
		this.paikka = paikka;
	}

	public String getPainoluokka() {
		return painoluokka;
	}

	public void setPainoluokka(String painoluokka) {
		this.painoluokka = painoluokka;
	}

	public String getPvm() {
		return pvm;
	}

	public void setPvm(String pvm) {
		this.pvm = pvm;
	}

	public String getLisätietoja() {
		return lisätietoja;
	}

	public void setLisätietoja(String lisätietoja) {
		this.lisätietoja = lisätietoja;
	}

	@Override
	public String toString() {
		return "Ottelu [id=" + id + ", ottelija1=" + ottelija1 + ", ottelija2=" + ottelija2 + ", organisaatio="
				+ organisaatio + ", paikka=" + paikka + ", painoluokka=" + painoluokka + ", pvm=" + pvm
				+ ", lisätietoja=" + lisätietoja + "]";
	}

	
}
