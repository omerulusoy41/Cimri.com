package com.yazlab.webScrap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Laptop")
public class Laptop {
	@Id
	private int _id;
	private String marka;
	private String ModelNo;
	private String IsletimSistemi;
	private String IslemciTipi;
	private String Ram;
	private String DiskBoyutu;
	private String DiskTuru;
	private String INC;
	private String Puan;
 	private String Fiyat;
 	private String SiteIsmi;
 	private String SiteLinki;
 	private String ImageLinki;
	
	@Override
	public String toString() {
		return "Laptop [_id=" + _id + ", marka=" + marka + ", ModelNo=" + ModelNo + ", IsletimSistemi=" + IsletimSistemi
				+ ", IslemciTipi=" + IslemciTipi + ", Ram=" + Ram + ", DiskBoyut=" + DiskBoyutu + ", DiskTuru="
				+ DiskTuru + ", INC=" + INC + ", Puan=" + Puan + ", Fiyat=" + Fiyat + ", SiteIsmi=" + SiteIsmi
				+ ", SiteLinki=" + SiteLinki + ", ImageLinki=" + ImageLinki + "]";
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int l) {
		this._id = l;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModelNo() {
		return ModelNo;
	}
	public void setModelNo(String modelNo) {
		ModelNo = modelNo;
	}
	public String getIsletimSistemi() {
		return IsletimSistemi;
	}
	public void setIsletimSistemi(String isletimSistemi) {
		IsletimSistemi = isletimSistemi;
	}
	public String getIslemciTipi() {
		return IslemciTipi;
	}
	public void setIslemciTipi(String islemciTipi) {
		IslemciTipi = islemciTipi;
	}
	public String getRam() {
		return Ram;
	}
	public void setRam(String ram) {
		Ram = ram;
	}
	public String getDiskBoyutu() {
		return DiskBoyutu;
	}
	public void setDiskBoyutu(String diskBoyut) {
		DiskBoyutu = diskBoyut;
	}
	public String getDiskTuru() {
		return DiskTuru;
	}
	public void setDiskTuru(String diskTuru) {
		DiskTuru = diskTuru;
	}
	public String getINC() {
		return INC;
	}
	public void setINC(String iNC) {
		INC = iNC;
	}
	public String getPuan() {
		return Puan;
	}
	public void setPuan(String puan) {
		Puan = puan;
	}
	public String getFiyat() {
		return Fiyat;
	}
	public void setFiyat(String fiyat) {
		Fiyat = fiyat;
	}
	public String getSiteIsmi() {
		return SiteIsmi;
	}
	public void setSiteIsmi(String siteIsmi) {
		SiteIsmi = siteIsmi;
	}
	public String getSiteLinki() {
		return SiteLinki;
	}
	public void setSiteLinki(String siteLinki) {
		SiteLinki = siteLinki;
	}
	public String getImageLinki() {
		return ImageLinki;
	}
	public void setImageLinki(String imageLinki) {
		ImageLinki = imageLinki;
	}
	
	
	
}
