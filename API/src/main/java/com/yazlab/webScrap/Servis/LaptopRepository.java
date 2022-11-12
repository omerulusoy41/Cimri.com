package com.yazlab.webScrap.Servis;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.yazlab.webScrap.model.Laptop;

@Repository
public interface LaptopRepository extends MongoRepository<Laptop,Integer>{
	
	@Query("{'SiteIsmi' : ?0}")
	public List<Laptop> getSite(String SiteIsmi);
	
	@Query("{$and :[{ModelNo: ?0},{SiteIsmi: ?1}] }")
	public Laptop eklenecekKont(String ModelNo,String SiteIsmi);
	
	@Query("{'_id' : ?0}")
	public Laptop getLaptop(int _id);
	
//	@Query("{$and :[{marka: ?0 },{IsletimSistemi: ?1},"
//			+ "{IslemciTipi: ?2},{Ram: ?3},"
//			+ "{DiskBoyutu: ?4},{DiskTuru : ?5},"
//			+ "{INC : ?6},{Fiyat: ?7}]}")
//	public List<Laptop> filter(String marka, String IsletimSistemi, String IslemciTipi, String Ram, String DiskBoyutu,
//			String DiskTuru, String INC, String Fiyat);
	
//	@Query("{'marka' : ?0}")
//	public List<Laptop> getMarka(String marka);
//	
//	@Query("{'IsletimSistemi' : ?0}")
//	public List<Laptop> getIsletimSistemi(String IsletimSistemi);
//	
//	@Query("{'IslemciTipi' : ?0}")
//	public List<Laptop> getIslemciTipi(String IslemciTipi);
//	
//	@Query("{'Ram' : ?0}")
//	public List<Laptop> getRam(String Ram);
//	
//	@Query("{'DiskBoyutu' : ?0}")
//	public List<Laptop> getDiskBoyut(String DiskBoyutu);
//	
//	@Query("{'DiskTuru' : ?0}")
//	public List<Laptop> getDiskTuru(String DiskTuru);
//	
//	@Query("{'INC' : ?0}")
//	public List<Laptop> getINC(String INC);
//	
//	@Query("{'Fiyat' : ?0}")
//	public List<Laptop> getFiyat(String Fiyat);
	
}
