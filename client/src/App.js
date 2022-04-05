import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import NumberInput from "./component/NumberInput";

import "./App.css";

function App() {
  return (
    <div className="container">
      <h2>Fibonacci Number Generator</h2>
      <NumberInput />
    </div>
  );
}

export default App;
