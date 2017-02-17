package pk.apteka.jo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pk.apteka.jo.domain.Uzytkownik;
import pk.apteka.jo.service.TowarService;
import pk.apteka.jo.service.UzytkownikService;

@Controller
public class UzytkownikController {

	@Autowired
	private TowarService towarService;
	
	@Autowired
	private Uzytkownik uzytkownik;
	
	@Autowired
	private UzytkownikService uzytkownikService;
	
	@RequestMapping(value = "/uzytkownicy", method = RequestMethod.GET)
	public String pokazWszytkichUzytkownikow(ModelMap model){
		model.addAttribute("uzytkownicy",uzytkownikService.showAll());
		return "uzytkownikList";
	}
	
	@RequestMapping(value = "/rejestracja", method = RequestMethod.GET)
	public ModelAndView registerForm() {
		return new ModelAndView("rejestracja", "command", uzytkownik);
	}
		
	@RequestMapping(value = "/rejestracjaAction", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute Uzytkownik uzytkownik) {
		uzytkownikService.add(uzytkownik,1);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String pokazSprzedawcyTowaryUzytkownicy(ModelMap model){
		model.addAttribute("sprzedawcy",uzytkownikService.showSprzedawcy());
		model.addAttribute("towary", towarService.showAll());
		model.addAttribute("uzytkownicy",uzytkownikService.showUzytkownicy());
		model.addAttribute("command", uzytkownik);
		return "admin";
	}
	
	@RequestMapping(value = "/nowySprzedawcaAction", method = RequestMethod.POST)
	public String nowySprzedawca(@ModelAttribute Uzytkownik uzytkownik) {
		uzytkownikService.add(uzytkownik,2);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/usunUzytkownika", method = RequestMethod.GET)
	public String usunUzytkownika(HttpServletRequest request) {
		String login = request.getParameter("login");
		uzytkownikService.usun(login);
		return "redirect:/admin";
	}
}
