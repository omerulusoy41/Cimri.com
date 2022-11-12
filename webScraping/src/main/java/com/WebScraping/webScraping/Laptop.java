package com.WebScraping.webScraping;

public class Laptop {
	
	private String marka;
	private String ModelNo;
	private String isletimSistemi;
	private String islemciTipi;
	private String ram;
	private String diskBoyut;
	private String diskTur;
	private String inc;
	private String puan;
 	private String fiyat;
 	private String siteIsmi;
 	private String siteLink;
 	private String imgLink;
	
	public String getImgLink() {
		return imgLink;
	}
	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
	public String getSiteLink() {
		return siteLink;
	}
	public void setSiteLink(String siteLink) {
		this.siteLink = siteLink;
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
		return isletimSistemi;
	}
	public void setIsletimSistemi(String isletimSistemi) {
		this.isletimSistemi = isletimSistemi;
	}
	public String getIslemciTipi() {
		return islemciTipi;
	}
	public void setIslemciTipi(String islemciTipi) {
		this.islemciTipi = islemciTipi;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getDiskBoyut() {
		return diskBoyut;
	}
	public void setDiskBoyut(String diskBoyut) {
		this.diskBoyut = diskBoyut;
	}
	public String getDiskTur() {
		return diskTur;
	}
	public void setDiskTur(String diskTur) {
		this.diskTur = diskTur;
	}
	public String getInc() {
		return inc;
	}
	public void setInc(String inc) {
		this.inc = inc;
	}
	public String getSiteIsmi() {
		return siteIsmi;
	}
	public void setSiteIsmi(String siteIsmi) {
		this.siteIsmi = siteIsmi;
	}
	public String getPuan() {
		return puan;
	}
	public void setPuan(String puan) {
		this.puan = puan;
	}
	public String getFiyat() {
		return fiyat;
	}
	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}
	@Override
	public String toString() {
		return "Laptop [marka=" + marka + ", ModelAd="+ ModelNo + ", isletimSistemi="
				+ isletimSistemi + ", islemciTipi=" + islemciTipi + ", ram=" + ram + ", diskBoyut=" + diskBoyut
				+ ", diskTur=" + diskTur + ", inc=" + inc + ", puan=" + puan + ", fiyat=" + fiyat + ", siteIsmi="
				+ siteIsmi + ", siteLink=" + siteLink + ", imgLink=" + imgLink + "]";
	}
	
}
