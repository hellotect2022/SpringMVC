package com.springmvc.base.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.base.mapper.UserMapper;
import com.springmvc.base.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserVO create(UserVO userVO) {
		userMapper.createUser(userVO);
		return userVO;
	}

	@Override
	public UserVO getByCredential(String userId, String password) {
		return userMapper.findByUsernameAndPassword(userId, password);
	}

}
