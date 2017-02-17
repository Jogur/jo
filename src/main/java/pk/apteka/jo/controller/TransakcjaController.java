package pk.apteka.jo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pk.apteka.jo.domain.Transakcja;
import pk.apteka.jo.service.TransakcjaService;

@Controller
public class TransakcjaController {
	//@Autowired
	//private Transakcja transakcja;
	
	@Autowired
	private TransakcjaService transakcjaService;
	
	/*@RequestMapping(value = "/transakcje", method = RequestMethod.GET)
	public String pokazWszytkichUzytkownikow(ModelMap model){
		model.addAttribute("transakcje",transakcjaService.showAll());
		return "transakcjeList";
	}*/
	
	@RequestMapping(value = "/kupTowar", method = RequestMethod.GET)
	public String kupTowar(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    System.out.println("KROKODYL "+name);
		int id = Integer.parseInt(request.getParameter("id"));
		transakcjaService.kup(id, name);
		return "redirect:/towary";
	}
}
