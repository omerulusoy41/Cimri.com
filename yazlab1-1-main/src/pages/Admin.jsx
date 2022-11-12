import AdminContent from "../pieceOfPages/AdminContent";
import AdminHeader from "../pieceOfPages/AdminHeader";
import FilterMenu from "../pieceOfPages/FilterMenu";
import "bootstrap/dist/css/bootstrap.min.css";

export default function Admin({ data, filterDizi, setFilterDizi, setSearch }) {
  return (
    <div>
      <div id="home">
        <AdminHeader setSearch={setSearch} />
        <div className="row">
          <div className="col-3">
            <FilterMenu />
          </div>
          <div className="col-9">
            <AdminContent data={data} />
          </div>
        </div>
      </div>
    </div>
  );
}
