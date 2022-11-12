import React, { useState } from "react";
import "../style.css";

export default function Header({ setSearch }) {
  const onChange = (event) => {
    setSearch(event.target.value.replace(" ", ""));
  };
  return (
    <div id="header">
      <input
        style={{ width: "25%" }}
        type="text"
        id="search"
        onChange={onChange}
        placeholder="Search..."
      />
    </div>
  );
}
