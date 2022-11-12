import React from "react";
import { Link } from "react-router-dom";
import "../style.css";

export default function Card(props) {
  const onClick = () => {
    props.setProduct({
      marka: props.marka,
      modelNo: props.modelNo,
      fiyat: props.fiyat,
      imageLinki: props.fotolink,
      diskTuru: props.DiskTuru,
      islemciTipi: props.islemci,
      isletimSistemi: props.isletimSis,
      ram: props.ram,
      inc: props.ekran,
      siteLinki: props.SiteLinki,
      puan: props.puan,
      diskBoyut: props.DiskBoyut,
    });
  };
  return (
    <>
      <div
        className="card"
        style={{
          width: "18rem",
          float: "left",
          margin: "20px",
          height: "450px",
          borderWidth: "2px",
          borderColor: "gray",
        }}
      >
        <img
          className="card-img-top"
          src={props.fotolink}
          alt="resim"
          style={{
            borderRadius: "5px 5px 0px 0px",
            width: "200px",
            marginLeft: "40px",
          }}
        />
        <div className="card-body">
          <h5 className="card-title">
            <p>
              <Link
                onClick={onClick}
                to={`/${props.id}`}
                style={{ color: "black", textDecoration: "none" }}
              >
                {` ${props.marka}
            ${props.modelNo}
            ${props.islemci}
            ${props.ram}
            ${props.isletimSis}
            ${props.ekran} 
            ${props.DiskBoyut}
            ${props.DiskTuru}
            `}
              </Link>
            </p>
          </h5>
          <p className="card-text">PUAN : {props.puan}</p>
          <hr />
          <table id="table">
            <tr>
              <th> {props.SiteIsmi} </th>
            </tr>
            <tr>
              <td>{props.fiyat}</td>
            </tr>
          </table>
        </div>
      </div>

      {/* <div id="card">
        <div id="image">
          <img src={props.fotolink} alt="resim" />
        </div>
        <div id="description">
          <p>
            <Link
              onClick={onClick}
              to={`/${props.id}`}
              style={{ color: "black", textDecoration: "none" }}
            >
              {` ${props.marka}
            ${props.modelNo}
            ${props.islemci}
            ${props.ram}
            ${props.isletimSis}
            ${props.ekran} 
            ${props.DiskBoyut}
            ${props.DiskTuru}
            `}
            </Link>
          </p>

          <h6>PUAN : {props.puan}</h6>

          <table id="table">
            <tr>
              <th> {props.SiteIsmi} </th>
            </tr>
            <tr>
              <td>{props.fiyat}</td>
            </tr>
          </table>
        </div>
      </div> */}
    </>
  );
}
