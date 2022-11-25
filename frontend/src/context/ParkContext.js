import { createContext } from 'react';
import axios from 'axios';
import BASE_URL from '../config';

export const parkContext = createContext(null);
export const filterOne = createContext(null);
export const filterTwo = createContext(null);
export const parkCount = createContext(null);

// const parkSetter = async () => {
//   await axios
//     .get(`${BASE_URL}/parks/`, {
//       headers: {
//         'Access-Control-Allow-Origin': '*',
//       },
//     })
//     .then(response => {
//       setParks(response.data);
//       console.log('data', parks);
//     })
//     .catch(error => {
//       console.log(error);
//     });
// };
