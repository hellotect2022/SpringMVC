import React, { useState, useEffect } from "react";
import "../styles/global.css";
import loginCSS from "../styles/login.css";
import classNames from "classnames";
import LoginBox from "../components/LoginBox";

const LoginPage = () => {
  const login = classNames.bind(loginCSS);
  return (
    <div className="container-wrapper">
      <header className="header">
        <h1 className={login("login-header-title")}>EUMTALK TEST</h1>
      </header>
      <LoginBox />
    </div>
  );
};
export default LoginPage;
