import React from "react";
import { Routes, Route } from "react-router-dom";
import { MainPage, LoginPage, JoinPage } from "../pages";

const App = () => {
  return (
    <Routes>
      {/*<Route path="/" element={<MainPage />} />*/}
      <Route path="/" element={<LoginPage />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/join" element={<JoinPage />} />
    </Routes>
  );
};

export default App;
