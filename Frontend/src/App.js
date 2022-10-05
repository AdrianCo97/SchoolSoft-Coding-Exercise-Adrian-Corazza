import { useState } from "react";
import { Alert, Button, Collapse, Grid, TextField } from "@mui/material";
import "./App.css";

function App() {
  const [users, setUsers] = useState({ userData: [], gotUserData: false });
  const [reverseString, setReverseString] = useState({
    input: "",
    result: "",
    dataSent: false,
  });
  const [isPalindrome, setIsPalindrome] = useState({
    input: "",
    palindrome: false,
    dataSent: false,
  });
  const [paddedNumber, setPaddedNumber] = useState({
    input: "",
    result: "",
    dataSent: false,
  });
  const [numbersListInput, setNumbersListInput] = useState(0);
  const [nthLargestNumber, setNthLargestNumber] = useState({
    numbers: [],
    nthLargestNumber: 0,
    result: null,
  });

  const getUserData = () => {
    fetch("http://localhost:8081/api/methods/userswithreversednames").then(
      (response) => {
        if (response.ok) {
          response.json().then((data) => {
            setUsers({ userData: data, gotUserData: !users.gotUserData });
          });
        }
      }
    );
  };

  const sendStringToReverse = (e) => {
    e.preventDefault();
    fetch("http://localhost:8081/api/methods/reversestring", {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: new URLSearchParams({ string: reverseString.input }),
    })
      .then((response) => response.text())
      .then((data) =>
        setReverseString({ ...reverseString, result: data, dataSent: true })
      );
  };

  const sendStringToCheckIfPalindrome = (e) => {
    e.preventDefault();
    fetch("http://localhost:8081/api/methods/ispalindrome", {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: new URLSearchParams({ string: isPalindrome.input }),
    })
      .then((response) => response.json())
      .then((data) =>
        setIsPalindrome({ ...isPalindrome, palindrome: data, dataSent: true })
      );
  };

  const sendNumberToAddZeroes = (e) => {
    e.preventDefault();
    fetch("http://localhost:8081/api/methods/padnumberwithzeroes", {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: new URLSearchParams({ number: paddedNumber.input }),
    })
      .then((response) => response.text())
      .then((data) =>
        setPaddedNumber({ ...paddedNumber, result: data, dataSent: true })
      );
  };

  const findNthLargestNumber = (e) => {
    e.preventDefault();
    let params = new URLSearchParams();
    nthLargestNumber.numbers.forEach((number) => {
      params.append("numbers", number);
    });
    params.append("nthlargestnumber", nthLargestNumber.nthLargestNumber);

    fetch("http://localhost:8081/api/methods/findnthlargestnumber", {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: params,
    })
      .then((response) => response.json())
      .then((data) =>
        setNthLargestNumber({ ...nthLargestNumber, result: data })
      );
  };

  const handleReverseStringInput = (e) => {
    setReverseString({
      ...reverseString,
      dataSent: false,
      input: e.target.value,
    });
  };

  const handleIsPalindromInput = (e) => {
    setIsPalindrome({
      ...isPalindrome,
      input: e.target.value,
      dataSent: false,
    });
  };

  const handlePaddedNumbersInput = (e) => {
    setPaddedNumber({
      ...isPalindrome,
      input: e.target.value,
      dataSent: false,
    });
  };

  const addNumberToList = () => {
    let tempArray = nthLargestNumber.numbers;
    tempArray.push(numbersListInput);
    setNthLargestNumber({ ...nthLargestNumber, numbers: tempArray });
  };

  return (
    <div>
      <div className="content-body">
        <h2>SchoolSoft coding Test</h2>
        <div className="content-body-main">
          <h3>ReverseUserNames</h3>
          <Button
            variant="contained"
            sx={{ width: 200, margin: "auto", mb: 3 }}
            onClick={() => {
              getUserData();
            }}
          >
            Obtain user Data
          </Button>
          <Collapse in={users.gotUserData} sx={{ mb: 2 }}>
            <div className="users-list">
              {users.userData.map((data) => {
                return (
                  <div className="user-data">
                    <p>Reversed firstname: {data.firstname}</p>
                    <p>Lastname: {data.lastname}</p>
                    <p>Username: {data.username}</p>
                    <p>Age: {data.age}</p>
                  </div>
                );
              })}
            </div>
          </Collapse>
          <hr />
          <h3>ReverseString</h3>
          <form onSubmit={(e) => sendStringToReverse(e)} className="input-form">
            <TextField
              variant="outlined"
              label="ReverseString"
              onChange={(e) => {
                handleReverseStringInput(e);
              }}
              sx={{ width: 400, mb: 2 }}
            />
            <Button
              type="submit"
              variant="contained"
              sx={{ width: 400, mb: 2 }}
            >
              Reverse
            </Button>
            <Collapse in={reverseString.dataSent}>
              <p>{reverseString.result}</p>
            </Collapse>
          </form>

          <form
            className="input-form"
            onSubmit={(e) => {
              sendStringToCheckIfPalindrome(e);
            }}
          >
            <h3>IsPalindrome</h3>
            <TextField
              variant="outlined"
              label="Input to check"
              sx={{ width: 400, mb: 2 }}
              onChange={(e) => {
                handleIsPalindromInput(e);
              }}
            />
            <Button
              type="submit"
              variant="contained"
              sx={{ width: 400, mb: 2 }}
            >
              submit
            </Button>
            <Collapse in={isPalindrome.dataSent}>
              {isPalindrome.palindrome ? (
                <Alert sx={{ width: 370, mb: 2 }} severity="success">
                  This is a Palindrome
                </Alert>
              ) : (
                <Alert sx={{ width: 370, mb: 2 }} severity="error">
                  {" "}
                  This is not a Palindrome
                </Alert>
              )}
            </Collapse>
          </form>

          <form
            className="input-form"
            onSubmit={(e) => {
              sendNumberToAddZeroes(e);
            }}
          >
            <h3>Pad numbers with zeroes</h3>
            <TextField
              variant="outlined"
              type="number"
              label="Input to check"
              sx={{ width: 400, mb: 2 }}
              onChange={(e) => {
                e.target.value = Math.max(0, parseInt(e.target.value))
                    .toString()
                    .slice(0, 5);
                handlePaddedNumbersInput(e);
              }}
            />
            <Button
              type="submit"
              variant="contained"
              sx={{ width: 400, mb: 2 }}
            >
              submit
            </Button>
            <Collapse in={paddedNumber.dataSent}>
              {paddedNumber.dataSent ? (
                <p>Result is: {paddedNumber.result}</p>
              ) : (
                <p>Result is:</p>
              )}
            </Collapse>
          </form>

          <div className="input-form">
            <h3>Find nth largest number</h3>
            <div className="add-to-list-input">
              <TextField
                variant="outlined"
                type="number"
                sx={{ width: 150 }}
                onChange={(e) => {
                  e.target.value = Math.max(0, parseInt(e.target.value))
                    .toString()
                    .slice(0, 4);
                  setNumbersListInput(e.target.value);
                }}
              />
              <Button
                variant="contained"
                sx={{ ml: 1, mb: 2, width: 130, height: 56 }}
                onClick={() => {
                  addNumberToList();
                }}
              >
                Add to list
              </Button>
            </div>

            <form
              className="nth-largest-number-input"
              onSubmit={(e) => {
                findNthLargestNumber(e);
              }}
            >
              <TextField
                variant="outlined"
                type="number"
                sx={{ width: 100 }}
                onChange={(e) => {
                  setNthLargestNumber({
                    ...nthLargestNumber,
                    nthLargestNumber: e.target.value,
                  });
                }}
                disabled={nthLargestNumber.numbers.length === 0}
              />
              <Button
                variant="contained"
                type="submit"
                sx={{ ml: 1, mb: 2, width: 130, height: 56 }}
                disabled={nthLargestNumber.numbers.length === 0}
              >
                Find the number
              </Button>
              <Collapse in={nthLargestNumber.result !== null}>
                <Alert severity="success">
                  Nth largest number is: {nthLargestNumber.result}
                </Alert>
              </Collapse>
            </form>

            <Collapse in={nthLargestNumber.numbers.length > 0}>
              <div className="numbers-list">
                {nthLargestNumber.numbers.map((number) => {
                  return (
                    <div className="numbers-list-number">
                      <p>{number}</p>
                    </div>
                  );
                })}
              </div>
            </Collapse>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
