import React from "react";
import AdminCard from "../components/AdminCard";
export default function AdminContent({ data }) {
  //console.log(data);
  return (
    <div id="content">
      {data.map((element) => (
        <AdminCard
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
        />
      ))}
    </div>
  );
}
