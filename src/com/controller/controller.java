package com.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.*;
import com.model.*;

@Controller
public class controller {
	
	@Autowired
	private country cDAO;
	
	@Autowired
	private state sDAO;
	
	@RequestMapping(value="addCountry.html", method = RequestMethod.GET)  //Country Table Add start
	public ModelAndView addCountry(){
		return new ModelAndView("addCountry", "cVO", new countryVO());
	}
	
	@RequestMapping(value="addCountryData.html", method = RequestMethod.POST) 
	public ModelAndView addCountryData(@ModelAttribute countryVO cVO){
		this.cDAO.insert(cVO);
		return new ModelAndView("redirect:/searchCountry.html");                     //Added end for state
	}
	
	@RequestMapping(value="addState.html", method = RequestMethod.GET)   //State Table Add start
	public ModelAndView addState(@ModelAttribute countryVO cVO){
		List<?> ls = cDAO.search(cVO);
		return new ModelAndView("addState", "sVO", new stateVO()).addObject("clist", ls);
	}
	
	@RequestMapping(value="addStateData.html", method = RequestMethod.POST)
	public ModelAndView addStateData(@ModelAttribute stateVO sVO, countryVO cVO, ServletRequest request){
//		int nid = Integer.parseInt(request.getParameter("countrylist"));
//		sVO.setcVO(cVO);
		this.sDAO.insert(sVO);
		
		return new ModelAndView("redirect:/searchState.html");                               //Added end for state
		
	}
	
	@RequestMapping(value="searchCountry.html", method = RequestMethod.GET)   //Search Country Details
	public ModelAndView searchCountry(@ModelAttribute countryVO cVO){
		List<?> ls = cDAO.search(cVO);
		return new ModelAndView("ViewCountry", "clist", ls);
	}
	
	@RequestMapping(value="searchState.html", method = RequestMethod.GET)   //Search State Details
	public ModelAndView searchState(@ModelAttribute stateVO sVO){
		List<stateVO> ls = sDAO.search(sVO);
		return new ModelAndView("ViewState", "slist", ls);
	}
	

	@RequestMapping(value="editCountry.html", method = RequestMethod.GET)
	public ModelAndView editCountry(@ModelAttribute countryVO cVO, @RequestParam int id){                //Edit Country details
		cVO.setId(id);  
		List<countryVO> cEdit = cDAO.edit(cVO);
		return new ModelAndView("addCountry", "cVO", (countryVO)cEdit.get(0));
	}
	
	@RequestMapping(value="editState.html", method = RequestMethod.GET)
	public ModelAndView editState(@ModelAttribute stateVO sVO,countryVO cVO, @RequestParam int sid){     //Edit State details
	
		sVO.setId(sid);
		List<countryVO> clist = cDAO.search(cVO);
		List<stateVO> sEdit = sDAO.edit(sVO);		
		
		return new ModelAndView("addState", "sVO", (stateVO)sEdit.get(0)).addObject("clist", clist);
		
	}
	
	
	@RequestMapping(value="deleteCountry.html", method = RequestMethod.GET)                                      //delete country details
	public ModelAndView deleteCountry(@ModelAttribute countryVO cVO, @RequestParam int id){
		cVO.setId(id);
		this.cDAO.delete(cVO);
		return new ModelAndView("redirect:/searchCountry.html");
	}
	

	
	@RequestMapping(value="deleteState.html", method = RequestMethod.GET)                                         //delete state details
	public ModelAndView deleteState(@ModelAttribute stateVO sVO, countryVO cVO, @RequestParam int sid){
		
		sVO.setId(sid);
		this.sDAO.delete(sVO);
		
		return new ModelAndView("redirect:/searchState.html");
	}

}
