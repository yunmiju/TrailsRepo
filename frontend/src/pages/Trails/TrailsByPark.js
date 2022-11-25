import React, { useContext, useEffect, useState } from 'react';
import { useLocation, useNavigate, useParams } from 'react-router-dom';
import moment from 'moment';

import axios from 'axios';
import styled from 'styled-components';
import ParkInfo from '../../components/Programs/ParkInfo';
import Trails from '../../components/Trails/Trails';
import BASE_URL from '../../config';
import { ParkIdContext } from '../../App';

function TrailsByPark() {
  const { parkId } = useParams();
  // const [parkId, setParkId] = useContext(ParkIdContext);
  const [park, setPark] = useState();
  const [trails, setTrails] = useState();
  const [isUpdated, setIsUpdated] = useState(false);

  const trailApi = async () => {
    await axios
      .get(`${BASE_URL}/trails/${parkId}`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        console.log(response.data);
        setTrails(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  const parkDetailsApi = async () => {
    await axios
      .get(`${BASE_URL}/parkdetails/${parkId}`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        setPark(response.data);
      })
      .catch(error => {
        console.log(error);
      });
    trailApi();
  };

  useEffect(() => {
    if (parkId !== -1) {
      parkDetailsApi();
      window.scrollTo({
        top: 350,
        behavior: 'smooth',
      });
    }
  }, []);

  useEffect(() => {
    if (isUpdated) {
      parkDetailsApi();
      setIsUpdated(false);
    }
  }, [isUpdated]);

  return (
    <Main>
      {park && <ParkInfo park={park} />}
      {trails && (
        <Trails
          trails={trails}
          setTrails={setTrails}
          isUpdated={isUpdated}
          setIsUpdated={setIsUpdated}
        />
      )}
    </Main>
  );
}

const Main = styled.div`
  html {
    overflow-y: hidden;
    overflow-x: hidden;
  }
  margin: 30px;
  height: 100%;
  display: flex;
`;

export default TrailsByPark;
