import React, { useState } from "react";

function NumberDisplay(props) {
  return (
    <div>
      <p>Output:</p>
      <div className="card">
        <p>{props.data}</p>
      </div>
    </div>
  );
}

export default NumberDisplay;
