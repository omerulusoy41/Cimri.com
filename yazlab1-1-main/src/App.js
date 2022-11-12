import React, { useEffect, useState } from "react";
import Home from "./pages/Home";
import { Routes, Route } from "react-router-dom";
import Admin from "./pages/Admin";
import Add from "./pages/Add";
import Data from "./data.json";
import axios from "axios";
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
    diskBoyutu: "",
  });
  useEffect(() => {
    getData();
  }, []);

  useEffect(() => {
    if (sampleData.length === 0) {
      alert("böyle bir veri yok ");
      window.location.replace("/");
    } else {
      setData(sampleData);
      if (search !== "") {
        const filtred = sampleData.filter(
          (element) =>
            element.marka.toLowerCase().indexOf(search.toLowerCase()) !== -1 ||
            element.siteIsmi.toLowerCase().indexOf(search.toLowerCase()) !==
              -1 ||
            element.modelNo.toLowerCase().indexOf(search.toLowerCase()) !== -1
        );
        if (filtred.length === 0) {
          alert("böyle bir veri yok ");
        } else {
          setData(filtred);
        }
      }
    }
  }, [search, sampleData, isTrue]);

  const getData = async () => {
    await axios
      .get("http://172.20.10.3:8080/mySite") //172.20.10.3 fatih  - 192.168.124.52 ömer
      .then((res) => {
        console.log("geldi : ", res.data);
        setSampleData(res.data);
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
            <Route
              path="/admin"
              element={<Admin data={data} setSearch={setSearch} />}
            />
            <Route path="/add-product" element={<Add />} />
          </>
        ) : (
          <Route path="/" element={<Loading />} />
        )}
      </Routes>
    </div>
  );
}

export default App;
