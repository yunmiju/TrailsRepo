import React, { useContext, useState } from 'react';
import styled from 'styled-components';
import { parkContext } from '../../context/ParkContext';
import Program from '../Programs/Program';
import ProgramEmpty from '../Programs/ProgramEmpty';
import Park from '../Parks/Park';
import ParkEmpty from '../Parks/ParkEmpty';

function ParkIterator() {
  const { parks, setParks } = useContext(parkContext);

  return (
    <Wrapper>
      <Section>
        <ParkWrapper>
          {parks?.length > 0 ? (
            parks?.map(park => <Park key={park.id} park={park} />)
          ) : (
            <ParkEmpty />
          )}
        </ParkWrapper>
      </Section>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  width: 100%;
  display: flex;
`;

const Section = styled.section`
  width: 100%;
  display: flex;
`;

const ParkWrapper = styled.section`
  width: 100%;
  display: flex;
  flex-direction: column;
`;

export default ParkIterator;
