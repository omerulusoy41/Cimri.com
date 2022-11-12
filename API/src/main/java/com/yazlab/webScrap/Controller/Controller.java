package com.yazlab.webScrap.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yazlab.webScrap.Servis.LaptopService;
import com.yazlab.webScrap.model.Laptop;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping(value = "/",produces = {"application/json"})
public class Controller {
	
	@Autowired
	private LaptopService servis;
	
//	@GetMapping("/Laptop")
//	public List<Laptop> all()
//	{
//		return servis.getAll();
//	}
	@GetMapping("/mySite")
	public List<Laptop> OFBEGAll()
	{
		return servis.getOFBEGAll();
	}
	@GetMapping("/cimri/getEqualls")
    public ResponseEntity<ArrayList<ArrayList<Laptop>>> getAllStudents() {
        return ResponseEntity.ok(servis.getAllequals());
    }
//	@GetMapping("/cimri/{modelNo}")
//    public ArrayList<Laptop> getModelNo(@PathVariable String modelNo) {
//        return servis.getFindByModelNo(modelNo);
//    }
	@PostMapping("/mySite")
	public ResponseEntity<Laptop> create(@RequestBody Laptop lp) {
		if(servis.create(lp))
			return ResponseEntity.ok(lp);
       return ResponseEntity.ok(lp);
    } 
	@GetMapping("/mySite/{id}")
	public ResponseEntity<Laptop> getId(@PathVariable String id) {
        return ResponseEntity.ok(servis.getById(Integer.parseInt(id)));
    } 
	@DeleteMapping("/mySite/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		servis.delete(Integer.parseInt(id));
        return ResponseEntity.ok("Ok");
    } 
	@PutMapping("/mySite/{id}")
	public ResponseEntity<String> update(@PathVariable String id,@RequestParam(required = false) String fiyat,
			@RequestParam(required = false) String ImageLinki,
			@RequestParam(required = false) String Puan) {
		servis.update(Integer.parseInt(id),fiyat,ImageLinki,Puan);
        return ResponseEntity.ok("Ok");
    } 
	@GetMapping("/mySite/sirala")
	public ResponseEntity<List<Laptop>> sirala(@RequestParam(required = false) String bilgi,
			@RequestParam(required = false) String bilgi2) {
        return ResponseEntity.ok(servis.sirala(bilgi,bilgi2));
    }
	@GetMapping("/mySite/filter")
	public ResponseEntity<List<Laptop>> getFilter1(@RequestParam(required = false) String bilgi){
		return ResponseEntity.ok((servis.mySiteFilter(bilgi)));
	}
	@GetMapping("/cimri/filter")
	public ResponseEntity<ArrayList<ArrayList<Laptop>>> getFilter2(@RequestParam(required = false) String bilgi){
		return ResponseEntity.ok((servis.cimriFilter(bilgi)));
	}
//	@GetMapping("/cimri/filter/Isis")
//	public ResponseEntity<List<Laptop>> getIsletimSistemi(@RequestParam(required = false) String IsletimSistemi){
//		return ResponseEntity.ok((servis.filterIsletimSistemi(IsletimSistemi)));
//	}
//	@GetMapping("/cimri/filter/Itip")
//	public ResponseEntity<List<Laptop>> getIslemciTipi(@RequestParam(required = false) String IslemciTipi){
//		return ResponseEntity.ok((servis.filterIslemciTipi(IslemciTipi)));
//	}
//	@GetMapping("/cimri/filter/Ram")
//	public ResponseEntity<List<Laptop>> getRam(@RequestParam(required = false) String Ram){
//		return ResponseEntity.ok((servis.filterRam(Ram)));
//	}
//	@GetMapping("/cimri/filter/DB")
//	public ResponseEntity<List<Laptop>> getDiskBoyutu(@RequestParam(required = false) String DiskBoyutu){
//		return ResponseEntity.ok((servis.filterDiskBoyutu(DiskBoyutu)));
//	}
//	@GetMapping("/cimri/filter/DT")
//	public ResponseEntity<List<Laptop>> getDiskTuru(@RequestParam(required = false) String DiskTuru){
//		return ResponseEntity.ok((servis.filterDiskTuru(DiskTuru)));
//	}
//	
//	@GetMapping("/cimri/filter/INC")
//	public ResponseEntity<List<Laptop>> getINC(@RequestParam(required = false) String INC){
//		return ResponseEntity.ok((servis.filterINC(INC)));
//	}
}
