package com.controller.travel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.AreaDTO;
import com.dto.AreaPageDTO;
import com.service.AreaService; 


@Controller
public class AreaSearchController  {
	
	@Autowired
	AreaService service;
	
	@RequestMapping(value="/AreaSearch", method = RequestMethod.GET)
	
	public ModelAndView AreaInitialCon (@RequestParam(required=false, defaultValue="") String AInit,
			@RequestParam(required=false, defaultValue="")String searchValue,
			@RequestParam(required=false,defaultValue="1") String curPage) {
		 
		ModelAndView mav = new ModelAndView();
		
		String REGIONCD = AInit;
		String TITLE = searchValue;
		AreaPageDTO aDTO = service.Area_Initial(TITLE,Integer.parseInt(curPage),REGIONCD);
		List<AreaDTO> list = aDTO.getList();
		int perPage = aDTO.getPerPage();
		int totalCount = aDTO.getTotalCount();
		mav.addObject("pdto", aDTO);  
		mav.addObject("REGIONCD", REGIONCD);
		mav.addObject("TITLE", TITLE);  
		mav.addObject("perPage",perPage);
		mav.addObject("curPage",curPage);
		mav.addObject("totalCount",totalCount);
		mav.addObject("list", list);
		mav.setViewName("AreaSearch");
		return mav; 
	}
	

}
