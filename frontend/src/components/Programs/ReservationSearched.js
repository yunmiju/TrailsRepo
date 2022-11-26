import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { EmailOutline } from '@styled-icons/evaicons-outline';
import { Delete } from '@styled-icons/fluentui-system-filled';
import Reservation from './Reservation';
import BASE_URL from '../../config';
import axios from 'axios';

function ReservationSearched(props) {
  const { reservation } = props;

  return (
    <Section>
      <SocialLine />
      <Title># PROGRAM NAME #</Title>
      <EditContainer>
        <ProgramName>{reservation.programName}</ProgramName>
      </EditContainer>
    </Section>
  );
}

export default ReservationSearched;

const Section = styled.div`
  width: 100%;
`;
const Title = styled.span`
  margin-bottom: 12px;
  padding: 0 13px;
  font-size: 16px;
  font-weight: bold;
  line-height: 1.6;
  color: #007aff;
  z-index: 1;
`;

const EditContainer = styled.div`
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: stretch;
  padding: 0 10px;
`;

const ProgramName = styled.div`
  flex: 1;
  width: 50%;
  height: 20px;
  padding: 13px 12px;
  margin-top: 12px;
  margin-bottom: 12px;
  outline: none;
  border: transparent;
  border-radius: 15px;
  background-color: white;
  :focus {
  }
  color: black;
  :hover {
    cursor: arrow;
  }
`;

const SocialLine = styled.hr`
  position: relative;
  top: 7.5px;
  margin: 0;
  width: 90%;
  height: 1px;
  background-color: #f1f3f5;
  border: none;
  display: block;
  z-index: -1;
`;
