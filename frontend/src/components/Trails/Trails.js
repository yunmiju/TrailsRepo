import React, { useState } from 'react';
import styled from 'styled-components';
import { Edit } from '@styled-icons/boxicons-solid';
// import Reservation from './Reservation';
import TrailsIterator from './TrailsIterator';

function Trails(props) {
  const { trails, setTrails } = props;

  return (
    <Wrapper>
      <Section>
        <ScheduleWrapper id="scroll" className="scroll-area">
          <Header>
            <Status>
              <div id="curr" />
            </Status>
          </Header>
          <Schedules>
            <TrailsIterator
              trails={trails}
              isUpdated={props.isUpdated}
              setIsUpdated={props.setIsUpdated}
            />
          </Schedules>
        </ScheduleWrapper>
      </Section>
    </Wrapper>
  );
}

export default Trails;

const Wrapper = styled.div`
  width: 100%;
  height: 70vh;
  display: flex;
  max-height: auto;
  flex-shrink: 2;
`;

const Section = styled.section`
  width: 100%;
  display: flex;
  justify-content: center;
  margin: 8px;
  padding: 10px;
  background-color: white;
  border-radius: 11px;
  box-shadow: 2px 5px 4px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
`;

const ScheduleWrapper = styled.div`
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

const EditIcon = styled(Edit)`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 20px;
  color: #007aff;
  opacity: 0.6;
  :hover {
    cursor: pointer;
    opacity: 1;
  }
`;

const Schedules = styled.div`
  width: 100%;
`;
