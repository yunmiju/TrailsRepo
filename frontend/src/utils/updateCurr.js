import moment from 'moment';

const current = moment();
export const currDate = current.format('YYYY-MM-DD');
const currStatus = currTime => {
  let str;
  switch (true) {
    case currTime >= 0 && currTime < 4:
      str = 'EARLY BIRD';
      break;
    case currTime > 6 && currTime <= 12:
      str = 'MORNING';
      break;
    case currTime > 12 && currTime <= 18:
      str = 'AFTERNOON';
      break;
    case currTime > 18 && currTime < 24:
      str = 'EVENING';
      break;
    default:
      str = 'NIGHT OWL';
  }
  return str;
};

export const updateDateTime = () => {
  let date = document.getElementById('date');
  let time = document.getElementById('time');
  if (date !== null) date.innerHTML = moment().format('MMM DD');
  if (time !== null) time.innerHTML = moment().format('HH:mm A');
};

export const updateStatus = () => {
  let str = currStatus(current.hour());
  let curr = document.getElementById('curr');
  if (curr !== null) curr.innerHTML = str;
};
