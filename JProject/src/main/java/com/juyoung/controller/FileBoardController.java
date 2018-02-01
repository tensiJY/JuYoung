package com.juyoung.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.juyoung.domain.FileVO;
import com.juyoung.service.FileService;
import com.juyoung.util.FileUtil;
import com.juyoung.util.StringUtil;
import com.juyoung.validator.FileValidator;

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
	
	/**
	 * 
	 * @param map
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value="/Form")
	public void fileWriteForm(@RequestParam Map<String,Object> map,
							  Model model)throws Exception{
		model.addAttribute("MAP", map);
	}// method fileWriteFrom end;
	
	// @ModelAttribute("fvo") FileVO fvo, BindingResult result
	/*String path = session.getServletContext().getRealPath("UPLOAD");
	 * @RequestParam Map<String, Object> map,
							  @RequestParam MultipartFile[] files,
			                  Model model*/
	@RequestMapping(value="/Proc", method=RequestMethod.POST)
	public String fileWriteProc(@ModelAttribute("fvo")FileVO fvo,
							 BindingResult result) throws Exception{
		new FileValidator().validate(fvo, result);
		
		if(result.hasErrors()){
			
			return "FileBoard/Form";
		}else{

			String path="C:\\Users\\juyoung\\Desktop\\SpringUpload";
			int loop = fvo.getFiles().length;
			
			List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
			for(int i=0; i<loop; i++){
				String name = fvo.getFiles()[i].getOriginalFilename();
				if(StringUtil.isNull(name)){
					continue;
				}
				
				String saveName = new FileUtil().uploadFile(fvo.getFiles()[i], name, path);
				
				Map<String, Object>	map = new HashMap<String, Object>();
				map.put("oriName", fvo.getFiles()[i].getOriginalFilename());
				map.put("saveName", saveName);
				map.put("len", fvo.getFiles()[i].getSize());
				map.put("path", path);
				
				fileList.add(map);
			}
			
			//fService.insertBoard(fVO, fileInfoList);
			
			return "redirect:../FileBoard/List.park";
		}
		
	}// method fileWriteProc end
	
}// class FileBoardController end
