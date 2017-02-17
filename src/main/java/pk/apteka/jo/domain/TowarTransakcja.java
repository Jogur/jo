package pk.apteka.jo.domain;

import java.util.List;

public class TowarTransakcja {
	private List<Transakcja> trnasakcjaList;
	private List<Towar> towarList;
	private int ilosc;
	
	
	public List<Transakcja> getTrnasakcjaList() {
		return trnasakcjaList;
	}
	public void setTrnasakcjaList(List<Transakcja> trnasakcjaList) {
		this.trnasakcjaList = trnasakcjaList;
	}
	public List<Towar> getTowarList() {
		return towarList;
	}
	public void setTowarList(List<Towar> towarList) {
		this.towarList = towarList;
	}
	public int getIlosc() {
		return ilosc;
	}
	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}
	
	
}
