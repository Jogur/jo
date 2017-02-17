package pk.apteka.jo.domain;

import java.math.BigDecimal;

public class Towar {

	private int id;
	private String nazwa;
	private String opis;
	private double cena;
	private String typ;
	private int pojemnosc;
	private boolean dostepnosc;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public int getPojemnosc() {
		return pojemnosc;
	}
	public void setPojemnosc(int pojemnosc) {
		this.pojemnosc = pojemnosc;
	}
	public boolean isDostepnosc() {
		return dostepnosc;
	}
	public void setDostepnosc(boolean dostepnosc) {
		this.dostepnosc = dostepnosc;
	}
	
}
