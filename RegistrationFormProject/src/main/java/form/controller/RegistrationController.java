package form.controller;

/*Multiaction Controller:
 * 					Controller which contains multiple mapping 
 * 				
 * Autowired Annotation
 * 
 * */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.scenario.effect.Blend.Mode;

import form.dao.RegistrationData;
import form.dao.RegistrationI;
import form.model.RegistrationModel;

@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationData registerDataobj;
	
	static Logger logger = Logger.getLogger(RegistrationController.class.getName());
	
	@RequestMapping("/data")
	public ModelAndView SuccessfulLogin(HttpServletRequest request,HttpServletResponse response)
	{
		logger.info("Inside controller successFull Login");
		String email,password;
		email=request.getParameter("email");
		password=request.getParameter("password");
		
		logger.info("Email is "+email+"Password is "+password);
		
		ModelAndView model=new ModelAndView("welcome");
	
		model.addObject("email",email);
	
		//model.addObject(attributeValue)
		return model;
			
	}
	
	@RequestMapping("/registerData")
	public ModelAndView registerationForm(HttpServletRequest request,HttpServletResponse response) {
		logger.info("Inside Registration URL Mapping");
		ModelAndView model=new ModelAndView("signup");
		return model;
	}
	
	@RequestMapping(value="/addData",method=RequestMethod.POST)
		public String insertData(@ModelAttribute("registartion")RegistrationModel model )
		{
			String email=model.getEmail();
			boolean result=true;
			result=registerDataobj.create(model);
			if(result==true)
			{
				logger.info("Inside post method addData");
				return "redirect:viewData";
			}
			else
			{
				//String errorMessage="EAlready Exists";
				logger.info("Error: Already exists");
				return "redirect:Error";
			}
			
			
		}
       
	@RequestMapping(value="/viewData")
	public ModelAndView displayAllData(Model model)
	{
		logger.info("Inside viewData mapping");
		List<RegistrationModel>allData=registerDataobj.displayAllData();
		model.addAttribute("AllData",allData);
		logger.info("All data is "+allData);
		
		ModelAndView modelview=new ModelAndView("viewData");
		
		modelview.addObject("allData",allData);
		
		return modelview;
		
	}

	@RequestMapping(value="/Error")
	public ModelAndView displayErrorMessage(Model model)
	{
		logger.info("Inside Error page mapping");
		ModelAndView modelview=new ModelAndView("Error");
		return modelview;
	}
	/*
	 * @RequestMapping(value="/deleteData") public ModelAndView deleteData(Model
	 * model) { logger.info("Inside Delete Data mapping");
	 * 
	 * ModelAndView modelview=new ModelAndView("viewData"); return modelview;
	 * 
	 * }
	 */
	
	@RequestMapping(value="/UpdatePage",method=RequestMethod.POST)
	public ModelAndView  updateData(@ModelAttribute("update")RegistrationModel model )
	{
		logger.info("Inside Update Data URL Mapping");
		registerDataobj.editData(model);
		
		ModelAndView modelview=new ModelAndView("UpdatePage");
		return modelview;
		//return "redirect:UpdatePage";
	}
		
	
	  
}
