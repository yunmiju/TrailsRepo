import React, { useContext, useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import BASE_URL from '../../config';
import Parks from '../../components/Parks/Parks';
import ParkFilterOne from '../../components/Parks/ParkFilterOne';
import ParkFilterTwo from '../../components/Parks/ParkFilterTwo';
import { parkContext, filterOne, filterTwo } from '../../context/ParkContext';
import Temp from '../../components/Parks/Temp';

function ParksAll() {
  const [firstFilters, setFirstFilters] = useState();
  const [secondFilters, setSecondFilters] = useState();
  const [firstFilter, setFirstFilter] = useState('init');
  const [secondFilter, setSecondFilter] = useState('init');
  const [parks, setParks] = useState();
  console.log('first filter:', firstFilter);
  console.log('second filter:', secondFilter);

  const parkApi = async () => {
    console.log(parks);
    await axios
      .get(`${BASE_URL}/parks/`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        setParks(response.data);
        firstFilterApi();
      })
      .catch(error => {
        console.log(error);
      });
  };

  const parkSelectedApi = async () => {
    await axios
      .get(
        `${BASE_URL}/parks/filter?firstFilter=${firstFilter}&secondFilter=${secondFilter}`,
        {
          headers: {
            'Access-Control-Allow-Origin': '*',
          },
        }
      )
      .then(response => {
        console.log('here');
        setParks(response.data);
        console.log(response.data);
        // firstFilterApi();
      })
      .catch(error => {
        console.log(error);
      });
  };

  const firstFilterApi = async () => {
    await axios
      .get(`${BASE_URL}/parks/filter/`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        setFirstFilters(response.data);
        console.log(firstFilters);
      })
      .catch(error => {
        console.log(error);
      });
  };

  const secondFilterApi = async () => {
    await axios
      .get(`${BASE_URL}/parks/filter/${firstFilter}`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        setSecondFilters(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  const filterListner = async () => {
    await axios
      .get(
        `${BASE_URL}/parks/filter?firstFilter=${firstFilter}&secondFilter=${secondFilter}`,
        {
          headers: {
            'Access-Control-Allow-Origin': '*',
          },
        }
      )
      .then(response => {
        setParks(response.data);
      })
      .catch(error => console.log(error));
  };

  useEffect(() => {
    console.log('***', secondFilter);
    console.log('***', firstFilter);
    if (secondFilter === 'init' || secondFilter === undefined) {
      console.log('here!');
      parkApi();
    } else {
      console.log('should be here!');
      parkSelectedApi();
    }
  }, [secondFilter]);

  return (
    <Main>
      <filterOne.Provider value={{ firstFilter, setFirstFilter }}>
        <filterTwo.Provider value={{ secondFilter, setSecondFilter }}>
          <parkContext.Provider value={{ parks, setParks }}>
            <Contents>
              {firstFilters && <ParkFilterOne firstFilters={firstFilters} />}
              {parks && <Parks parks={parks} />}
            </Contents>
          </parkContext.Provider>
        </filterTwo.Provider>
      </filterOne.Provider>
    </Main>
  );
}

const Main = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  flex-direction: column;
`;

const FilterBox = styled.div`
  width: 100%;
  display: flex;
  height: 50px;
  flex-direction: row;
`;

const Filter = styled.div`
  width: 100%;
  display: flex;
`;

const Contents = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  flex-direction: column;
  max-height: 800px;
`;

export default ParksAll;
