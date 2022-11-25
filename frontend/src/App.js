import { createContext, useState } from 'react';
import './App.css';
import Router from './Router';
export const ParkIdContext = createContext({
  parkId: -1,
  setParkId: () => {},
});

function App() {
  const parkIdState = useState(-1);
  return (
    <ParkIdContext.Provider value={parkIdState}>
      <Router />
    </ParkIdContext.Provider>
  );
}

export default App;
