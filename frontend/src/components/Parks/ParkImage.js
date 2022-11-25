import { useContext, useEffect, useState } from 'react';
import axios from 'axios';
import BASE_URL from '../../config';
import styled from 'styled-components';

function ParkImage(props) {
  const { parkId } = props;
  const [image, setImage] = useState();
  // console.log(parkId);

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
    // console.log('length', image?.length);
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
