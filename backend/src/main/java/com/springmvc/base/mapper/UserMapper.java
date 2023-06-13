package com.springmvc.base.mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.springmvc.base.vo.UserVO;

public interface UserMapper {
	public void createUser(UserVO userVO);
	public UserVO findByUsername(@Param("userId") String userId);
	public Boolean existsByUsername(@Param("userId") String userId);
	public UserVO findByUsernameAndPassword(@Param("userId") String userId, @Param("password") String password);
}
