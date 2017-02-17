package pk.apteka.jo.service;

import java.util.List;

import pk.apteka.jo.domain.Uzytkownik;

public interface UzytkownikService {

	/*
	 * zwraca liste wszystkich uzytkownikow
	 */
	public List<Uzytkownik> showAll();

	/*
	 * dodaje nowego uzytkownika, rola 1-ROLE_USER, 2-ROLE_DEALER
	 */
	public void add(Uzytkownik uzytkownik, int rola);

	/*
	 * zwraca liste tylko sprzedawcow
	 */
	public List<Uzytkownik> showSprzedawcy();

	/*
	 * zsraca liste uzytkownikow o roli: ROLE USER
	 */
	public List<Uzytkownik> showUzytkownicy();

	/*
	 * usuwaUzytkownika o podanym loginie
	 */
	public void usun(String login);

	/*
	 * zwraca uzytkownika z danym loginem
	 */
	public Uzytkownik find(String loginUzytkownika);
}
