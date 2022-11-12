import React, { useState } from "react";
import axios from "axios";

export default function AdminCard(props) {
  const [pictureHandler, setPictureHandler] = useState(false);
  const [inputs, setInputs] = useState({
    fiyat: "",
    ImageLinki: "",
    Puan: "",
  });

  const onMouseEnter = () => {
    setPictureHandler(true);
  };
  const onMouseLeave = () => {
    setPictureHandler(false);
  };

  const onChange = (event) => {
    setInputs({
      ...inputs,
      [event.target.name]: event.target.value,
    });
  };

  const Deletebtn = (event) => {
    console.log(event.target.id);
    axios
      .delete(`http://172.20.10.3:8080/mySite/${event.target.id}`) // id gönder
      .then((res) => console.log(res))
      .catch((err) => console.log(err));
    window.location.replace("/");
  };

  const save = (event) => {
    console.log(event.target.id);
    console.log(inputs);
    axios
      .put(
        `http://172.20.10.3:8080/mySite/${event.target.id}?fiyat=${inputs.fiyat}&ImageLinki=${inputs.ImageLinki}&Puan=${inputs.Puan}`
      )
      .then((res) => console.log(res))
      .catch((err) => console.log(err));
    window.location.replace("/");
  };
  const onClick = () => {
    const imglink = prompt("yeni bir fotoğraf linki giriniz");
    if (imglink) {
      setInputs({
        ...inputs,
        ImageLinki: imglink,
      });
    }
  };

  return (
    <>
      <div
        className="card"
        style={{
          width: "18rem",
          float: "left",
          margin: "20px",
          height: "500px",
          borderWidth: "2px",
          borderColor: "gray",
        }}
      >
        <button
          className="delete"
          id={props.id}
          onClick={Deletebtn}
          onMouseEnter={onMouseEnter}
          onMouseLeave={onMouseLeave}
        >
          {pictureHandler ? (
            <img
              id={props.id}
              src="resimler/dustbinOpen.png"
              alt="resim"
              style={{ width: "35px", height: "35px", margin: "-5px" }}
            />
          ) : (
            <img
              id={props.id}
              src="resimler/dustbinClose.png"
              alt="resim"
              style={{ width: "25px", height: "25px" }}
            />
          )}
        </button>

        <img
          className="card-img-top"
          src={props.fotolink}
          alt="resim"
          onClick={onClick}
          style={{ width: "200px", marginLeft: "40px" }}
        />

        <div className="card-body">
          <h5 className="card-title">
            <p>
              {` ${props.marka}
        ${props.modelNo}
        ${props.islemci}
        ${props.ram}
        ${props.isletimSis}
        ${props.ekran} 
        ${props.DiskBoyut}
        ${props.DiskTuru}
        `}
            </p>
          </h5>
          <p className="card-text">
            PUAN :{" "}
            <input
              name="Puan"
              type="text"
              placeholder={props.puan}
              onChange={onChange}
              style={{ marginLeft: "10px", width: "120px" }}
            />
          </p>
          <table id="table">
            <tr>
              <th> {props.SiteIsmi} </th>
            </tr>
            <tr>
              <td>
                <input
                  name="fiyat"
                  type="text"
                  placeholder={props.fiyat}
                  onChange={onChange}
                  style={{ marginLeft: "10px", width: "150px" }}
                />
              </td>
              <button id={props.id} className="kaydet" onClick={save}>
                <img
                  id={props.id}
                  className="tick"
                  src="resimler/tick.png"
                  alt="resim"
                />
              </button>
            </tr>
          </table>
        </div>
      </div>

      {/* <div id="card">
        <button
          className="delete"
          id={props.id}
          onClick={Deletebtn}
          onMouseEnter={onMouseEnter}
          onMouseLeave={onMouseLeave}
        >
          {pictureHandler ? (
            <img
              id={props.id}
              src="resimler/dustbinOpen.png"
              alt="resim"
              style={{ width: "35px", height: "35px", margin: "-5px" }}
            />
          ) : (
            <img
              id={props.id}
              src="resimler/dustbinClose.png"
              alt="resim"
              style={{ width: "25px", height: "25px" }}
            />
          )}
        </button>
        <div id="image">
          <img src={props.fotolink} alt="resim" onClick={onClick} />
        </div>
        <div id="description">
          <p>
            <a
              href={props.siteLink}
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
            </a>
          </p>
          <div id="puan">
            <h6>PUAN :</h6>
            <input
              name="Puan"
              type="text"
              placeholder={props.puan}
              onChange={onChange}
            />
          </div>
          <table id="table">
            <tr>
              <th>{props.siteIsmi}</th>
            </tr>
            <tr>
              <td>
                <input
                  name="fiyat"
                  type="text"
                  placeholder={props.fiyat}
                  onChange={onChange}
                />
              </td>
            </tr>
          </table> 
        </div>
        <button id={props.id} className="kaydet" onClick={save}>
          <img
            id={props.id}
            className="tick"
            src="resimler/tick.png"
            alt="resim"
          />
        </button>
      </div>*/}
    </>
  );
}
