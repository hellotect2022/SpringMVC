package com.springmvc.base.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.base.service.BoardService;
import com.springmvc.base.vo.BoardVO;
import com.springmvc.base.vo.RequestVO;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/board")
public class BoardController {
	private static final Logger log = Logger.getLogger(BoardController.class.getName());

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
		s1.setAge("99");
		s1.setName("k8s_test!!");

		return s1;
	}

	@GetMapping("/testCount")
	@ResponseBody
	public int getCount() {

		List<BoardVO> test1 = new ArrayList<BoardVO>();
		test1 = boardService.getBoardList();

		return test1.size();

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
	public List<BoardVO> getDtoList2(@RequestBody RequestVO requestVO) {
		try{
			RequestVO dto = requestVO;
			System.out.println(requestVO.getToken());

			if (dto == null) {
				return null;
			}

			if (!dto.getToken().equals("1")) {
				return null;
			}

			List<BoardVO> test1 = new ArrayList<BoardVO>();
			System.out.println("1");
			test1 = boardService.getBoardList();
			System.out.println("2");
			return test1;
		} catch (Exception e){
			log.info(e.getMessage());
			return null;
		}
	}

	@GetMapping("/redirecting") 
	  public ModelAndView getDtoList3(RedirectAttributes rttr) {
	  
			
		  List<BoardVO> test1 = new ArrayList<BoardVO>(); 
		  test1 =boardService.getBoardList();
		  
		  rttr.addFlashAttribute("list",test1);
			 
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("redirect:/redirectView.do");
		  //mv.addObject("boardVO", );
		  return mv;
		 
	  }

}
