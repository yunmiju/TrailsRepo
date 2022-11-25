import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

import styled from 'styled-components';
import { Home } from '@styled-icons/boxicons-regular';
import { PatchQuestion } from '@styled-icons/bootstrap/PatchQuestion';
import EditReservation from '../Programs/EditReservation';
import { ParkIdContext } from '../../App';

function Footer() {
  const navigate = useNavigate();
  const [modal, setModal] = useState(false);

  const openModal = () => {
    setModal(true);
  };
  const goToHome = () => {
    navigate('/');
  };

  return (
    <FooterContainer>
      {modal && <EditReservation openModel={openModal} setModal={setModal} />}
      <FooterWrapper>
        <FooterBox>
          <div>
            <FooterIcon>
              <PatchQuestion onClick={openModal} />
            </FooterIcon>
            <IconTitle>Search</IconTitle>
          </div>
          <div>
            <FooterIcon>
              <Home onClick={goToHome} />
            </FooterIcon>
            <IconTitle>Home</IconTitle>
          </div>
        </FooterBox>
      </FooterWrapper>
    </FooterContainer>
  );
}

const FooterContainer = styled.div`
  background: #f2f2f2;
  margin-bottom: 0;
  padding: 5px;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  height: 110px;
`;

const FooterWrapper = styled.div`
  width: 100%;
  margin: auto auto;
`;

const FooterBox = styled.div`
  display: flex;
  justify-content: flex-end;
  padding: 20px;
  margin-right: 20px;
  div {
    margin: 0 15px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    opacity: 0.5;
    :hover {
      opacity: 1;
      cursor: pointer;
    }
    :active {
      opacity: 1;
    }
  }
`;

const FooterIcon = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 30px;
  height: 30px;
  color: black;
`;

const IconTitle = styled.span`
  text-align: center;
  background-color: none;
  font-size: 15px;
  color: black;
  padding-top: 10px;
  padding-bottom: 2px;
`;

export default Footer;
