package com.springmvc.base.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.springmvc.base.service.BoardService;
import com.springmvc.base.vo.BoardVO;
import com.springmvc.base.vo.RequestVO;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;

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
	public List<BoardVO> getDtoList() {

		List<BoardVO> test1 = new ArrayList<BoardVO>();
		System.out.println("1");
		test1 = boardService.getBoardList();
		System.out.println("2");

		return test1;
	}

	
	  @ResponseBody
	  @PostMapping("/testList2") 
	  public List<BoardVO> getDtoList2(@RequestBody RequestVO requestVO ) {
	  
		  RequestVO dto = requestVO; 
		  System.out.println(requestVO.getToken());
		  
		  if (dto == null) { return null; }
		  
		  if (!dto.getToken().equals("1")) { return null; }
		  
		  List<BoardVO> test1 = new ArrayList<BoardVO>(); 
		  System.out.println("1");
		  test1 = boardService.getBoardList(); 
		  System.out.println("2");
		  
		  return test1; 
	  }
	 
}
