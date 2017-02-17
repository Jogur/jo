package pk.apteka.jo;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SamochodService {

	@Autowired
	private SamochodDao dao;

	@Autowired
	public void setDao(SamochodDao dao) {
		this.dao = dao;
	}
	
	@PostConstruct
	public void forTesting() {
		System.out.println("*** HELLO WORLD ***");
		List<Samochod> samochody=dao.query();
		for (Samochod samochod : samochody) {
			samochod.uruchomSamochod();
		}
		
		Samochod nowy = new Samochod();
		nowy.setMarka("A");
		nowy.setModel("krokodyl");
		dao.insert(nowy);
	}

	public List<Samochod> showAll() {
		return dao.showAll();
	}
	
	/*public List<Samochod> pobierz() {
		System.out.println("*** HELLO WORLD ***");
		List<Samochod> samochody=dao.query();
		for (Samochod samochod : samochody) {
			samochod.uruchomSamochod();
		}
		return samochody;
	}*/
}
