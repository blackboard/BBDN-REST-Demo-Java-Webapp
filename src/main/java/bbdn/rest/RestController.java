package bbdn.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bbdn.rest.course.CourseHandler;
import bbdn.rest.datasource.DatasourceHandler;
import bbdn.rest.membership.MembershipHandler;
import bbdn.rest.term.TermHandler;
import bbdn.rest.user.UserHandler;

@Controller
public class RestController {
	
	@RequestMapping("/index") 
	public ModelAndView displayIndex () {
		ModelAndView mv = new ModelAndView("index");

		Authorizer auth = new Authorizer();
		Token token = auth.authorize();
		
		mv.addObject("access_token",token.getToken());
		mv.addObject("token_type", token.getType());
		mv.addObject("expires_in", token.getExpiry());
		
		return(mv);
		
	}
	
	@RequestMapping("/rest")
	public ModelAndView authorize(HttpServletRequest request, HttpServletResponse response,
									@RequestParam("access_token") String access_token,
									@RequestParam("token_type") String token_type,
									@RequestParam("expires_in") String expires_in,
									@RequestParam("object") String object,
									@RequestParam("operation") String operation) {
		
		ModelAndView mv = new ModelAndView("test");
		
		String returnJson = "";
		
		switch (object) {
		case "course":
			CourseHandler courseHandler = new CourseHandler();
			
			switch(operation) {
			case "create":
				returnJson = courseHandler.createObject(access_token);
				break;
			case "read":
				returnJson = courseHandler.readObject(access_token);
				break;
			case "update":
				returnJson = courseHandler.updateObject(access_token);
				break;
			case "delete":
				returnJson = courseHandler.deleteObject(access_token);
				break;
			}
			break;
			
		case "datasource":
			DatasourceHandler datasourceHandler = new DatasourceHandler();
			
			switch(operation) {
			case "create":
				returnJson = datasourceHandler.createObject(access_token);
				break;
			case "read":
				returnJson = datasourceHandler.readObject(access_token);
				break;
			case "update":
				returnJson = datasourceHandler.updateObject(access_token);
				break;
			case "delete":
				returnJson = datasourceHandler.deleteObject(access_token);
				break;
			}
			break;
			
		case "membership":
			MembershipHandler membershipHandler = new MembershipHandler();
			
			switch(operation) {
			case "create":
				returnJson = membershipHandler.createObject(access_token);
				break;
			case "read":
				returnJson = membershipHandler.readObject(access_token);
				break;
			case "update":
				returnJson = membershipHandler.updateObject(access_token);
				break;
			case "delete":
				returnJson = membershipHandler.deleteObject(access_token);
				break;
			}
			break;
			
		case "term":
			TermHandler termHandler = new TermHandler();
			
			switch(operation) {
			case "create":
				returnJson = termHandler.createObject(access_token);
				break;
			case "read":
				returnJson = termHandler.readObject(access_token);
				break;
			case "update":
				returnJson = termHandler.updateObject(access_token);
				break;
			case "delete":
				returnJson = termHandler.deleteObject(access_token);
				break;
			}
			break;
			
		case "user":
			UserHandler userHandler = new UserHandler();
			
			switch(operation) {
			case "create":
				returnJson = userHandler.createObject(access_token);
				break;
			case "read":
				returnJson = userHandler.readObject(access_token);
				break;
			case "update":
				returnJson = userHandler.updateObject(access_token);
				break;
			case "delete":
				returnJson = userHandler.deleteObject(access_token);
				break;
			}
			break;
		}
		
		mv.addObject("access_token", access_token);
		mv.addObject("token_type", token_type);
		mv.addObject("expires_in", expires_in);
		mv.addObject("return_json", returnJson);
		mv.addObject("operation", operation);
		mv.addObject("object", object);
		
		return(mv);
		
		
	}
}
