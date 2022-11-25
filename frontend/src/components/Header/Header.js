import React from 'react';
import styled from 'styled-components';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPersonHiking, faMountain } from '@fortawesome/free-solid-svg-icons';

function Header() {
  return (
    <HeaderContainer>
      <HeaderWrapper>
        <Logo>
          <FontAwesomeIcon
            icon={faPersonHiking}
            size="2x"
            className="hover:text-red-500"
          />
        </Logo>
        <HeaderInfo>
          <Name>
            <FontAwesomeIcon
              icon={faMountain}
              size="2x"
              className="hover:text-red-500"
            />
            <span> WELLCOME TO TRAILS REPO </span>
          </Name>
          <Img />
        </HeaderInfo>
      </HeaderWrapper>
    </HeaderContainer>
  );
}

const Logo = styled.div`
  display: flex;
  color: #9c5618;
  align-self: flex-end;
  align-items: center;
  padding: 0 2px 0 50px;
`;

const HeaderContainer = styled.div`
  width: 100%;
  margin: 1px auto auto;
  display: flex;
  align-items: center;
  background-color: #f9f9f9;
`;

const HeaderWrapper = styled.div`
  width: 100%;
  margin: auto auto;
  margin: 20px;
  display: flex;
  justify-content: space-between;
`;

const HeaderInfo = styled.div`
  display: flex;
  align-items: center;
  padding: 0 2px;
`;

const Name = styled.div`
  margin: 0 10px;
  color: #b6661f;
  span {
    font-size: 20px;
    font-weight: 700;
  }
`;
const Img = styled.div`
  margin: 0 10px;
  img {
    height: 30px;
    border-radius: 50%;
    border: grey;
  }
`;
export default Header;
