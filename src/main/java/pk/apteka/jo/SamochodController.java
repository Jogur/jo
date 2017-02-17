package pk.apteka.jo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@Controller
public class SamochodController {

	@Autowired
	private SamochodService samochodService;
	
	@Autowired 
	private SamochodDao samochodDao;
	
	@RequestMapping(value = "/pobierz", method = RequestMethod.GET)
	@ResponseBody 
	public List<Samochod> pobierzLista(){

		System.out.println("krokodyl pobierz lista");
		//return samochodDao;
		return samochodDao.query();
	}
	
	@RequestMapping(value = "/dodaj", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void p(@RequestBody Samochod nowy)
	{
		//samochodDao.insert(nowy);
	}
	
	@RequestMapping(value = "/auta", method = RequestMethod.GET)
	public String showAllProducts(ModelMap model) {
		model.addAttribute("samochody", samochodService.showAll());
		return "samochodList";
	}
}
