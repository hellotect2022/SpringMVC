package com.springmvc.base.controller.api;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

	
	public class SampleDto {
		String name;
		String age;
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setAge(String age) {
			this.age = age;
		}
		
		
		public String getName() {
			return this.name;
		}
		
		public String getAge() {
			return this.age;
		}
	}
	
	@GetMapping("/list")
	@ResponseBody
	public List<String> getList() {
		
		List<String> test1 = new ArrayList<String>();
		
		test1.add("a");
		test1.add("b");
		test1.add("c");
		test1.add("d");
		
		
		return test1;
	}
	
	@GetMapping("/test")
	@ResponseBody
	public SampleDto getDto() {
		
	    SampleDto s1 = new SampleDto();
	    s1.setAge("1");
	    s1.setName("Han");

		
		return s1;
	}
	
	@GetMapping("/testList")
	@ResponseBody
	public List<SampleDto> getDtoList() {
		
		List<SampleDto> test1 = new ArrayList<SampleDto>();

	    SampleDto s1 = new SampleDto();
	    s1.setAge("1");
	    s1.setName("Han");
	    test1.add(s1);
	    
	    SampleDto s2 = new SampleDto();
	    s2.setAge("2");
	    s2.setName("Choi");
	    test1.add(s2);
	    
		
		return test1;
	}
}
