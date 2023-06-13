import React, { useState, useEffect } from "react";
import "../styles/global.css";
import joinCSS from "../styles/join.css";
import classNames from "classnames";
import JoinBox from "../components/JoinBox";

const JoinPage = () => {
  const join = classNames.bind(joinCSS);
  return (
    <div className="container-wrapper">
      <header className="header">
        <h1 className={join("join-header-title")}>회원가입</h1>
      </header>
      <JoinBox />
    </div>
  );
};
export default JoinPage;
