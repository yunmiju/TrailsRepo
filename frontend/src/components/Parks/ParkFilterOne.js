import React, { useContext, useEffect, useState } from 'react';
import { filterOne, filterTwo, parkCount } from '../../context/ParkContext';
import styled from 'styled-components';
import { faArrowRotateBackward } from '@fortawesome/free-solid-svg-icons';
import EmptyParkFilterTwo from './EmptyParkFilterTwo';
import ParkFilterTwo from './ParkFilterTwo';
import axios from 'axios';
import BASE_URL from '../../config';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
function ParkFilterOne(props) {
  const { firstFilter, setFirstFilter } = useContext(filterOne);
  const [secondFilters, setSecondFilters] = useState();
  const { secondFilter, setSecondFilter } = useContext(filterTwo);
  const { firstFilters } = props;
  const { count, setCount } = useContext(parkCount);

  const secondFilterGetter = async () => {
    await axios
      .get(`${BASE_URL}/parks/filter/${firstFilter}`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        setSecondFilters(response.data);
      })
      .catch(e => console.log(e));
  };

  const handleChange = e => {
    setFirstFilter(e.target.value);
  };

  useEffect(() => {
    secondFilterGetter();
  }, [firstFilter]);

  return (
    <Wrapper>
      <Section>
        <Button
          onClick={() => {
            setSecondFilter('init');
          }}
          variant="contained"
          disableElevation
        >
          <Span>RESET</Span>
          <FontAwesomeIcon icon={faArrowRotateBackward} />
        </Button>
        {(firstFilter === 'init') | (firstFilter === '------') ? (
          <EmptyParkFilterTwo />
        ) : (
          <ParkFilterTwo secondFilters={secondFilters} />
        )}
        <Select id="firstFilter" onChange={handleChange}>
          <option>------</option>
          {firstFilters.map(filter => (
            <option key={filter} value={filter}>
              {' '}
              {filter}
            </option>
          ))}
        </Select>
        <Span> RESULT : ( {count} ) </Span>
      </Section>
    </Wrapper>
  );
}

const Button = styled.button`
  margin: 5px;
  border: none;
  width: 100px;
  justify-content: center;
  cursor: pointer;
  font-family: 'Noto Sans KR', sans-serif;
  font-size: var(--button-font-size, 1rem);
  padding: var(--button-padding, 12px 16px);
  border-radius: var(--button-radius, 8px);
  background: transparent;
  color: #444444

  &:active,
  &:hover,
  &:focus {
    background: var(--button-hover-bg-color, #025ce2);
  }
  &:disabled {
    cursor: default;
    opacity: 0.5;
    background: var(--button-bg-color, #025ce2);
  }
`;

const Select = styled.select`
  margin-right: 10px;
`;

const Section = styled.section`
  width: 90vw;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px;
  padding: 10px;
  background-color: white;
  border-radius: 11px;
  box-shadow: 2px 5px 4px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
`;
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

const Span = styled.span`
  font-size: 15px;
  font-color: #025ce2;
  font-family: 'Source-Sans-Pro', sans-serif;
`;
export default ParkFilterOne;
