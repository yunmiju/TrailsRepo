import React, { useState, useContext, useEffect } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ProgramsByPark from './pages/Programs/ProgramsByPark';
import ScrollTop from './components/ScrollTop/ScrollTop';
import Home from './pages/Home/Home';
import Header from './components/Header/Header';
import Footer from './components/Footer/Footer';

function Router() {
  return (
    <BrowserRouter>
      <ScrollTop />
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/programs" element={<ProgramsByPark />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default Router;
