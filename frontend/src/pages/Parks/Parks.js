import React, { useContext, useState, useEffect } from 'react';
import axios from 'axios';
import styled from 'styled-components';
import BASE_URL from '../../config';
import Parks from '../../components/Parks/Parks';
import ParkFilterOne from '../../components/Parks/ParkFilterOne';
import {
  parkContext,
  filterOne,
  filterTwo,
  parkCount,
} from '../../context/ParkContext';

function ParksAll() {
  const [firstFilters, setFirstFilters] = useState();
  const [secondFilters, setSecondFilters] = useState();
  const [firstFilter, setFirstFilter] = useState('init');
  const [secondFilter, setSecondFilter] = useState('init');
  const [count, setCount] = useState(0);
  const [parks, setParks] = useState();
  console.log('first filter:', firstFilter);
  console.log('second filter:', secondFilter);

  const parkApi = async () => {
    await axios
      .get(`${BASE_URL}/parks/`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        setParks(response.data);
        firstFilterApi();
        setCount(response.data?.length);
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
        setParks(response.data);
        setCount(response.data?.length);
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

  // const secondFilterApi = async () => {
  //   await axios
  //     .get(`${BASE_URL}/parks/filter/${firstFilter}`, {
  //       headers: {
  //         'Access-Control-Allow-Origin': '*',
  //       },
  //     })
  //     .then(response => {
  //       setSecondFilters(response.data);
  //     })
  //     .catch(error => {
  //       console.log(error);
  //     });
  // };

  useEffect(() => {
    console.log('***', firstFilter);
    if (
      secondFilter === 'init' ||
      secondFilter === undefined ||
      firstFilter === 'init'
    ) {
      parkApi();
    } else {
      parkSelectedApi();
    }
  }, [secondFilter]);

  return (
    <Main>
      <parkCount.Provider value={{ count, setCount }}>
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
      </parkCount.Provider>
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
  span {
    font-family: 'Source-Sans-Pro', sans-serif;
    font-weight: 600;
  }
`;

export default ParksAll;
