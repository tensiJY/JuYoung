package com.juyoung.controller;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.juyoung.service.FileService;

@Controller
@RequestMapping("/FileBoard")
public class FileBoardController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(FileBoardController.class);
	
	@Inject
	private FileService fs;
	
	@RequestMapping(value="/List")
	public void fileList(@RequestParam Map<String, Object>map, 
						 Model model )throws Exception{
		
		String nowPage = (String)map.get("nowPage");
		if(nowPage == null || nowPage.length() == 0){
			nowPage = "1";
		}
		
		map.put("nowPage", nowPage);
		model.addAttribute("MAP", map);
	}// method fileList end
	
	@RequestMapping(value="/Form")
	public void fileWriteForm(@RequestParam Map<String,Object> map,
							  Model model)throws Exception{
		System.out.println(map);
		model.addAttribute("MAP", map);
	}// method fileWriteFrom end;
	
}// class FileBoardController end
