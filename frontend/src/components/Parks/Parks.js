import { parkContext } from '../../context/ParkContext';
import styled from 'styled-components';
import React, { useState, useContext } from 'react';
import ParkIterator from './ParkIterator';

function Parks() {
  const { parks, setParks } = useContext(parkContext);
  // console.log('parks in parks', parks);

  return (
    <Wrapper>
      <Section>
        <ParkWrapper id="scroll" className="scroll-area">
          <Header>
            <Status>
              <div id="curr" />
            </Status>
          </Header>
          <ParkMain>
            <ParkIterator />
          </ParkMain>
        </ParkWrapper>
      </Section>
    </Wrapper>
  );
}

const Wrapper = styled.div``;
const Section = styled.section``;
const ParkWrapper = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  flex-direction: column;
  max-height: 800px;
  overflow-y: auto;
  overflow-x: hidden;
  /* Designing for scroll-bar */
  ::-webkit-scrollbar {
    width: 7px;
  }

  /* Track */
  ::-webkit-scrollbar-track {
    border-radius: 5px;
  }

  :hover {
    /* Handle */
    ::-webkit-scrollbar-thumb {
      background: #979494;
      border-radius: 5px;
    }
    /* Handle on hover */
    ::-webkit-scrollbar-thumb:hover {
      background: #555;
    }
  }
`;

const Header = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const Status = styled.h1`
  text-align: left;
  font-weight: 700;
  font-size: 40px;
  padding: 10px;
`;

const ParkMain = styled.div`
  width: 100%;
`;

export default Parks;
