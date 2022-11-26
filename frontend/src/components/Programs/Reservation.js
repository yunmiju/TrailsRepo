import React, { useContext, useEffect, useState } from 'react';
import moment from 'moment';

import axios from 'axios';
import styled from 'styled-components';
import 'flatpickr/dist/themes/material_green.css';
import Flatpickr from 'react-flatpickr';
import { CloseOutline } from '@styled-icons/evaicons-outline/CloseOutline';
import BASE_URL from '../../config';
import { currDate } from '../../utils/updateCurr';
import { ParkIdContext } from '../../App';

function Reservation({ openModal, setModal, setContents, program }) {
  const [reservationNumber, setReservationNumber] = useState(null);
  const [reserved, setReserved] = useState(false);
  const [date, setDate] = useState(currDate);
  const [email, setEmail] = useState('');
  const [ppl, setPpl] = useState(1);
  const request = {
    programId: program.id,
    email: email,
    ppl: ppl || 1,
  };

  const addReservationApi = async () => {
    await axios
      .post(`${BASE_URL}/reservation/save`, request)
      .then(response => {
        setReservationNumber(response.data);
        setReserved(true);
      })
      .catch(error => {
        console.log(error);
      });
  };

  function isValid(obj) {
    return Object.values(obj).every(
      el => el !== undefined && el !== '' && el !== null
    );
  }

  const onSaveHandler = async e => {
    if (isValid(request) && !reserved) {
      await addReservation();
      setContents(reservationNumber);
    }
    if (reserved) {
      setReserved(false);
      setModal(false);
    }
  };

  const addReservation = async () => {
    await addReservationApi();
  };
  const onEmailHandler = e => {
    setEmail(e.currentTarget.value);
  };
  const onPplHandler = e => {
    setPpl(e.currentTarget.value);
  };
  return (
    <>
      <Overlay
        onClick={() => {
          setModal(false);
        }}
      />
      <ModalWrapper>
        <ModalBox>
          <SectionRow>
            <Header>{reserved ? 'Reservation Number' : 'Reservation'}</Header>
            <Close
              onClick={() => {
                setModal(false);
              }}
            >
              <CloseIcon />
            </Close>
          </SectionRow>
          {reserved ? (
            <InnerBox>{reservationNumber}</InnerBox>
          ) : (
            <InnerBox>
              <Section>{date}</Section>
              <Section>
                <SocialLine />
                <Title>Program</Title>
                <EditContainer>
                  <ProgramName>{program.programName}</ProgramName>
                </EditContainer>
              </Section>
              <Section>
                <SocialLine />
                <Title>Email</Title>
                <EditContainer>
                  <EditInput
                    type="content"
                    value={email}
                    onChange={onEmailHandler}
                  />
                </EditContainer>
              </Section>
              <Section>
                <SocialLine />
                <Title>Group Size</Title>
                <EditContainer>
                  <EditInput
                    type="number"
                    value={ppl}
                    placeholder="1"
                    min="1"
                    max="10"
                    onChange={onPplHandler}
                  />
                </EditContainer>
              </Section>
              <Section>
                <SocialLine />
              </Section>
            </InnerBox>
          )}
          <CloseOpt>
            <Save
              onClick={() => {
                onSaveHandler();
              }}
            >
              {reserved ? 'CLOSE' : 'RESERVE'}
            </Save>
          </CloseOpt>
        </ModalBox>
      </ModalWrapper>
    </>
  );
}
export default Reservation;
const Overlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 99;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
`;
const ModalWrapper = styled.div`
  width: 460px;
  border-radius: 10px;
  background-color: white;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 99;
  padding: 30px;
  display: flex;
  flex-direction: column;
  align-items: center;
  box-shadow: 2px 5px 14px 0 rgba(0, 0, 0, 0.2),
    9px 6px 20px 0 rgba(0, 0, 0, 0.19);
`;

const ModalBox = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
`;

const InnerBox = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  background-color: #f2f2f2;
  outline: none;
  border: transparent;
  border-radius: 15px;
  padding: 20px 10px;
  margin-top: 15px;
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
  height: 50px;
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

const EditInput = styled.input`
  flex: 1;
  width: 50%;
  height: 50px;
  padding: 13px 12px;
  margin-top: 12px;
  margin-bottom: 12px;
  outline: none;
  border: transparent;
  border-radius: 15px;
  background-color: white;
  :focus {
  }
`;

const Section = styled.div`
  width: 100%;
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
const SectionRow = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  align-content: center;
`;
const Header = styled.span`
  display: flex;
  align-item: center;
  padding: 0 8px;
  font-size: 30px;
  font-weight: bold;
  color: #6a6969;
  z-index: 1;
  background-color: #fff;
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

const CloseOpt = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;
  padding: 0 10px;
  padding-top: 20px;
`;

const Close = styled.span`
  display: flex;
  justify-content: flex-end;
  padding: 10px 10px;
  cursor: pointer;
`;

const Save = styled.span`
  background-color: #007aff;
  color: white;
  padding: 10px;
  border-radius: 15px;
  cursor: pointer;
`;
const CloseIcon = styled(CloseOutline)`
  margin-left: auto;
  width: 20px;
`;
