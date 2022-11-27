import React, { useState, useEffect } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPersonHiking, faMountain } from '@fortawesome/free-solid-svg-icons';
import styled from 'styled-components';
import ParkImage from './ParkImage';
import axios from 'axios';
import BASE_URL from '../../config';
function Park(props) {
  const { park } = props;
  const [provinceName, setProvinceName] = useState();
  const [countryName, setCountryName] = useState();
  const [provinceCount, setProvinceCount] = useState({ BC: 0 });

  const provinceGetter = async () => {
    await axios
      .get(`${BASE_URL}/parks/provinceName/${park.provinceId}`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        setProvinceName(response.data);
        provinceCountGetter();
      })
      .catch(e => console.log(e));
  };

  const countryGetter = async () => {
    await axios
      .get(`${BASE_URL}/parks/countryName/${park.provinceId}`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        setCountryName(response.data);
        // provinceCountGetter();
      })
      .catch(e => console.log(e));
  };

  useEffect(() => {
    provinceGetter();
  }, []);

  const provinceCountGetter = async () => {
    await axios
      .get(`${BASE_URL}/parks/filter/count/${park.provinceId}`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        setProvinceCount(response.data);
        console.log(response.data);
        countryGetter();
      })
      .catch(e => console.log(e));
  };

  return (
    <Wrapper>
      <Section>
        <Content>
          <ImageBox>
            <ParkImage parkId={park.id} />
          </ImageBox>
          <Context>
            <TitleBox>
              <Title>
                <span>{park.parkName}</span>
              </Title>
              <Additional>
                {park.permitType !== 'NULL' ? (
                  <span className="key">
                    Permit Type: {park.permitType}, dailyCapacity:{' '}
                    {park.dailyCapacity}
                  </span>
                ) : (
                  <span className="key">{`Camping Site: ${park.campingSite}`}</span>
                )}
              </Additional>
            </TitleBox>
            <DetailsBox>
              <Details>
                <span className="key">ADDRESS:</span>
                <span className="val">{park.parkAddress}</span>
                <span className="key">OPEN: </span>
                <span className="val">
                  {park.openHour} - {park.closeHour}
                </span>
                <span className="key">Country: </span>
                <span className="val">{countryName}</span>
                <span className="key">Province: </span>
                <span className="val">
                  {provinceName} : (curruntly registered {`${provinceCount}`})
                </span>
              </Details>
              <ButtonDetails>
                <Button
                  onClick={() =>
                    (window.location.href = `/park/${park.id}/programs`)
                  }
                  variant="contained"
                  disableElevation
                >
                  Browse Programs
                  <FontAwesomeIcon
                    icon={faPersonHiking}
                    size="2x"
                    className="hover:text-red-500"
                    shake
                  />
                </Button>
                <Button
                  onClick={() =>
                    (window.location.href = `/park/${park.id}/trails`)
                  }
                  variant="contained"
                  disableElevation
                >
                  Browse Trails
                  <FontAwesomeIcon
                    icon={faMountain}
                    size="2x"
                    className="hover:text-red-500"
                    shake
                  />
                </Button>
              </ButtonDetails>
            </DetailsBox>
          </Context>
        </Content>
      </Section>
    </Wrapper>
  );
}

const Button = styled.button`
  margin: 5px;
  border: none;
  width: 60%;
  justify-content: center;
  cursor: pointer;
  font-family: 'Source-Sans-Pro', sans-serif;
  font-size: var(--button-font-size, 1rem);
  padding: var(--button-padding, 12px 16px);
  border-radius: var(--button-radius, 8px);
  background: var(--button-bg-color, #b6b6b6);
  color: var(--button-color, #ffffff);

  &:active,
  &:hover,
  &:focus {
    background: var(--button-hover-bg-color, #23aeab);
  }
  &:disabled {
    cursor: default;
    opacity: 0.5;
    background: var(--button-bg-color, #025ce2);
  }
`;

const Wrapper = styled.div`
  width: 100%;
  display: flex;
  margin-bottom: 50px;
`;

const Section = styled.section`
  width: 100%;
  display: flex;
`;

const Content = styled.div`
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-contents: center;
  align-items: center;
`;

const Context = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
`;

const ImageBox = styled.div`
  width: 60%;
  margin-right: 40px;
  display: flex;
  flex-direction: column;
  justify-contents: center;
  align-items: center;
`;

const TitleBox = styled.div`
  width: 100%;
  display: flex;
  flex-direction: row;
`;

const Title = styled.title`
  width: 100%;
  display: flex;
  flex-direction: column;
  span {
    font-size: 28px;
    color: #05638e;
    font-weight: 600;
  }
`;

const Additional = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  span {
    padding-top: 10px;
    font-size: 14px;
    font-weight: 600;
  }
`;

const DetailsBox = styled.div`
  width: 100%;
  display: flex;
  flex-direction: row;
  span.key {
    padding-top: 20px;
    font-size: 18px;
    font-weight: 700;
  }
  span.val {
    padding-top: 5px;
    font-size: 15px;
    font-weight: 500;
  }
`;

const Details = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  span.key {
    padding-top: 20px;
    font-size: 18px;
    font-weight: 700;
  }
  span.val {
    padding-top: 5px;
    font-size: 15px;
    font-weight: 500;
  }
`;

const ButtonDetails = styled.div`
  margin-top: 10px;
  width: 100%;
  height: 70%;
  display: flex;
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
`;

export default Park;
