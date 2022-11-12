import React from "react";
import { Link } from "react-router-dom";

export default function AdminHeader({ setSearch }) {
  const search = (event) => {
    setSearch(event.target.value);
  };
  return (
    <div id="adminheader">
      <input type="text" id="search" onChange={search} placeholder="Search" />
      <button style={{ margin: "0px 5px" }}>
        <Link style={{ color: "green" }} to={"/add-product"}>
          Add product
        </Link>
      </button>
    </div>
  );
}
