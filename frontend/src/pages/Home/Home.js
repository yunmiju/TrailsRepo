import React, { useContext, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import { ParkIdContext } from '../../App';

function Home() {
  const navigate = useNavigate();

  useEffect(() => {
    navigate('./');
  }, []);

  return <Main>"HOME"</Main>;
}

const Main = styled.div``;

export default Home;
