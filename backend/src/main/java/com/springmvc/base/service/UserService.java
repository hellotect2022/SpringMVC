package com.springmvc.base.service;

import com.springmvc.base.vo.UserVO;

public interface UserService {

	public UserVO create(UserVO userVO);
	public UserVO getByCredential(String userID, String password);
}
