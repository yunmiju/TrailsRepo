import React from 'react';
import styled from 'styled-components';
import ReservationSearched from './ReservationSearched';
function ReservationIterator(props) {
  const { reservations } = props;

  return (
    <Wrapper>
      <Section>
        <ScheduleWrapper>
          {reservations?.map((reservation, idx) => (
            <ReservationSearched key={idx} reservation={reservation} />
          ))}
        </ScheduleWrapper>
      </Section>
    </Wrapper>
  );
}

export default ReservationIterator;

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
