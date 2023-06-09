package com.springmvc.base.security;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springmvc.base.vo.UserVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenProvider {
	private static Logger logger =LoggerFactory.getLogger(TokenProvider.class);
	
	private static final String SECRET_KEY_STRING ="FlRpX30MqDbIaKMLfArBrMvKdd4RqIsSk"
			+ "GzMbfAX5OgVxzxxwuzTrHjYsKIHMIV9M10ICEGKPi46advrcX1E6CMTUBc6IFbTPiD";

	/*
	 * {//header
	 *   "alg" : "HS512"
 	 * }.
	 * {//payload
	 *   "sub" : "userId"
	 *   "iss" : "SpringMVC"
	 *   "iat" : "현재시간"
	 *   "exp" : "마감기한"
	 * }.
	 * //SECRET_KEY_STRING 을 이용해서 서명한 부분
	 * 
	 * 
	 * */
	
	public String create(UserVO userVO) {
		Date exDate =Date.from(Instant.now().plus(1,ChronoUnit.DAYS));
		log.debug("Date :", new Date());
		log.debug("exDate :", new Date());
		log.debug("SECRET_KEY_STRING :", SECRET_KEY_STRING);
		log.debug("SECRET_KEY_STRING-byte :", SECRET_KEY_STRING.getBytes());
	
		return Jwts.builder()
				//header에 들어갈 내용 및 서명을 하기 위한 SECRET_KEY
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY_STRING.getBytes())
				//payload에 들어갈 내용
				.setSubject(userVO.getUserId()) //sub
				.setIssuer("SpringMVC") // iss
				.setIssuedAt(new Date()) // iat
				.setExpiration(exDate)      // exp
				.compact(); 		
	}
	
	public String validateAndGetUserId(String token) {
		// parseClaimJwt 메서드가 Base64로 디코딩 및 파싱 
		// 헤더와 페이로드를 setSigningKey로 서명 후 token의 서명과 비교 
		// 위조되지 않앗으면 페이로드 Claims 리턴 아니면 예외날림 
		// getBody를 통해서 userId 가져옴 
		Claims claims =Jwts.parser()
				.setSigningKey(SECRET_KEY_STRING.getBytes())
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}

}
