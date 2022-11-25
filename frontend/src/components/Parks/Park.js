import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import ParkImage from './ParkImage';
import axios from 'axios';
import BASE_URL from '../../config';
import AdditionalData from './AdditionalData';
function Park(props) {
  const { park } = props;
  const [provinceName, setProvinceName] = useState();
  const [countryName, setCountryName] = useState();
  // console.log('provinceId', park.provinceId);

  const provinceGetter = async () => {
    await axios
      .get(`${BASE_URL}/parks/provinceName/${park.provinceId}`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
      })
      .then(response => {
        setProvinceName(response.data);
        // console.log(provinceName);
        countryGetter();
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
        // console.log(park.campingSite);
      })
      .catch(e => console.log(e));
  };

  useEffect(() => {
    provinceGetter();
  }, []);

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
              <span className="val">{provinceName}</span>
            </Details>
          </Context>
        </Content>
      </Section>
    </Wrapper>
  );
}

const Wrapper = styled.div`
  width: 100%;
  display: flex;
`;

const Section = styled.section`
  width: 100%;
  display: flex;
`;

const Content = styled.div`
  width: 100%;
  display: flex;
  flex-direction: row;
`;

const Context = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
`;

const ImageBox = styled.div`
  width: 60%;
  display: flex;
  flex-direction: column;
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
    padding-top: 15px;
    font-size: 28px;
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

export default Park;
