import React, {
  useEffect,
  useContext,
  useMemo,
  useState,
  isValidElement,
} from 'react';

import axios from 'axios';
import styled from 'styled-components';
import 'flatpickr/dist/themes/material_green.css';
import Flatpickr from 'react-flatpickr';
import { CloseOutline } from '@styled-icons/evaicons-outline/CloseOutline';
import BASE_URL from '../../config';
import { currDate } from '../../utils/updateCurr';
import { ParkIdContext } from '../../App';
import ProgramsIterator from './ProgramsIterator';
import ReservationIterator from './ReservationIterator';

function Reservation({ openModal, setModal }) {
  const [reservationNumber, setReservationNumber] = useState('');
  const [parkId, setParkId] = useContext(ParkIdContext);
  const [edited, setEdited] = useState(false);
  const [found, setFound] = useState(false);
  const [date, setDate] = useState(currDate);
  const [email, setEmail] = useState('');
  const [ppl, setPpl] = useState(1);
  const [cond, setCond] = useState('');
  const [reservations, setReservations] = useState([]);
  const [reservation, setReservation] = useState();
  const [reservationInfo, setReservationInfo] = useState();
  const [programId, setProgramId] = useState('');
  const [programName, setProgramName] = useState('');
  const [isReservationNumValid, setReservationNumberValidity] = useState(false);
  const [isEmailValid, setEmailValidity] = useState(false);
  const [updateRequestObj, setUpdateRequestObj] = useState({});
  const [editedMsg, setEditedMsg] = useState('');
  const [deletedMsg, setDeletedMsg] = useState('');

  useEffect(() => {
    const obj = {
      email: email,
      ppl: ppl,
      programId: programId,
      reservationNumber: reservationNumber,
    };
    setUpdateRequestObj(obj);
  }, [email, ppl, programId, reservationNumber]);

  useEffect(() => {
    if (isReservationNumValid || isEmailValid) {
      searchReservationApi();
    }
  }, [cond]);

  useEffect(() => {
    //
  }, [reservation, email]);

  const searchReservationApi = async () => {
    const url = `${BASE_URL}/reservation/find${cond}`;
    await axios
      .get(url)
      .then(response => {
        setReservations(response.data);
        setReservation(response.data[0]);
        setEmail(response.data[0]['email']);
        setPpl(response.data[0]['ppl']);
        setProgramId(response.data[0]['programId']);
        setProgramName(response.data[0]['programName']);
        setFound(true);
      })
      .catch(error => {
        if (error.status === 'ERR_BAD_REQUEST') {
          setReservation([]);
        }
      });
  };

  const updateReservationApi = async () => {
    await axios
      .patch(`${BASE_URL}/reservation/update`, updateRequestObj)
      .then(response => {
        setReservation(response.data);
        setEditedMsg('updated');
        setEdited(true);
      })
      .catch(error => {
        console.log(error);
      });
  };

  const deleteReservationApi = async () => {
    await axios
      .put(`${BASE_URL}/reservation/delete/${reservationNumber}`)
      .then(response => {
        setEditedMsg('Your reservation has been Canceled');
        setEdited(true);
      })
      .catch(error => {
        console.log(error);
      });
  };

  function isValid(obj) {
    return Object.values(obj).every(
      el => el !== undefined && el !== '' && el !== null
    );
  }

  function generateCond(obj) {
    return true;
  }

  const onEditHandler = async e => {
    if (isValid(updateRequestObj) && found) {
      await updateReservationApi();
      setReservationNumber(reservationNumber);
    }
  };

  const onDeleteHandler = async e => {
    if (isValid(updateRequestObj) && found) {
      await deleteReservationApi();
    }
  };

  const onSearchHandler = async () => {
    console.log('searchhandler');
    if (isReservationNumValid) {
      setCond(`?reservationNumber=${reservationNumber}`);
    } else if (isEmailValid) {
      console.log('searchhandler emails');
      setCond(`?email=${email}`);
    }
  };

  const onEmailHandler = e => {
    setEmail(e.currentTarget.value);
  };
  const onReservationNumberHandler = e => {
    if (e.currentTarget.value.length < 8) {
      setReservationNumber(e.currentTarget.value);
    }
  };

  const onCloseHandler = async () => {
    if (edited && found) {
      setFound(false);
      setEdited(false);
      setModal(false);
    }
  };
  const onPplHandler = e => {
    setPpl(e.currentTarget.value);
  };
  useMemo(() => {
    let text = reservationNumber.replace(/\s/g, '');
    let pattern = /^\d{7}$/;
    pattern.test(text)
      ? setReservationNumberValidity(true)
      : setReservationNumberValidity(false);
  }, [reservationNumber]);

  useMemo(() => {
    let text = email.replace(/\s/g, '');
    let pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    pattern.test(text) ? setEmailValidity(true) : setEmailValidity(false);
  }, [email]);
  return (
    <>
      <Overlay
        onClick={() => {
          setModal(false);
        }}
      />
      <ModalWrapper>
        <ModalBox>
          <SectionRow>
            <Header>Reservation</Header>
            <Close
              onClick={() => {
                setModal(false);
              }}
            >
              <CloseIcon />
            </Close>
          </SectionRow>
          {edited ? (
            <InnerBox>{editedMsg}</InnerBox>
          ) : (
            <InnerBox>
              <Section>{date}</Section>
              <Section>
                <SocialLine />
                <Title># Reservation Number</Title>
                <EditContainer>
                  <EditInput
                    type="text"
                    value={reservationNumber}
                    placeholder={reservationNumber}
                    pattern="^\d{7}$"
                    maxLegnth="7"
                    autoComplete="cc-number"
                    onChange={onReservationNumberHandler}
                  />
                </EditContainer>
              </Section>
              <Section>
                <SocialLine />
                <Title>Email</Title>
                <EditContainer>
                  <EditInput
                    type="content"
                    value={email}
                    onChange={onEmailHandler}
                  />
                </EditContainer>
              </Section>
              {found && reservations.length === 1 ? (
                <>
                  <Section>
                    <SocialLine />
                    <Title># PROGRAM NAME #</Title>
                    <EditContainer>
                      <ProgramName>{programName}</ProgramName>
                    </EditContainer>
                  </Section>
                  <Section>
                    <SocialLine />
                    <Title>Group Size</Title>
                    <EditContainer>
                      <EditInput
                        type="number"
                        value={ppl}
                        placeholder="1"
                        min="1"
                        max="10"
                        onChange={onPplHandler}
                      />
                    </EditContainer>
                  </Section>
                </>
              ) : reservations.length > 1 ? (
                <ReservationIterator reservations={reservations} />
              ) : (
                <></>
              )}
              <Section>
                <SocialLine />
              </Section>
            </InnerBox>
          )}
          {!found && !edited ? (
            <CloseOpt>
              <Search
                onClick={() => {
                  onSearchHandler();
                }}
              >
                SEARCH
              </Search>
            </CloseOpt>
          ) : found && !edited ? (
            <CloseOptContainer>
              <CloseOpt>
                <Search
                  onClick={() => {
                    onEditHandler();
                  }}
                >
                  EDIT
                </Search>
              </CloseOpt>
              <CloseOpt>
                <Search
                  onClick={() => {
                    onDeleteHandler();
                  }}
                >
                  DELETE
                </Search>
              </CloseOpt>
            </CloseOptContainer>
          ) : (
            <CloseOpt>
              <Search
                onClick={() => {
                  onCloseHandler();
                }}
              >
                CLOSE
              </Search>
            </CloseOpt>
          )}
        </ModalBox>
      </ModalWrapper>
    </>
  );
}
export default Reservation;
const Overlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 99;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
`;
const ModalWrapper = styled.div`
  width: 460px;
  border-radius: 10px;
  background-color: white;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 99;
  padding: 30px;
  display: flex;
  flex-direction: column;
  align-items: center;
  box-shadow: 2px 5px 14px 0 rgba(0, 0, 0, 0.2),
    9px 6px 20px 0 rgba(0, 0, 0, 0.19);
`;

const ModalBox = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
`;

const InnerBox = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  background-color: #f2f2f2;
  outline: none;
  border: transparent;
  border-radius: 15px;
  padding: 20px 10px;
  margin-top: 15px;
`;
const EditContainer = styled.div`
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: stretch;
  padding: 0 10px;
`;

const ProgramName = styled.div`
  flex: 1;
  width: 50%;
  height: 50px;
  padding: 13px 12px;
  margin-top: 12px;
  margin-bottom: 12px;
  outline: none;
  border: transparent;
  border-radius: 15px;
  background-color: white;
  :focus {
  }
  color: black;
  :hover {
    cursor: arrow;
  }
`;

const EditInput = styled.input`
  flex: 1;
  width: 50%;
  height: 50px;
  padding: 13px 12px;
  margin-top: 12px;
  margin-bottom: 12px;
  outline: none;
  border: transparent;
  border-radius: 15px;
  background-color: white;
  :focus {
  }
`;

const Section = styled.div`
  width: 100%;
`;

const SocialLine = styled.hr`
  position: relative;
  top: 7.5px;
  margin: 0;
  width: 90%;
  height: 1px;
  background-color: #f1f3f5;
  border: none;
  display: block;
  z-index: -1;
`;
const SectionRow = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  align-content: center;
`;
const Header = styled.span`
  display: flex;
  align-item: center;
  padding: 0 8px;
  font-size: 30px;
  font-weight: bold;
  color: #6a6969;
  z-index: 1;
  background-color: #fff;
`;
const Title = styled.span`
  margin-bottom: 12px;
  padding: 0 13px;
  font-size: 16px;
  font-weight: bold;
  line-height: 1.6;
  color: #007aff;
  z-index: 1;
`;

const CloseOpt = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;
  padding: 0 10px;
  padding-top: 20px;
`;

const CloseOptContainer = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;
`;

const Close = styled.span`
  display: flex;
  justify-content: flex-end;
  padding: 10px 10px;
  cursor: pointer;
`;

const Search = styled.span`
  background-color: #007aff;
  color: white;
  padding: 10px;
  border-radius: 15px;
  cursor: pointer;
`;

const CloseIcon = styled(CloseOutline)`
  margin-left: auto;
  width: 20px;
`;
const SaveIcon = styled(CloseOutline)`
  margin-left: auto;
  width: 20px;
`;
