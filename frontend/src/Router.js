import React, { useState, useContext, useEffect } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ProgramsByPark from './pages/Programs/ProgramsByPark';
import ScrollTop from './components/ScrollTop/ScrollTop';
import Home from './pages/Home/Home';
import ParksAll from './pages/Parks/Parks';
import Header from './components/Header/Header';
import Footer from './components/Footer/Footer';
import { parkContext } from './context/ParkContext';
import axios from 'axios';
import BASE_URL from './config';
import TrailsByPark from './pages/Trails/TrailsByPark';

function Router() {
  return (
    <BrowserRouter>
      <ScrollTop />
      <Header />
      <Routes>
        {/*<Route path="/" element={<Home />} />*/}
        <Route path="/" element={<ParksAll />} />
        <Route path="/park/:parkId/programs" element={<ProgramsByPark />} />
        <Route path="/park/:parkId/trails" element={<TrailsByPark />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default Router;
