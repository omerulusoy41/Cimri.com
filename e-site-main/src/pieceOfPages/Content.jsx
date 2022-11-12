import React from "react";
import Card from "../components/Card";

export default function Content({ data, setProduct }) {
  return (
    <div id="content">
      {data.map((array) => (
        <Card
          id={array[0]._id}
          key={array[0]._id}
          modelNo={array[0].modelNo}
          puan={array[0].puan}
          islemci={array[0].islemciTipi}
          ram={array[0].ram}
          DiskBoyut={array[0].diskBoyutu}
          DiskTuru={array[0].diskTuru}
          ekran={array[0].inc}
          marka={array[0].marka}
          SiteLinki={array[0].siteLinki}
          fotolink={array[0].imageLinki}
          isletimSis={array[0].isletimSistemi}
          SiteIsmi={array}
          setProduct={setProduct}
        />
      ))}
    </div>
  );
}
