import React from 'react';
import styled from 'styled-components';
import Program from './Program';
import ProgramEmpty from './ProgramEmpty';
function ProgramsIterator(props) {
  const { programs } = props;

  return (
    <Wrapper>
      <Section>
        <ScheduleWrapper>
          {programs?.length > 0 ? (
            programs?.map(program => (
              <Program
                key={program.id}
                program={program}
                isUpdated={props.isUpdated}
                setIsUpdated={props.setIsUpdated}
              />
            ))
          ) : (
            <ProgramEmpty />
          )}
        </ScheduleWrapper>
      </Section>
    </Wrapper>
  );
}

export default ProgramsIterator;

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
