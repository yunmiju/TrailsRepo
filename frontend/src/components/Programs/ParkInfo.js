import React, { useState } from 'react';
import styled from 'styled-components';
import Reservation from './Reservation';

import BASE_URL from '../../config';

function ParkInfo(props) {
  const { park, setPark } = props;
  const [modal, setModal] = useState(false);
  const [contents, setContents] = useState(null);
  const [isUpdated, setIsUpdated] = useState(true);

  const openModal = () => {
    setModal(true);
  };

  let scrollArea = document.getElementById('scroll');
  const {
    parkName,
    parkAddress,
    centerAddress,
    centerName,
    countryName,
    email,
    openHours,
    closeHours,
    permitType,
    campingSite,
    provinceName,
    programNums,
  } = park;
  const parkType =
    permitType !== undefined && permitType !== null
      ? 'Restricted Park ' + permitType
      : campingSite !== undefined
      ? 'Public Park : Camping ' + (campingSite ? 'Allowed' : 'Not Allowed')
      : '';
  return (
    <Wrapper>
      {modal && (
        <Reservation
          openModel={openModal}
          setModal={setModal}
          setContents={setContents}
          setIsUpdated={setIsUpdated}
        />
      )}
      {park && (
        <Section>
          <ParkWrapper>
            <Header>
              <ParkName>
                <Info>
                  <span>{parkName}</span>
                </Info>
              </ParkName>
            </Header>
            <Information>
              <ParkType>
                <Info>
                  <span>{parkType}</span>
                </Info>
              </ParkType>
              <Location>
                <Info>
                  <p>{parkAddress}</p>
                  <p>
                    {provinceName} {countryName}
                  </p>
                </Info>
              </Location>
              <VisitorCenter>
                <Info>
                  <p>Visitor Center:</p>
                  <p>{centerName}</p>
                  <p>Address:</p>
                  <p>{centerAddress}</p>
                  <p>email:</p>
                  <p>{email}</p>
                  <p># of Program Offered</p>
                  <p>{programNums}</p>
                </Info>
              </VisitorCenter>
            </Information>
          </ParkWrapper>
        </Section>
      )}
    </Wrapper>
  );
}

export default ParkInfo;

const Wrapper = styled.div`
  min-width: 400px;
  max-width: 400px;
  display: flex;
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

const ParkWrapper = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  flex-direction: column;
`;

const Information = styled.div`
  width: 100%;
  height: 100%
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 10px;
`;

const Location = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 15px;
  margin-bottom: 30px;
`;

const ParkType = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 15px;
  margin-bottom: 30px;
`;

const VisitorCenter = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Header = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const ParkName = styled.h1`
  text-align: left;
  font-weight: 700;
  font-size: 30px;
  padding: 20px 10px;
`;

const Info = styled.div`
  width: 100%;
  display: flex;
  align-items: flex-start;
  justify-content: center;
  flex-direction: column;
  p {
    margin: 10px 0;
  }
  & p:nth-child(odd) {
    font-weight: 600;
  }
`;
