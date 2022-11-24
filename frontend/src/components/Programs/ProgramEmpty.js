import React from 'react';
import styled from 'styled-components';

function ProgramEmpty(props) {
  return (
    <Wrapper>
      <Section>
        <ContentWrapper>
          <Content>
            <span>PROGRAM WILL BE ADDED SOON</span>
          </Content>
        </ContentWrapper>
      </Section>
    </Wrapper>
  );
}

export default ProgramEmpty;

const Wrapper = styled.div`
  width: 100%;
  display: flex;
`;

const Section = styled.section`
  width: 100%;
  display: flex;
  justify-content: center;
  padding: 10px;
`;

const ContentWrapper = styled.section`
  width: 100%;
  display: flex;
  justify-content: flex-start;
  flex-direction: column;
`;

const Content = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 3px 0;
  font-size: 30px;
  font-weight: 700px;
`;
