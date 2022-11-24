import React, { useState } from 'react';
import styled from 'styled-components';
import { EmailOutline } from '@styled-icons/evaicons-outline';
import Reservation from './Reservation';

function Program(props) {
  const token = localStorage.getItem('token');
  const { program } = props;
  const [programName, setContent] = useState(program?.programName || '');
  const [modal, setModal] = useState(false);
  const [contents, setContents] = useState(null);
  const [isUpdated, setIsUpdated] = useState(true);

  const onContentHandler = e => {
    setContent(e.currentTarget.value);
  };

  const openModal = () => {
    setModal(true);
  };

  return (
    <Wrapper>
      {modal && (
        <Reservation
          openModel={openModal}
          setModal={setModal}
          setContents={setContents}
          setIsUpdated={setIsUpdated}
          program={program}
        />
      )}
      <Section>
        <ScheduleWrapper>
          <Content>
            <ImageBox>
              <Img>
                <img alt="" src={program.imgURL} />
              </Img>
            </ImageBox>
            <Context>
              <TitleBox>
                <Title>
                  <span>{program.programName}</span>
                  <EmailIcon onClick={openModal} />
                </Title>
              </TitleBox>
              <DetailsBox>
                <Description>
                  <span>{program.description}</span>
                </Description>
                <Capacity>
                  <span>capacity : {program.capacity}</span>
                </Capacity>
              </DetailsBox>
            </Context>
          </Content>
        </ScheduleWrapper>
      </Section>
    </Wrapper>
  );
}

export default Program;

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

const ScheduleWrapper = styled.section`
  width: 100%;
  display: flex;
  justify-content: flex-start;
  flex-direction: column;
`;

const Content = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: flex-start;
  margin: 3px 0;
`;

const Context = styled.div`
  width: 100%;
  height: 100%;
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
`;

const ImageBox = styled.div`
  height: 300px;
  width: 500px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 10px;
  padding: 10px;
  div {
    margin: 0;
    padding: 0;
  }
`;

const Img = styled.div`
  margin: 10px;
  img {
    object-fit: fill;
    border-radius: 10%;
    border: grey;
    margin: 0;
  }
`;

const TitleBox = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  margin: 20px 0;
`;
const Title = styled.div`
  width: 100%;
  height: 40px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-weight: 700;
  font-size: 28px;
  color: #007aff;
`;

const DetailsBox = styled.div`
  width: 100%;
  height: 100%;
  padding: 10px 0;
  margin-bottom: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
`;

const Description = styled.div`
  width: 100%;
  height: 60px;
  border-radius: 13px;
  font-weight: 550;
  font-size: 15px;
  line-height: 1.5;
  padding-left: 5px;
`;

const Capacity = styled.div`
  width: 100%;
  height: 30px;
  display: flex;
  align-items: center;
  justify-content: flex-between;
  padding: 5px;
  border-radius: 13px;
  font-weight: 550;
  font-size: 13px;
`;

const EmailIcon = styled(EmailOutline)`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 30px;
  color: #007aff;
  opacity: 0.6;
  padding-right: 10px;
  :hover {
    cursor: pointer;
    opacity: 1;
  }
  z-index: 99;
`;
