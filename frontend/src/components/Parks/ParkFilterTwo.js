import React, { useContext, useEffect, useState } from 'react';
import { filterTwo, filterOne } from '../../context/ParkContext';
import ParksAll from '../../pages/Parks/Parks';
import axios from 'axios';
import BASE_URL from '../../config';

function ParkFilterTwo(props) {
  const { secondFilter, setSecondFilter } = useContext(filterTwo);
  const { secondFilters } = props;
  const firstFilter = useContext(filterOne);

  const handleChange = e => {
    setSecondFilter(e.target.value);
    console.log('second', e.target.value);
    console.log('**********', secondFilters);
  };

  return (
    <select id="secondFilter" onChange={handleChange}>
      <option>------</option>
      {secondFilters?.map(filter => (
        <option key={filter} value={filter}>
          {' '}
          {filter}
        </option>
      ))}
    </select>
  );
}

export default ParkFilterTwo;
