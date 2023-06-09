package com.springmvc.base.controller;

import org.checkerframework.checker.i18nformatter.qual.I18nFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.base.security.TokenProvider;
import com.springmvc.base.service.UserService;
import com.springmvc.base.vo.ResponseVO;
import com.springmvc.base.vo.UserVO;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	@Autowired
	TokenProvider tokenProvider;

	// 회원가입 sign up
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UserVO userVO) {

		ResponseVO<UserVO> repResponseVO = new ResponseVO<UserVO>();
		try {
			if (userVO == null || userVO.getPassword() == null) {
				throw new RuntimeException("Invalid Password Value");
			}
			UserVO newUserVO = userService.create(userVO);
			repResponseVO.setData(newUserVO);
			return ResponseEntity.ok().body(repResponseVO);
		} catch (Exception e) {
			logger.error(e.getMessage());
			repResponseVO.setStatus("ERROR");
			repResponseVO.setMessage(e.getMessage());
			return ResponseEntity.badRequest().body(repResponseVO);
		}
	}

	// 로그인 sign in
	@PostMapping("/signin")
	public ResponseEntity<?> loginUser(@RequestBody UserVO userVO) {
		ResponseVO<UserVO> repResponseVO = new ResponseVO<UserVO>();
		try {
			UserVO getUserVO = userService.getByCredential(userVO.getUserId(), userVO.getPassword());

			if (getUserVO != null) {
				// 토큰생성
				final String token = tokenProvider.create(getUserVO);
				getUserVO.setAccessToken(token);
			}
			repResponseVO.setData(getUserVO);
			return ResponseEntity.ok().body(repResponseVO);
		} catch (Exception e) {
			logger.error(e.getMessage());
			repResponseVO.setStatus("ERROR");
			repResponseVO.setMessage(e.getMessage());
			return ResponseEntity.badRequest().body(repResponseVO);
		}
	}
}
