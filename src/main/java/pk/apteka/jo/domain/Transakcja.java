package pk.apteka.jo.domain;

import java.util.ArrayList;
import java.util.Calendar;

public class Transakcja {
	private int idTransakcji;
	private Uzytkownik uzytkownik;
	private Calendar data;
	private ArrayList<Towar> towary;
	
	/*
	 * 
	 * SELECT * FROM `uzytkownik` INNER JOIN `transakcja` ON
uzytkownik.idUzytkownika=transakcja.idTransakcji INNER JOIN `towar_transakcja` ON
transakcja.idTransakcji=towar_transakcja.idTransakcji INNER JOIN `towar` ON
towar_transakcja.idTowaru=towar.idTowaru
	 */
	public int getIdTransakcji() {
		return idTransakcji;
	}
	public void setIdTransakcji(int idTransakcji) {
		this.idTransakcji = idTransakcji;
	}
	public Uzytkownik getIdUzytkownika() {
		return uzytkownik;
	}
	public void setIdUzytkownika(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public ArrayList<Towar> getTowary() {
		return towary;
	}
	public void setTowary(ArrayList<Towar> towary) {
		this.towary = towary;
	}
}
