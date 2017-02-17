package pk.apteka.jo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.apteka.jo.dao.TowarDao;
import pk.apteka.jo.domain.Towar;
import pk.apteka.jo.service.TowarService;

@Service
public class TowarServiceImpl implements TowarService{

	@Autowired
	private TowarDao towarDao;
	
	@Override
	public List<Towar> showAll() {
		return towarDao.showAll();
	}

	@Override
	public void usun(int id) {
		towarDao.usun(id);
	}

	@Override
	public void add(Towar towar) {
		towarDao.dodaj(towar);
	}

}
