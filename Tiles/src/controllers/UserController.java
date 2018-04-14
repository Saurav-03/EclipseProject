package controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import daos.UserDao;
import entities.User;
import validators.MailValidator;

@Controller
public class UserController {   

	//Dependency of the controller
	@Autowired
	private UserDao dao;
	@Autowired
	HttpSession session;
	@Autowired
	MailValidator mailValidator; 
	//method to server registration form
	//Method to process user registration request
		@RequestMapping("/registerForm.spring")
		public ModelAndView regForm()
		{
			ModelAndView mav=new ModelAndView();
			mav.setViewName("registerForm");
			mav.addObject("user",new User());
			return mav;
		}
	//Method to process user registration request
	@RequestMapping("/register.spring")
	public ModelAndView signUp(@Valid @ModelAttribute User user,
			BindingResult validationResult) throws Exception
	{
		ModelAndView mav=new ModelAndView();
		//custom validations are applied
		mailValidator.validate(user, validationResult);
		
		if(validationResult.hasErrors())
		{
			mav.setViewName("registerForm");
			mav.addObject("user",user);
		}
		else
		{	
		dao.save(user);
		mav.setViewName("registered");
		}
		return mav; //ModelAndView is returned.
	}
	//method to process user login request
	@RequestMapping("/login.spring")
	public String signIn(@ModelAttribute User user ) throws Exception
	{
		if(dao.find(user))
		{
	     //user object is saved as attribute in the session
		session.setAttribute("user", user);
		return "home"; //view name is returned.
		}
		else
	     return "relogin";
	}
	//method to process user logout request
		@RequestMapping("/logout.spring")
		public String signOut(@ModelAttribute User user ) throws Exception
		{
			
			session.invalidate();
			return "loggedOut"; //view name is returned.
			
		}
		
		//method to process viewProfile request
				@RequestMapping("/viewProfile.spring")
				public String viewProfile() throws Exception
				{
					
					return "profile"; //view name is returned.
					
				}
				
		//method to process updateProfile request
		@RequestMapping(value="/updateProfile.spring",method={RequestMethod.POST})
		public String updateProfile(
				@ModelAttribute User user) throws Exception
		{
			//user details are updated in the DB
			dao.update(user);
			//user details are updated in the session
			session.setAttribute("user", user);
			return "updated"; //view name is returned.
			
		}		
		
}









