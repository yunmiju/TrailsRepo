import React, { useContext, useEffect, useState } from 'react';
import { filterOne } from '../../context/ParkContext';
import styled from 'styled-components';

import Dropdown from 'react-dropdown';
import EmptyParkFilterTwo from './EmptyParkFilterTwo';
import ParkFilterTwo from './ParkFilterTwo';
import axios from 'axios';
import BASE_URL from '../../config';

function ParkFilterOne(props) {
  const { firstFilter, setFirstFilter } = useContext(filterOne);
  const [secondFilters, setSecondFilters] = useState();
  const { firstFilters } = props;

  const secondFilterGetter = async () => {
    console.log('firstFilter', firstFilters);
    await axios
      .get(`${BASE_URL}/parks/filter/${firstFilter.firstFilter}`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        console.log('firstFilter', { firstFilter });
        setSecondFilters(response.data);
        console.log('secondFilter After', response.data);
      })
      .catch(e => console.log(e));
  };

  const handleChange = e => {
    setFirstFilter(e.target.value);
    // secondFilterGetter();
    console.log(firstFilter);
  };

  useEffect(() => {
    secondFilterGetter();
  }, [firstFilter]);

  return (
    <Wrapper>
      {(firstFilter == 'init') | (firstFilter == '------') ? (
        <EmptyParkFilterTwo />
      ) : (
        <ParkFilterTwo secondFilters={secondFilters} />
      )}
      <select id="firstFilter" onChange={handleChange}>
        <option>------</option>
        {firstFilters.map(filter => (
          <option key={filter} value={filter}>
            {' '}
            {filter}
          </option>
        ))}
      </select>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  width: 100%;
  height: 100px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
`;
const Main = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  flex-direction: column;
`;

const select = styled.div`
  width: 100%;
  height: 100px;
  display: flex;
  align-items: center;
  flex-direction: column;
`;

export default ParkFilterOne;
