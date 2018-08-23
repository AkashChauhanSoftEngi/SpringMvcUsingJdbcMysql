package spring.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.project.dao.ContactDAO;
import spring.project.model.Contact;

@Controller
@RequestMapping("/")
public class ContactController {

	@Autowired
	public ContactDAO contactDAO;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listContact(ModelAndView model) {
		List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value="/newContact", method=RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model){
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("ContactForm");
		return model;
	}
	
	@RequestMapping(value="/saveContact", method=RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact){
		contactDAO.saveOrUpdate(contact);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/editContact", method=RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request){
		int contactId = Integer.parseInt(request.getParameter("id"));
	    Contact contact = contactDAO.get(contactId);
	    ModelAndView model = new ModelAndView("ContactForm");
	    model.addObject("contact", contact);
	 
	    return model;
	}
	
	@RequestMapping(value="/deleteContact", method=RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request){
		int contactId = Integer.parseInt(request.getParameter("id"));
	    contactDAO.delete(contactId);
	    return new ModelAndView("redirect:/");
	}
}
