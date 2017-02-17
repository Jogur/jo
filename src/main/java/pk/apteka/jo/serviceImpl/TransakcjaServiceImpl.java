package pk.apteka.jo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.apteka.jo.dao.TransakcjaDao;
import pk.apteka.jo.domain.Transakcja;
import pk.apteka.jo.service.TransakcjaService;

@Service
public class TransakcjaServiceImpl implements TransakcjaService{

	@Autowired
	private TransakcjaDao transakcjaDao;
	
	@Override
	public List<Transakcja> towaryTransakcji(int id) {
		return transakcjaDao.towaryTransakcji(id);
	}

	@Override
	public void kup(int idTowaru, String loginUzytkownika) {
		transakcjaDao.kup(idTowaru, loginUzytkownika);
		
	}

}
