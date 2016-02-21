package bbdn.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BbdnController {
	
	@RequestMapping("/index") 
	public ModelAndView displayIndex () {
		ModelAndView mv = new ModelAndView("index");
		
		return(mv);
		
	}
	
	@RequestMapping("/auth")
	public ModelAndView authorize(HttpServletRequest request, HttpServletResponse response,
									@RequestParam("key") String key,
									@RequestParam("secret") String secret) {
		
		ModelAndView mv = new ModelAndView("test");
		
		Authorizer auth = new Authorizer(key,secret,"ultra-integ.int.bbpd.io");
			
		mv.addObject("access_token", auth.authorize());
		
		return(mv);
		
		
	}
}
