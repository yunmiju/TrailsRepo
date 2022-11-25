import { useContext } from 'react';
import { filterOne } from '../../context/ParkContext';

function Temp(props) {
  const { firstFilter, setFirstFilter } = useContext(filterOne);
  const { firstFilters } = props;
  console.log('....', firstFilters);

  const SelectBox = props => {
    const handleChange = e => {
      // event handler
      console.log(e.target.value);
    };
  };
  return 'qqq';
}

export default Temp;
