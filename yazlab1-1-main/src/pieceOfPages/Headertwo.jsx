import React from "react";
import axios from "axios";
import "../style.css";

export default function Headertwo({ setSampleData }) {
  const kbp = () => {
    axios
      .get(`http://172.20.10.3:8080/mySite/sirala?bilgi=puan&bilgi2=y`)
      .then((res) => {
        setSampleData(res.data);
      })
      .catch((err) => console.log(err));
    console.log("küçükten büyüğe puan ");
  };
  const kbf = () => {
    axios
      .get("http://172.20.10.3:8080/mySite/sirala?bilgi=fiyat&bilgi2=y")
      .then((res) => {
        setSampleData(res.data);
      })
      .catch((err) => console.log(err));
    console.log("küçükten büyüğe fiyat");
  };
  const bkp = () => {
    axios
      .get("http://172.20.10.3:8080/mySite/sirala?bilgi=puan&bilgi2=d")
      .then((res) => {
        setSampleData(res.data);
      })
      .catch((err) => console.log(err));
    console.log("büyükten küçüğe puan");
  };
  const bkf = () => {
    axios
      .get("http://172.20.10.3:8080/mySite/sirala?bilgi=fiyat&bilgi2=d")
      .then((res) => {
        setSampleData(res.data);
      })
      .catch((err) => console.log(err));
    console.log("büyükten küçüğe fiyat");
  };
  return (
    <div
      className="mt-2"
      style={{
        height: "40px",
        backgroundColor: "white",
        display: "flex",
        justifyContent: "center",
      }}
    >
      <button className=" select shadow" onClick={kbp}>
        küçükten büyüğe puan
      </button>
      <button className="select shadow" onClick={kbf}>
        küçükten büyüğe fiyat
      </button>
      <button className="select shadow" onClick={bkp}>
        büyükten küçüğe puan
      </button>
      <button className="select shadow" onClick={bkf}>
        büyükten küçüğe fiyat
      </button>
    </div>
  );
}
