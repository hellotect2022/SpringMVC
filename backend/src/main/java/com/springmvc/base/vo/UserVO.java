package com.springmvc.base.vo;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	private static final long serialVersionUID = 1L;
	private String accessToken;
	private String userId;
	@Nullable
	private String password;
	private String userName;
	private String role;
	private String authProvider;


	
}
