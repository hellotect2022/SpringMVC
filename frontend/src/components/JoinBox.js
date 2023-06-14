import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import joinCSS from "../styles/join.css";
import classNames from "classnames";

const JoinBox = () => {
  const join = classNames.bind(joinCSS);
  return (
    <div className="content">
      <div className={join("join-box-wrapper")}>
        <div className={join("join-input-wrapper")}>
          <input type="text" placeholder="이름을 입력하세요," />
          <input type="text" placeholder="생년월일을 입력하세요." />
          <input type="text" placeholder="사용 할 아이디를 입력하세요." />
          <input type="text" placeholder="사용 할 비밀번호를 입력하세요." />
        </div>
        <div className={join("join-confirm-button")}>확인</div>
      </div>
    </div>
  );
};
export default JoinBox;
