package pk.apteka.jo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.apteka.jo.dao.UzytkownikDao;
import pk.apteka.jo.domain.Uzytkownik;
import pk.apteka.jo.service.UzytkownikService;

@Service
public class UzytkownikServiceImpl implements UzytkownikService{

	@Autowired
	private UzytkownikDao uzytkownikDao;
	
	@Override
	public List<Uzytkownik> showAll() {
		return uzytkownikDao.showAll();
	}

	@Override
	public void add(Uzytkownik uzytkownik, int rola) {
		uzytkownikDao.add(uzytkownik, rola);
	}

	@Override
	public List<Uzytkownik> showSprzedawcy() {
		return uzytkownikDao.showSprzedawcy();
	}

	@Override
	public List<Uzytkownik> showUzytkownicy() {
		return uzytkownikDao.showUzytkownicy();
	}

	@Override
	public void usun(String login) {
		uzytkownikDao.usun(login);
	}

	@Override
	public Uzytkownik find(String loginUzytkownika) {
		return uzytkownikDao.find(loginUzytkownika);
	}

}
