package pk.apteka.jo.service;
import java.util.List;

import pk.apteka.jo.domain.Transakcja;
public interface TransakcjaService {

	/*
	 * zwraca towary danej transakcji
	 */
	public List<Transakcja> towaryTransakcji(int id);

	/*
	 * tworzy nowa transakcje
	 */
	public void kup(int idTowaru, String loginUzytkownika);
}
