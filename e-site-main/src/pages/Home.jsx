import React, { useState } from "react";
import FilterMenu from "../pieceOfPages/FilterMenu";
import Content from "../pieceOfPages/Content";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "../pieceOfPages/Header";

export default function Home({ data, setSearch, setProduct, setSampleData }) {
  return (
    <div id="home">
      <Header setSearch={setSearch} />
      <div className="row">
        <div className="col-2">
          <FilterMenu data={data} setSampleData={setSampleData} />
        </div>
        <div className="col-10">
          <Content setProduct={setProduct} data={data} />
        </div>
      </div>
    </div>
  );
}
