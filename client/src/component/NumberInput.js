import React, { useState } from "react";
import FibonacciService from "../services/FibonacciService";
import NumberDisplay from "./NumberDisplay";

const NumberInput = (props) => {
  const [number, setNumber] = useState();
  const [fiboNumber, setFiboNumber] = useState();
  const [error, setError] = useState();

  const numberChangeHandler = (event) => {
    setNumber(event.target.value);
  };

  const getFibonacciNumber = (event) => {
    setFiboNumber();
    FibonacciService.getFibonacciNumber(number)
      .then((response) => {
        setFiboNumber(response.data);
        console.log(response.data);
      })
      .catch((e) => {
        setError(e.response.data.message);
        console.log(e.response.data.message);
      });
  };

  console.log(number);

  return (
    <div>
      <div>
        <label for="number">Enter number:</label>
        <input
          className="form-control"
          id="number"
          onChange={numberChangeHandler}
        />
      </div>
      <br></br>
      <button className="btn btn-primary" onClick={getFibonacciNumber}>
        Generate
      </button>
      <br />
      <br />
      <NumberDisplay data={fiboNumber == null ? error : fiboNumber} />
    </div>
  );
};

export default NumberInput;
