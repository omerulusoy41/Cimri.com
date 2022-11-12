import React from "react";

import "../style.css";

export default function Loading() {
  return (
    <div
      className="d-flex"
      style={{
        width: "100%",
        height: "667px",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <p>Bilgiler çekiliyor lütfen bekleyiniz...</p>
      <div
        className="spinner-border "
        style={{
          width: "200px",
          height: "200px",
          borderWidth: "25px",
        }}
        role="status"
      >
        <span className="visually-hidden"></span>
      </div>
    </div>
  );
}
