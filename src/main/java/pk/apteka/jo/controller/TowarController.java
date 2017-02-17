package pk.apteka.jo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pk.apteka.jo.domain.Towar;
import pk.apteka.jo.domain.Uzytkownik;
import pk.apteka.jo.service.TowarService;

@Controller
public class TowarController {

	@Autowired
	private TowarService towarService;
	
	@Autowired
	private Towar towar;
	
	@RequestMapping(value = "/towary", method = RequestMethod.GET)
	public String pokazWszystkieTowary(ModelMap model){
		//System.out.println("TOWAR Controller");
		model.addAttribute("towary", towarService.showAll());
		//System.out.println("TOWAR con2");
		return "towarList";
	}
	
	@RequestMapping(value = "/usunTowar", method = RequestMethod.GET)
	public String usunTowar(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		int temp = Integer.parseInt(request.getParameter("temp"));
		System.out.println("KROKODYL "+request.getRequestURI());
		towarService.usun(id);
		if(temp==1){
			return "redirect:/towary";
		}
		
		return "redirect:/admin";
	}
	
	
	
	@RequestMapping(value = "/towarDodajAction", method = RequestMethod.POST)
	public String nowySprzedawca(@ModelAttribute Towar towar) {
		towarService.add(towar);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/towarForm", method = RequestMethod.GET)
	public ModelAndView registerForm() {
		return new ModelAndView("towarForm", "command", towar);
	}
	
	
}
