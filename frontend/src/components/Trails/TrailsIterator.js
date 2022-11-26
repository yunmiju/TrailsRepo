import React from 'react';
import styled from 'styled-components';
import Trail from './Trail';
import TrailEmpty from './TrailEmpty';
function TrailsIterator(props) {
  const { trails } = props;

  return (
    <Wrapper>
      <Section>
        <ScheduleWrapper>
          {trails?.length > 0 ? (
            trails?.map((trail, idx) => (
              <Trail
                key={idx}
                trail={trail}
                isUpdated={props.isUpdated}
                setIsUpdated={props.setIsUpdated}
              />
            ))
          ) : (
            <TrailEmpty />
          )}
        </ScheduleWrapper>
      </Section>
    </Wrapper>
  );
}

export default TrailsIterator;

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
