import React, { useContext, useEffect, useState } from 'react';
import axios from 'axios';
import BASE_URL from '../../config';
import styled from 'styled-components';
import 'react-slideshow-image/dist/styles.css';
import { Slide } from 'react-slideshow-image';

function ParkImage(props) {
  const { parkId } = props;
  const [image, setImage] = useState();

  const imageGetter = async () => {
    await axios
      .get(`${BASE_URL}/parks/image/${parkId}`)
      .then(response => {
        setImage(response.data);
      })
      .catch(e => console.log(e));
  };

  useEffect(() => {
    imageGetter();
  }, []);

  return (
    <Image>
      {image?.length > 0 ? (
        <img src={image[0]} />
      ) : (
        <img src={require('./trail.jpg')} />
      )}
    </Image>
  );
}

export default ParkImage;

const Image = styled.div`
  margin: 10px;
  height: 300px;
  img {
    object-fit: fill;
    border-radius: 10%;
    border: grey;
    margin: 0;
  }
`;
