package validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import daos.UserDao;
import entities.User;
@Component
public class MailValidator implements Validator {

	 //Dependency 
	UserDao dao;
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean supports(Class<?> cls) {
		
		return User.class.equals(cls);
	}

	@Override
	public void validate(Object model, 
			Errors bindingResult) {
		
		User user=(User)model;
		try
		{
		
		if(dao.exists(user.getMailId()))
		{
			bindingResult.rejectValue("mailId","error.mailId", 
					"MailId already registered.");
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
