package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Simple {   

	@RequestMapping("/adder.spring")
	public ModelAndView add(
			@RequestParam("num1") int a,
			@RequestParam("num2") int b)
	{
		//processing is done
		int c=a+b;
		ModelAndView mav = new ModelAndView();
		//processing result is stored in the mav
		mav.addObject("sum",c);
		//viewName is stored in the mav
		mav.setViewName("result");
		return mav;
	}
	
}









