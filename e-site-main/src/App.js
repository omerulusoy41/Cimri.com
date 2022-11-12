import React from "react";
import { useState, useEffect } from "react";
import axios from "axios";
import Data from "./data.json";
import Home from "./pages/Home";
import { Route, Routes } from "react-router-dom";
import Product from "./components/Product";
import Loading from "./pages/Loading";

function App() {
  const [data, setData] = useState({});
  const [search, setSearch] = useState("");
  const [sampleData, setSampleData] = useState({});
  const [isTrue, setIsTrue] = useState(false);
  const [product, setProduct] = useState({
    marka: "",
    modelNo: "",
    fiyat: "",
    imageLinki: "",
    diskTuru: "",
    islemciTipi: "",
    isletimSistemi: "",
    ram: "",
    inc: "",
    siteLinki: "",
    puan: "",
    diskBoyut: "",
  });

  useEffect(() => {
    getData();
  }, []);

  useEffect(() => {
    if (sampleData.length === 0) {
      alert("böyle bir veri yok ");
      window.location.replace("/");
    } else {
      console.log("sampleData : ", sampleData);
      setData(sampleData);
      if (search !== "") {
        const filtred = sampleData.filter(
          (element) =>
            element
              .map((e) => {
                if (
                  (e.marka &&
                    e.marka.toLowerCase().indexOf(search.toLowerCase()) !==
                      -1) ||
                  e.siteIsmi.toLowerCase().indexOf(search.toLowerCase()) !==
                    -1 ||
                  e.modelNo.toLowerCase().indexOf(search.toLowerCase() !== -1)
                ) {
                  return true;
                }
                return false;
              })
              .indexOf(true) !== -1
        );
        if (filtred.length === 0) {
          alert("böyle bir veri yok ");
        } else {
          setData(filtred);
        }
      }
    }
  }, [search, sampleData]);

  const getData = async () => {
    await axios
      .get("http://172.20.10.3:8080/cimri/getEqualls") //172.20.10.3 - 192.168.41.52
      .then((res) => {
        setSampleData(res.data);
        console.log(res.data);
      })
      .catch((err) => console.log(err));
    setData(sampleData);
    setIsTrue(true);
  };

  return (
    <div id="App">
      <Routes>
        {isTrue && data.length > 0 ? (
          <>
            <Route path="/:id" element={<Product product={product} />} />
            <Route
              path="/"
              element={
                <Home
                  data={data}
                  setSearch={setSearch}
                  setProduct={setProduct}
                  setSampleData={setSampleData}
                />
              }
            />
          </>
        ) : (
          <Route path="/" element={<Loading />} />
        )}
      </Routes>
    </div>
  );
}

export default App;
