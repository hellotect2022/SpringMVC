import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import loginCSS from "../styles/login.css";
import classNames from "classnames";

const LoginBox = () => {
  const login = classNames.bind(loginCSS);
  return (
    <div className="content">
      <div className={login("login-box-wrapper")}>
        <div className={login("login-input-wrapper")}>
          <input type="text" placeholder="아이디" />
          <input type="password" placeholder="비밀번호" />
        </div>
        <div className={login("login-confirm-button")}>로그인</div>
      </div>
      <div className={login("join-button-wrapper")}>
        <li>아이디 찾기</li>
        <li>비밀번호 찾기</li>
        <li>
          <Link to={"/join"}>회원가입</Link>
        </li>
      </div>
    </div>
  );
};
export default LoginBox;
