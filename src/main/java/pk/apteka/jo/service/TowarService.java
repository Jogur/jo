package pk.apteka.jo.service;

import java.util.List;


import pk.apteka.jo.domain.Towar;


public interface TowarService {
	
	/*
	 * zwraca liste wszystkich towarow
	 */
	public List<Towar> showAll();

	/*
	 * usuwa towar o podanym id
	 */
	public void usun(int id);

	/*
	 * dodaje towar
	 */
	public void add(Towar towar);
}
