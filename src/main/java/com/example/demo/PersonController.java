package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Controller
public class PersonController {

	@Autowired
	PersonDao personDao;

	@RequestMapping("/")
	public String service() {
		return "home.jsp";
	}

	@RequestMapping("/addPerson")
	public String add(Person person) {
		personDao.save(person);
		return "home.jsp";
	}

	@RequestMapping("/getPerson")
	public ModelAndView get(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("showPerson.jsp");
		Person person = personDao.findById(id).orElse(new Person());
		mv.addObject(person);
		// mv.setViewName("showPerson.jsp");
		return mv;
	}

	@RequestMapping("/updatePerson")
	public ModelAndView updatePerson(@RequestParam int id, @RequestParam String name) {
		Optional<Person> personOption = personDao.findById(id);
		ModelAndView mv = new ModelAndView("showPerson.jsp");
		if (personOption.isPresent()) {
			Person person = personOption.get();
			person.setName(name);
			personDao.save(person);
			mv.addObject(person);
		}
		return mv;
	}

	@RequestMapping("/deletePerson")
	public ModelAndView delete(@RequestParam int id) {
		Optional<Person> personOption = personDao.findById(id);
		ModelAndView mv = new ModelAndView("showPerson.jsp");
		if (personOption.isPresent()) {
			Person person = personOption.get();
			personDao.delete(person);
			mv.addObject(person);
		}
		return mv;
	}

	@RequestMapping("/displayAll")
	public ModelAndView fetchAll() {
		List<Person> personList = (List<Person>) personDao.findAll();
		ModelAndView mv = new ModelAndView("personList.jsp");
		mv.addObject("personList", personList);
		return mv;
	}

	@RequestMapping("/findPersonByTech")
	public String findByTech(@RequestParam String tech) {
		List<Person> personList = personDao.findByTech(tech);
		System.out.println("by tech" + personList);
		personList = personDao.findByIdGreaterThan(101);
		System.out.println("By id" + personList);
		personList = personDao.findByTechSorted("java");
		System.out.println("find by tech sort by name" + personList);
		return "showPerson.jsp";
	}
}
