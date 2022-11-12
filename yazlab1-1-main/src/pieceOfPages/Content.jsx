import React from "react";
import Card from "../components/Card";
import axios from "axios";
export default function Content({ data, setProduct }) {
  return (
    <div id="content">
      {data.map((element) => (
        <Card
          id={element._id}
          key={element._id}
          modelNo={element.modelNo}
          fiyat={element.fiyat}
          puan={element.puan}
          islemci={element.islemciTipi}
          ram={element.ram}
          DiskBoyut={element.diskBoyutu}
          DiskTuru={element.diskTuru}
          ekran={element.inc}
          marka={element.marka}
          SiteIsmi={element.siteIsmi}
          SiteLinki={element.siteLinki}
          fotolink={element.imageLinki}
          isletimSis={element.isletimSistemi}
          setProduct={setProduct}
        />
      ))}
    </div>
  );
}
