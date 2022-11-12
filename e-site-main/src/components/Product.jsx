import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function Product({ product }) {
  const params = useParams();
  const [inputs, setInputs] = useState(product);
  useEffect(() => {
    axios
      .get(`http://172.20.10.3:8080/mySite/${params.id}`)
      .then((res) => {
        console.log(res.data);
        setInputs(res.data);
      })
      .catch((err) => console.log(err));
  }, []);

  return (
    <div
      className="container"
      style={{
        marginTop: "70px",
        display: "flex",
        flexDirection: "column",
        border: "solid",
        borderRadius: "10px",
      }}
    >
      <h1 style={{ marginLeft: "37%" }}>Ürün Bilgisi</h1>
      <div style={{ display: "flex", marginLeft: "18%" }}>
        <img
          src={inputs.imageLinki}
          alt="resim"
          style={{ width: "500px", height: "500px" }}
        />
        <div className="row" style={{ marginLeft: "50px" }}>
          <p>Model No : {`${inputs.modelNo}`} </p>
          <p>Marka : {`${inputs.marka}`}</p>
          <p>Fiyat : {`${inputs.fiyat}`}</p>
          <p>Disk : {`${inputs.diskBoyutu} ${inputs.diskTuru}`}</p>
          <p>Islemci Tipi : {`${inputs.islemciTipi}`}</p>
          <p>Isletim Sistemi : {`${inputs.isletimSistemi}`}</p>
          <p>Ram : {`${inputs.ram}`}</p>
          <p>Ekran : {`${inputs.inc}`}</p>
          <p>Puan : {`${inputs.puan}`}</p>
        </div>
      </div>
    </div>
  );
}
