import logo from './logo.svg';
import './App.css';

import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import TeamPage from "./components/TeamPage";
import MatchPage from "./components/MatchPage";
import React from "react";
function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          {/* <Route path="/" element={<div>Home Page</div>} />/ */}
          <Route path="/team/:teamName" element={<TeamPage />} />
          <Route path="/team/:teamName/matches/:year" element={<MatchPage />} />

        </Routes>
      </Router>
      {/* <TeamPage /> */}
      <MatchPage />

    </div>
  );
}

export default App;
