import axios from "axios";
import React, { useState } from "react";
import "../style.css";

export default function FilterMenu({ setSampleData }) {
  const [disableds, setDisableds] = useState({
    fiyat: false,
    marka: false,
    ram: false,
    inc: false,
    diskboyutu: false,
    diskturu: false,
    isletimsistemi: false,
  });

  const onClick = (event) => {
    const { id, name } = event.target;
    setDisableds({
      ...disableds,
      [name]: true,
    });
    console.log(name, ":", id);
    axios
      .get(`http://172.20.10.3:8080/mySite/filter?bilgi=${name}=${id}`)
      .then((res) => {
        console.log(res.data);
        setSampleData(res.data);
      })
      .catch((err) => console.log(err));
  };
  const reset = () => {
    window.location.replace("/");
  };

  return (
    <div id="filterMenu">
      <button
        style={{
          borderRadius: "5px",
          margin: "0px 15px 5px 0px",
          backgroundColor: "green",
          color: "white",
        }}
        onClick={reset}
      >
        Sıfırla
      </button>

      <details>
        <summary>Fiyat aralığı</summary>
        <input
          type="checkbox"
          id="2.000-12.500"
          value="2.000-12.500"
          name="fiyat"
          onClick={onClick}
          disabled={disableds.fiyat}
        />
        <label htmlFor="2.000-12.500"> 2.000TL-12.500TL </label>
        <br />
        <input
          type="checkbox"
          id="12.500-17.000"
          value="12.500-17.000"
          name="fiyat"
          onClick={onClick}
          disabled={disableds.fiyat}
        />
        <label htmlFor="12.500-17.000"> 12.500TL-17.000TL </label>
        <br />
        <input
          type="checkbox"
          id="17.000-25.000"
          value="17.000-25.000"
          name="fiyat"
          onClick={onClick}
          disabled={disableds.fiyat}
        />
        <label htmlFor="17.000-25.000"> 17.000TL-25.000TL </label>
        <br />
        <input
          type="checkbox"
          id="25.000-30.000"
          value="25.000-30.000"
          name="fiyat"
          onClick={onClick}
          disabled={disableds.fiyat}
        />
        <label htmlFor="25.000-30.000"> 25.000TL-30.000TL </label>
        <br />
        <input
          type="checkbox"
          id="30.000-0"
          value="30.000-0"
          name="fiyat"
          onClick={onClick}
          disabled={disableds.fiyat}
        />
        <label htmlFor="30.000-0"> 30.000TL üstü </label>
        <br />
      </details>
      <details>
        <summary>Marka</summary>

        <input
          type="checkbox"
          id="Lenovo"
          value="Lenovo"
          name="marka"
          onClick={onClick}
          disabled={disableds.marka}
        />
        <label htmlFor="Lenovo"> Lenovo </label>
        <br />
        <input
          type="checkbox"
          id="Monster"
          value="Monster"
          name="marka"
          onClick={onClick}
          disabled={disableds.marka}
        />
        <label htmlFor="Monster"> Monster</label>
        <br />
        <input
          type="checkbox"
          id="HP"
          value="HP"
          name="marka"
          onClick={onClick}
          disabled={disableds.marka}
        />
        <label htmlFor="HP"> HP</label>
        <br />

        <input
          type="checkbox"
          id="Asus"
          value="Asus"
          name="marka"
          onClick={onClick}
          disabled={disableds.marka}
        />
        <label htmlFor="Asus"> Asus </label>
        <br />
        <input
          type="checkbox"
          id="Dell"
          value="Dell"
          name="marka"
          onClick={onClick}
          disabled={disableds.marka}
        />
        <label htmlFor="Dell"> Dell</label>
        <br />

        <input
          type="checkbox"
          id="Apple"
          value="Apple"
          name="marka"
          onClick={onClick}
          disabled={disableds.marka}
        />
        <label htmlFor="Apple"> Apple</label>
        <br />
        <input
          type="checkbox"
          id="Acer"
          value="Acer"
          name="marka"
          onClick={onClick}
          disabled={disableds.marka}
        />
        <label htmlFor="Acer"> Acer</label>
        <br />
        <input
          type="checkbox"
          id="Casper"
          value="Casper"
          name="marka"
          onClick={onClick}
          disabled={disableds.marka}
        />
        <label htmlFor="Casper"> Casper</label>
      </details>
      <details>
        <summary> Ram </summary>
        <input
          type="checkbox"
          id="4"
          value="4GB"
          name="ram"
          onClick={onClick}
          disabled={disableds.ram}
        />
        <label htmlFor="4GB"> 4 GB </label>
        <br />
        <input
          type="checkbox"
          id="8"
          value="8GB"
          name="ram"
          onClick={onClick}
          disabled={disableds.ram}
        />
        <label htmlFor="8GB"> 8 GB </label>
        <br />
        <input
          type="checkbox"
          id="16"
          value="16GB"
          name="ram"
          onClick={onClick}
          disabled={disableds.ram}
        />
        <label htmlFor="16GB"> 16 GB </label>
        <br />
        <input
          type="checkbox"
          id="24"
          value="24GB"
          name="ram"
          onClick={onClick}
          disabled={disableds.ram}
        />
        <label htmlFor="24"> 24 GB </label>
        <br />
        <input
          type="checkbox"
          id="32"
          value="32GB"
          name="ram"
          onClick={onClick}
          disabled={disableds.ram}
        />
        <label htmlFor="32GB"> 32 GB </label>
        <br />
        <input
          type="checkbox"
          id="64"
          value="64GB"
          name="ram"
          onClick={onClick}
          disabled={disableds.ram}
        />
        <label htmlFor="64GB"> 64 GB </label>
        <br />
      </details>
      <details>
        <summary> Ekran </summary>
        <input
          type="checkbox"
          id="11"
          value="11"
          name="inc"
          onClick={onClick}
          disabled={disableds.inc}
        />
        <label htmlFor="11"> 11 </label>
        <br />

        <input
          type="checkbox"
          id="13"
          value="13"
          name="inc"
          onClick={onClick}
          disabled={disableds.inc}
        />
        <label htmlFor="13"> 13 </label>
        <br />

        <input
          type="checkbox"
          id="14"
          value="14"
          name="inc"
          onClick={onClick}
          disabled={disableds.inc}
        />
        <label htmlFor="14"> 14 </label>
        <br />

        <input
          type="checkbox"
          id="15"
          value="15"
          name="inc"
          onClick={onClick}
          disabled={disableds.inc}
        />
        <label htmlFor="15"> 15 </label>
        <br />

        <input
          type="checkbox"
          id="16"
          value="16"
          name="inc"
          onClick={onClick}
          disabled={disableds.inc}
        />
        <label htmlFor="16"> 16 </label>
        <br />

        <input
          type="checkbox"
          id="17"
          value="17"
          name="inc"
          onClick={onClick}
          disabled={disableds.inc}
        />
        <label htmlFor="17"> 17 </label>
      </details>
      <details>
        <summary> Disk Boyutu </summary>
        <input
          type="checkbox"
          id="64"
          value="64"
          name="diskboyutu"
          onClick={onClick}
          disabled={disableds.diskboyutu}
        />
        <label htmlFor="64"> 64 GB</label>
        <br />

        <input
          type="checkbox"
          id="120"
          value="120"
          name="diskboyutu"
          onClick={onClick}
          disabled={disableds.diskboyutu}
        />
        <label htmlFor="120"> 120 GB</label>
        <br />

        <input
          type="checkbox"
          id="128"
          value="128"
          name="diskboyutu"
          onClick={onClick}
          disabled={disableds.diskboyutu}
        />
        <label htmlFor="128"> 128 GB</label>
        <br />
        <input
          type="checkbox"
          id="250"
          value="250"
          name="diskboyutu"
          onClick={onClick}
          disabled={disableds.diskboyutu}
        />
        <label htmlFor="250"> 250 GB </label>
        <br />
        <input
          type="checkbox"
          id="256"
          value="256"
          name="diskboyutu"
          onClick={onClick}
          disabled={disableds.diskboyutu}
        />
        <label htmlFor="256"> 256 GB </label>
        <br />

        <input
          type="checkbox"
          id="500"
          value="500"
          name="diskboyutu"
          onClick={onClick}
          disabled={disableds.diskboyutu}
        />
        <label htmlFor="500"> 500 GB </label>
        <br />

        <input
          type="checkbox"
          id="512"
          value="512"
          name="diskboyutu"
          onClick={onClick}
          disabled={disableds.diskboyutu}
        />
        <label htmlFor="512"> 512 GB </label>
        <br />

        <input
          type="checkbox"
          id="1 TB"
          value="1 TB"
          name="diskboyutu"
          onClick={onClick}
          disabled={disableds.diskboyutu}
        />
        <label htmlFor="1 TB"> 1 TB </label>
        <br />
        <input
          type="checkbox"
          id="2 TB"
          value="2 TB"
          name="diskboyutu"
          onClick={onClick}
          disabled={disableds.diskboyutu}
        />
        <label htmlFor="2 TB"> 2 TB </label>
        <br />

        <input
          type="checkbox"
          id="6 TB"
          value="6 TB"
          name="diskboyutu"
          onClick={onClick}
          disabled={disableds.diskboyutu}
        />
        <label htmlFor="6 TB"> 6 TB </label>
        <br />
      </details>
      <details>
        <summary> Disk Türü </summary>
        <input
          type="checkbox"
          id="SSD"
          value="SSD"
          name="diskturu"
          onClick={onClick}
          disabled={disableds.diskturu}
        />
        <label htmlFor="SSD"> SSD</label>
        <br />

        <input
          type="checkbox"
          id="HDD"
          value="HDD"
          name="diskturu"
          onClick={onClick}
          disabled={disableds.diskturu}
        />
        <label htmlFor="HDD"> HDD</label>
        <br />
      </details>
      <details>
        <summary> İşletim Sistemi </summary>
        <input
          type="checkbox"
          id="freedos"
          value="freedos"
          name="isletimsistemi"
          onClick={onClick}
          disabled={disableds.isletimsistemi}
        />
        <label htmlFor="freedos"> freedos</label>
        <br />

        <input
          type="checkbox"
          id="windows"
          value="windows"
          name="isletimsistemi"
          onClick={onClick}
          disabled={disableds.isletimsistemi}
        />
        <label htmlFor="windows"> windows</label>
        <br />

        <input
          type="checkbox"
          id="linux"
          value="linux"
          name="isletimsistemi"
          onClick={onClick}
          disabled={disableds.isletimsistemi}
        />
        <label htmlFor="linux"> linux</label>
        <br />

        <input
          type="checkbox"
          id="chrome"
          value="chrome"
          name="isletimsistemi"
          onClick={onClick}
          disabled={disableds.isletimsistemi}
        />
        <label htmlFor="chrome"> chrome</label>
        <br />

        <input
          type="checkbox"
          id="ubuntu"
          value="ubuntu"
          name="isletimsistemi"
          onClick={onClick}
          disabled={disableds.isletimsistemi}
        />
        <label htmlFor="ubuntu"> ubuntu </label>
        <br />
        <input
          type="checkbox"
          id="macos"
          value="macos"
          name="isletimsistemi"
          onClick={onClick}
          disabled={disableds.isletimsistemi}
        />
        <label htmlFor="macos"> macos </label>
        <br />
      </details>
    </div>
  );
}
