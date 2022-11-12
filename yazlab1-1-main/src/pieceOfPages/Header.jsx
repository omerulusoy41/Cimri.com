import React, { useState } from "react";
import "../style.css";

export default function Header({ setSearch, setSampleData }) {
  const [user, setUser] = useState({
    name: "",
    password: "",
  });
  const onClick = () => {
    console.log(user);
    if (user.name === "fatih" && user.password === "123456") {
      window.location.replace("/admin");
    } else {
      alert("hatalı giriş");
    }
  };

  const onChange = (event) => {
    console.log(event.target.name + " : " + event.target.value);
    setUser({
      ...user,
      [event.target.name]: event.target.value,
    });
  };

  const search = (event) => {
    setSearch(event.target.value.replace(" ", ""));
  };

  // const onClickSelect = (event) => {
  //   const { value } = event.target;
  //   if ("küçükten büyüğe puan" === value) {
  //     axios
  //       .get(`http://172.20.10.3:8080/mySite/sirala?bilgi=puan&bilgi2=y`)
  //       .then((res) => {
  //         setSampleData(res.data);
  //       })
  //       .catch((err) => console.log(err));
  //     console.log("küçükten büyüğe puan ");
  //   } else if ("küçükten büyüğe fiyat" === value) {
  //     axios
  //       .get("http://172.20.10.3:8080/mySite/sirala?bilgi=fiyat&bilgi2=y")
  //       .then((res) => {
  //         setSampleData(res.data);
  //       })
  //       .catch((err) => console.log(err));
  //     console.log("küçükten büyüğe fiyat");
  //   } else if ("büyükten küçüğe puan" === value) {
  //     axios
  //       .get("http://172.20.10.3:8080/mySite/sirala?bilgi=puan&bilgi2=d")
  //       .then((res) => {
  //         setSampleData(res.data);
  //       })
  //       .catch((err) => console.log(err));
  //     console.log("büyükten küçüğe puan");
  //   } else if ("büyükten küçüğe fiyat" === value) {
  //     axios
  //       .get("http://172.20.10.3:8080/mySite/sirala?bilgi=fiyat&bilgi2=d")
  //       .then((res) => {
  //         setSampleData(res.data);
  //       })
  //       .catch((err) => console.log(err));
  //     console.log("büyükten küçüğe fiyat");
  //   } else if ("Sıralama Seçenekleri" === value) {
  //     alert(
  //       "Bir değişiklik yapılmamıştır. Lütfen diğer seçeneklerden birini seçiniz."
  //     );
  //   }
  // };
  return (
    <div id="header">
      {/* <select
        className="form-select"
        style={{ width: "22%", justifyContent: "start" }}
        onChange={onClickSelect}
      >
        <option>Sıralama Seçenekleri</option>
        <option>küçükten büyüğe puan</option>
        <option>küçükten büyüğe fiyat</option>
        <option>büyükten küçüğe puan</option>
        <option>büyükten küçüğe fiyat</option>
      </select> */}
      <img
        className="ms-4"
        style={{ width: "80px", height: "40px", borderRadius: "10px" }}
        src="https://media.istockphoto.com/vectors/initial-letter-f-logo-with-creative-modern-business-typography-vector-vector-id1269715219"
        alt="resim"
      />
      <input
        style={{ width: "25%" }}
        type="text"
        id="search"
        onChange={search}
        placeholder="Search..."
      />
      <div>
        <input id="adminN" name="name" type="text" onChange={onChange} />
        <input id="adminP" name="password" type="text" onChange={onChange} />
        <button
          onClick={onClick}
          style={{ backgroundColor: "green", borderRadius: "5px" }}
        >
          Login
        </button>
      </div>
    </div>
  );
}
