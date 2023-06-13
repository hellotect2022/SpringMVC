package com.springmvc.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.base.service.UserService;
import com.springmvc.base.vo.ResponseVO;
import com.springmvc.base.vo.UserVO;

@RestController
@RequestMapping("/auth")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired 
	UserService userService;
	
	// 회원가입 sign up 
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UserVO userVO) {
		
		ResponseVO repResponseVO = new ResponseVO();
		try {
			if (userVO == null || userVO.getPassword()==null) {
				throw new RuntimeException("Invalid Password Value");
			}
			logger.debug("requestUser-signup : ",userVO);
			UserVO newUserVO = userService.create(userVO);
			logger.debug("savedUser : ",newUserVO);
			repResponseVO.setData(newUserVO);
			return ResponseEntity.ok().body(repResponseVO);
		}catch (Exception e) {
			logger.error(e.getMessage());
			repResponseVO.setStatus("ERROR");
			repResponseVO.setMessage(e.getMessage());
			return ResponseEntity.badRequest().body(repResponseVO);
		}
	}
	
	//로그인 sign in
	@PostMapping("/signin")
	public ResponseEntity<?> loginUser(@RequestBody UserVO userVO) {
		ResponseVO repResponseVO = new ResponseVO();
		try {
			logger.debug("requestUser-signin : ",userVO);
			UserVO getUserVO = userService.getByCredential(userVO.getUserId(),userVO.getPassword());
			logger.debug("savedUser : ",getUserVO);
		
			repResponseVO.setData(getUserVO);
			return ResponseEntity.ok().body(repResponseVO);
		}catch (Exception e) {
			logger.error(e.getMessage());
			repResponseVO.setStatus("ERROR");
			repResponseVO.setMessage(e.getMessage());
			return ResponseEntity.badRequest().body(repResponseVO);
		}
	}
}
