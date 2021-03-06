package com.biz.ajax0001;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biz.ajax0001.model.DeptVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DeptRESTController {

	//@ResponseBody 안넣어도됨 위에 @RestController쓰면
	@RequestMapping(value="hello", method=RequestMethod.GET, produces="text/plan;charset=utf8")
	public String testREST() {
		return "반갑슴";
	}
	
	@RequestMapping(value="dept.array", method=RequestMethod.POST, produces="text/plan;charset=utf8")
	public String dept(@RequestParam List<String> deptList) {
		for(String s : deptList) {
			log.debug(s);
		}
		return "데이터 수신 OK";
	}
	
	@RequestMapping(value="dept.list", method=RequestMethod.POST, produces="text/plan;charset=utf8")
	public String dept_list(@RequestParam @ModelAttribute List<String> deptList) {
		for(String s : deptList) {
			log.debug(s);
		}
		return "데이터 수신 OK";
	}
}
