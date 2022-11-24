import React from 'react';
import styled from 'styled-components';

function Header() {
  return (
    <HeaderContainer>
      <HeaderWrapper>
        <HeaderInfo>
          <Name>
            <span>" HELLO "</span>
          </Name>
          <Img></Img>
        </HeaderInfo>
      </HeaderWrapper>
    </HeaderContainer>
  );
}

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
`;

const HeaderInfo = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;
  padding: 0 2px;
`;

const Name = styled.div`
  margin: 0 10px;
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
