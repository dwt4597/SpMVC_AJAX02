package com.biz.ajax0001;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ajax0001.model.DeptVO;
import com.biz.ajax0001.service.DeptService;

@Controller
public class DeptController {

	@Autowired
	DeptService dService;
	
	@RequestMapping(value="dept",method=RequestMethod.GET)
	public String dept_list(Model model) {
		
		List<DeptVO> deptList = dService.getDeptList();
		model.addAttribute("DEPTLIST",deptList);
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="dept", method=RequestMethod.POST, produces="text/plan;charset=utf8")
	public String get_dept(@RequestParam String d_code) {
		
		DeptVO deptVO = dService.getDept(d_code);
		return deptVO.toString();
	}
	
	
	/*
	 * ajax로 호출된 결과를 return 할 때
	 * 문자열로 return을 하려면
	 * @ResponseBody를 설정해 주면 된다.
	 * 
	 * 그런데 
	 * ajax로 호출된 결과를 다른 용도로 사용하려면
	 * JSON 형태로 return을 해 주는 것이 좋다.
	 * 
	 * 하지만
	 * JAVA(spring)에서는 기본적으로 JSON이라는 데이터 형태를
	 * 지원하지 않는다.
	 * 
	 * 다행히 spring에는 JSON을 쉽게 사용할 수 있는 
	 * 통로가 마련되어있고,
	 * 한가지의 3rd part lib만 설정해주면 된다.
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value="dept.JSON", method=RequestMethod.POST, produces="application/json;charset=utf8")
	public DeptVO get_dept_json(@RequestParam String d_code) {
		
		DeptVO deptVO = dService.getDept(d_code);
		return deptVO;
	}
	
	
}
