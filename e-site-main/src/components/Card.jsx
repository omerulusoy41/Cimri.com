import React, { useState } from "react";
import "../style.css";
import { Link } from "react-router-dom";

export default function Card(props) {
  let trendyolSayac = 0;
  let hepsiburadaSayac = 0;
  const siteIsmi = [];
  const fiyat = [];
  const siteLinki = [];

  props.SiteIsmi.forEach((element) => {
    if (element.siteIsmi.toLowerCase() === "trendyol" && trendyolSayac === 0) {
      trendyolSayac++;
      siteIsmi.push(element.siteIsmi);
      siteLinki.push(element.siteLinki);
      if (element.fiyat.length < 5) {
        fiyat.push(element.fiyat + "00");
      } else fiyat.push(element.fiyat);
    } else if (
      element.siteIsmi.toLowerCase() === "hepsiburada" &&
      hepsiburadaSayac === 0
    ) {
      hepsiburadaSayac++;

      siteIsmi.push(element.siteIsmi);
      siteLinki.push(element.siteLinki);
      if (element.fiyat.length < 5) {
        fiyat.push(element.fiyat + "00");
      } else fiyat.push(element.fiyat);
    } else if (
      element.siteIsmi.toLowerCase() !== "trendyol" &&
      element.siteIsmi.toLowerCase() !== "hepsiburada"
    ) {
      siteIsmi.push(element.siteIsmi);
      fiyat.push(element.fiyat);
      siteLinki.push(element.siteLinki);
    }
  });

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
    <div id="card">
      <div id="image">
        <img
          style={{ borderRight: "2px solid" }}
          src={props.fotolink}
          alt="resim"
        />
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
            {siteIsmi.map((element) => (
              <td className="th">
                <img
                  style={{
                    width: "50px",
                    height: "30px",
                    borderRadius: "5px",
                  }}
                  src={
                    element.toLowerCase() === "n11"
                      ? "https://www.freelogovectors.net/wp-content/uploads/2021/09/n11-com-logo-freelogovectors.net_.png"
                      : element.toLowerCase() === "trendyol"
                      ? "https://patronlarinensesindeyiz.org/wp-content/uploads/2019/09/Copy-of-Copy-of-PEWeb-sa%C4%9Fda-filigranl%C4%B1-haber-fotosu-660x300-1-660x300.png"
                      : element.toLowerCase() === "hepsiburada"
                      ? "https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Hepsiburada_logo_official.svg/2560px-Hepsiburada_logo_official.svg.png"
                      : element.toLowerCase() === "teknosa"
                      ? "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Teknosa_logo.svg/2560px-Teknosa_logo.svg.png"
                      : element.toLowerCase() === "vatan"
                      ? "https://www.freelogovectors.net/wp-content/uploads/2018/02/vatan-computer-logo.png"
                      : "https://media.istockphoto.com/vectors/initial-letter-f-logo-with-creative-modern-business-typography-vector-vector-id1269715219"
                  }
                  alt="resim"
                />
              </td>
            ))}
          </tr>
          <tr>
            {siteLinki.map((element) => (
              <td>
                <a href={element}>
                  <img
                    style={{ width: "20px", height: "20px" }}
                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfVxKWOy1dCbITMMdCMtlgFyzcdhQ4NLyr4w&usqp=CAU"
                    alt="resim"
                  />
                </a>
              </td>
            ))}
          </tr>
          <tr>
            {fiyat.map((element) => (
              <td>{element}</td>
            ))}
          </tr>
        </table>
      </div>
    </div>
  );
}
