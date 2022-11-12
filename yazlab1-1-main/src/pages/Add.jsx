import axios from "axios";
import React, { useState } from "react";
import "../style.css";

export default function Add() {
  const [infos, setInfos] = useState({
    marka: "",
    modelNo: "",
    siteIsmi: "OFBEG",
    fiyat: "",
    imageLinki: "",
    diskTuru: "",
    islemciTipi: "",
    isletimSistemi: "",
    ram: "",
    inc: "",
    siteLinki: "http://172.20.10.2:3000/",
    puan: "",
    diskBoyutu: "",
  });
  const onChange = (event) => {
    setInfos({
      ...infos,
      [event.target.id]: event.target.value,
    });
  };
  const onClick = () => {
    if (
      !infos.marka ||
      !infos.modelNo ||
      !infos.siteIsmi ||
      !infos.fiyat ||
      !infos.imageLinki ||
      !infos.diskTuru ||
      !infos.islemciTipi ||
      !infos.isletimSistemi ||
      !infos.ram ||
      !infos.inc ||
      !infos.siteLinki ||
      !infos.puan ||
      !infos.diskBoyutu
    ) {
      alert("LÜTFEN TÜM BİLGİLERİ DOLDURUNUZ !");
    } else {
      console.log(infos);
      axios
        .post("http://172.20.10.3:8080/mySite", infos)
        .then((res) => console.log(res))
        .catch((err) => console.log(err));
      window.location.replace("/");
    }
  };
  return (
    <div className="container" style={{ marginTop: "100px" }}>
      <h1 style={{ marginLeft: "37%" }}>ADD PRODUCT</h1>
      <div className="row">
        <input
          className="form-control"
          style={{ margin: "5px" }}
          type="text"
          id="fiyat"
          onChange={onChange}
          placeholder="fiyat"
        />
        <input
          className="form-control"
          style={{ margin: "5px" }}
          type="text"
          id="puan"
          onChange={onChange}
          placeholder="puan"
        />
        <input
          className="form-control"
          style={{ margin: "5px" }}
          type="text"
          id="islemciTipi"
          onChange={onChange}
          placeholder="islemciTipi"
        />
        <input
          className="form-control"
          style={{ margin: "5px" }}
          type="text"
          id="ram"
          onChange={onChange}
          placeholder="ram"
        />
        <input
          className="form-control"
          style={{ margin: "5px" }}
          type="text"
          id="isletimSistemi"
          onChange={onChange}
          placeholder="isletimSistemi"
        />
        <input
          className="form-control"
          style={{ margin: "5px" }}
          type="text"
          id="diskBoyutu"
          onChange={onChange}
          placeholder="diskBoyutu"
        />
        <input
          className="form-control"
          style={{ margin: "5px" }}
          type="text"
          id="imageLinki"
          onChange={onChange}
          placeholder="imageLinki"
        />
        <input
          className="form-control"
          style={{ margin: "5px" }}
          type="text"
          id="diskTuru"
          onChange={onChange}
          placeholder="diskTuru"
        />
        <input
          className="form-control"
          style={{ margin: "5px" }}
          type="text"
          id="inc"
          onChange={onChange}
          placeholder="inc"
        />
        <input
          className="form-control"
          style={{ margin: "5px" }}
          type="text"
          id="modelNo"
          onChange={onChange}
          placeholder="modelNo"
        />
        <input
          className="form-control"
          style={{ margin: "5px" }}
          type="text"
          id="marka"
          onChange={onChange}
          placeholder="marka"
        />
        <button
          style={{ margin: "5px" }}
          className="btn btn-primary"
          onClick={onClick}
        >
          Kaydet
        </button>
      </div>
    </div>
  );
}
