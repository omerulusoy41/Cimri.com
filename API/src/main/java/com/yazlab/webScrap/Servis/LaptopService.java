package com.yazlab.webScrap.Servis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yazlab.webScrap.model.Laptop;

@Service
public class LaptopService {

	private final LaptopRepository repo;
	private List<Laptop> laptops;
	private ArrayList<ArrayList<Laptop>> cimri; 
	private List<Laptop> mySite;

	public LaptopService(LaptopRepository repo) {
		this.repo = repo;
		this.laptops=repo.findAll();
		//dbHazirlama();
		//En bastan veri tabani temizlerken
		//dbhaziralama baslatilacak ve dbTemizle baslatilacak dbtemizle baslatilirken deletedeki performans icin findby lari sil
		//modelNokontrol de calistirilicak temizlendikten sonra kullanilmasina gerrek yok
		
	}

	private void dbHazirlama() {
		vatanTemizle();
		n11Temizle();
		teknosaTemizle();
		laptops = repo.findAll();
		getAllequals();//Burada dbTemizle aktiflestir
		laptops = repo.findAll();
		mySiteOlustur();
	}

	private boolean n11Temizle() {
		int kontrol = 0;
		for (int i = 0; laptops.get(i).getSiteIsmi().equals("n11"); i++) {
			Float f1 = Float.parseFloat(laptops.get(i).getFiyat());
			for (int j = i + 1; laptops.get(j).getSiteIsmi().equals("n11"); j++) {
				Float f2 = Float.parseFloat(laptops.get(j).getFiyat());
				if (laptops.get(i).getModelNo().equals(laptops.get(j).getModelNo())) {
					if (f1 <= f2) {
						repo.deleteById(laptops.get(j).get_id());
						laptops.remove(j);
					} else {
						repo.deleteById(laptops.get(i).get_id());
						laptops.remove(i);
						i--;
					}
					kontrol = 1;
				}
			}
		}
		if (kontrol == 1)
			return true;
		return false;
	}

	private boolean teknosaTemizle() {
		int kontrol = 0;
		for (int i = 0; i < laptops.size(); i++) {
			Float f1;
			if (!laptops.get(i).getSiteIsmi().equals("Teknosa"))
				continue;
			if (laptops.get(i).getFiyat().contains(" ") || laptops.get(i).getFiyat().contains(",")) {
				String[] s;
				if (laptops.get(i).getFiyat().contains(","))
					s = laptops.get(i).getFiyat().split(",");
				else
					s = laptops.get(i).getFiyat().split(" ");
				f1 = Float.parseFloat(s[0]);
			} else
				f1 = Float.parseFloat(laptops.get(i).getFiyat());
			for (int j = i + 1; j < laptops.size(); j++) {
				Float f2;
				if (laptops.get(j).getFiyat().contains(" ") || laptops.get(j).getFiyat().contains(",")) {
					String[] s;
					if (laptops.get(j).getFiyat().contains(","))
						s = laptops.get(j).getFiyat().split(",");
					else
						s = laptops.get(j).getFiyat().split(" ");
					f2 = Float.parseFloat(s[0]);
				} else
					f2 = Float.parseFloat(laptops.get(j).getFiyat());
				if (laptops.get(i).getModelNo().equals(laptops.get(j).getModelNo())) {
					if (f1 <= f2) {
						repo.deleteById(laptops.get(j).get_id());
						laptops.remove(j);
					} else {
						repo.deleteById(laptops.get(i).get_id());
						laptops.remove(i);
						i--;
					}
					kontrol = 1;
				}
			}
		}
		if (kontrol == 1)
			return true;
		return false;
	}

	private boolean vatanTemizle() {
		int kontrol = 0;
		for (int i = 0; i < laptops.size(); i++) {
			if (!laptops.get(i).getSiteIsmi().equals("Vatan"))
				continue;
			Float f1 = Float.parseFloat(laptops.get(i).getFiyat());
			for (int j = i + 1; j < laptops.size(); j++) {
				Float f2 = Float.parseFloat(laptops.get(i).getFiyat());
				if (laptops.get(i).getModelNo().equals(laptops.get(j).getModelNo())) {
					if (f1 <= f2) {
						repo.deleteById(laptops.get(j).get_id());
						laptops.remove(j);
					} else {
						repo.deleteById(laptops.get(i).get_id());
						laptops.remove(i);
						i--;
					}
					kontrol = 1;
				}
			}
		}
		if (kontrol == 1)
			return true;
		return false;
	}
	
	public void mySiteOlustur()
	{
		List<Laptop> n11 = repo.getSite("n11");
		n11.stream().forEach(lp ->{
			lp.set_id(laptops.get((int) repo.count() - 1).get_id() + 1);
			lp.setSiteIsmi("OFBEG");
			lp.setSiteLinki("http://172.20.10.2:3000/"+lp.get_id());
			repo.save(lp);
			laptops = repo.findAll();
		});
	}
	public List<Laptop> getOFBEGAll(){
		mySite = repo.getSite("OFBEG");
		laptops= repo.findAll();
		return mySite;
	}

	public ArrayList<ArrayList<Laptop>> getAllequals() {
//		int kontrol = laptops.size();
//		if(cimri != null && kontrol == repo.count())
//			return cimri;
		laptops = repo.findAll();
		cimri=new ArrayList<ArrayList<Laptop>>();
		laptops.stream().forEach(lp -> {
			if (lp.getModelNo() != null && !modelNoKont(lp.getModelNo()) && !lp.getSiteIsmi().equals("Trendyol")
					&& !lp.getSiteIsmi().equals("hepsiburada")) {
				if (!isHave(cimri, lp.getModelNo())) {
					ArrayList<Laptop> eq = new ArrayList<Laptop>();
					eq = getFindByModelNo(lp.getModelNo());
					if(eq.size() != 1)
						cimri.add(eq);
				}
			}
		});
		// dbTemizle(cimri);
		return cimri;
	}

	private void dbTemizle(ArrayList<ArrayList<Laptop>> result) {
		laptops.stream().forEach(lp -> {
			int kontrol = 0;
			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < result.get(i).size(); j++) {
					if (lp.get_id() == result.get(i).get(j).get_id()) {
						kontrol = 1;
						break;
					}
				}
				if (kontrol == 1)
					break;
			}
			if (kontrol == 0) {
				delete(lp.get_id());
			}else {
				if(getFiyat(lp.getFiyat()) != 0) {
					String fiyat = String.valueOf(getFiyat(lp.getFiyat()));
					lp.setFiyat(fiyat);
				}
				if(lp.getPuan().contains("("))
				{
					String puan = lp.getPuan().substring(lp.getPuan().indexOf('(') + 1,lp.getPuan().indexOf(')'));
					lp.setPuan(puan);
				}
				repo.save(lp);
			}
		});

	}

	private boolean modelNoKont(String modelNo) {
		return (modelNo.equals("Nitro") || modelNo.equals("Gaming") || modelNo.toUpperCase().equals("LAPTOP")
				|| modelNo.equals("Asus") || modelNo.equals("590S") || modelNo.equals("Creator")
				|| modelNo.equals("15.6\""));
	}

	private ArrayList<Laptop> getFindByModelNo(String modelNo) {
		ArrayList<Laptop> result = new ArrayList<Laptop>();
		laptops.stream().forEach(lp -> {
			if (lp.getSiteIsmi().equals("Trendyol") || lp.getSiteIsmi().equals("hepsiburada")) {
				if (lp.getModelNo().toUpperCase().contains(modelNo.toUpperCase())) {
					int i = lp.getModelNo().toUpperCase().indexOf(modelNo.toUpperCase());
					if (i + modelNo.length() + 1 < lp.getModelNo().length()) {
						if (harfRakamKont(lp.getModelNo().charAt(i + modelNo.length()))) {

						} else
							result.add(lp);
					} else
						result.add(lp);
				}
			}
			if (lp.getModelNo().toUpperCase().equals(modelNo.toUpperCase())) {
				result.add(lp);
			}
		});
		return result;
	}

	private boolean harfRakamKont(char c) {
		return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '.');
	}

	public boolean create(Laptop lp) {
		lp.set_id(laptops.get((int) repo.count() - 1).get_id() + 1);
		Laptop kont = repo.eklenecekKont(lp.getModelNo(),"OFBEG");
		if(kont == null) {
			repo.save(lp);
			return true;
		}else {
			float fyeni = Float.parseFloat(lp.getFiyat());
			float fkont = Float.parseFloat(kont.getFiyat());
			if(fyeni < fkont) {
				delete(kont.get_id());
				repo.save(lp);
				return true;
			}
			else
				return false;
		}
	}

	public void delete(int l) {
		repo.deleteById(l);
	}

	private boolean isHave(ArrayList<ArrayList<Laptop>> lps, String modelNo) {
		for (int i = 0; i < lps.size(); i++) {
			for (int j = 0; j < lps.get(i).size(); j++) {
				if (lps.get(i).get(j).getModelNo().toUpperCase().equals(modelNo.toUpperCase())) {
					return true;
				}
			}
		}
		return false;
	}

	// Equalslardan gelen Tr ve hburadalari temizler
//	private ArrayList<Laptop> tveHTemizle(ArrayList<Laptop> eq) {
//		for (int i = 0; i < eq.size(); i++) {
//			if (eq.get(i).getSiteIsmi().equals("Trendyol") || eq.get(i).getSiteIsmi().equals("hepsiburada")) {
//				float f1 = getFiyat(eq.get(i).getFiyat());
//				for (int j = i + 1; j < eq.size(); j++) {
//					if (eq.get(j).getSiteIsmi().equals(eq.get(i).getSiteIsmi())) {
//						float f2 = getFiyat(eq.get(i).getFiyat());
//						if (f1 <= f2) {
//							eq.remove(j);
//							delete(laptops.get(j).get_id());
//							j--;
//						} else {
//							eq.remove(i);
//							delete(laptops.get(i).get_id());
//							i--;
//						}
//					}
//				}
//			}
//		}
//		System.out.println(eq.size());
//		return eq;
//	}

	private Float getFiyat(String fiyat) {
		String s[] = null;
		if (fiyat.contains(",")) {
			s = fiyat.split(",");
		} else if (fiyat.contains(" ")) {
			s = fiyat.split(" ");
		}
		float f1 = 0;
		if (s != null)
			f1 = Float.parseFloat(s[0]);
		return f1;
	}

	public void update(int id, String fiyat, String imageLinki, String puan) {
		Laptop lp = repo.getLaptop(id);
		if(fiyat != "")
			lp.setFiyat(fiyat);
		if(imageLinki != "")
			lp.setImageLinki(imageLinki);
		if(puan != "")
			lp.setPuan(puan);
		//System.out.println(fiyat+imageLinki+puan);
		repo.save(lp);
	}

	public List<Laptop> mySiteFilter(String bilgi) {
		String[] value = bilgi.split("=");
		if(bilgi.contains("marka")) {
			for(int i =0 ; i<mySite.size();i++) {
				if(!mySite.get(i).getMarka().toUpperCase().contains(value[1].toUpperCase())) {
					mySite.remove(i);
					i--;
				}
			}
		}else if(bilgi.contains("fiyat")) {
			String fval[] = value[1].split("-");
			float f1 = Float.parseFloat(fval[0]);
			float f2 = Float.parseFloat(fval[1]); ; 
			for(int i =0 ; i<mySite.size();i++) {
				float fiyat =Float.parseFloat(mySite.get(i).getFiyat());
				if(f2 !=0 ) {
					if (f1 <= fiyat && f2 >= fiyat) {
					}else {
						mySite.remove(i);
						i--;
					}
				}else {
					if (f1 <= fiyat) {
					}else {
						mySite.remove(i);
						i--;
					}
				}
			}
		}else if(bilgi.contains("ram")) {
			for(int i =0 ; i<mySite.size();i++) {
				if(!mySite.get(i).getRam().toUpperCase().contains(value[1].toUpperCase())) {
					mySite.remove(i);
					i--;
				}else {
					if(value[1].equals("4")) {
						if(mySite.get(i).getRam().contains("6") || mySite.get(i).getRam().contains("2"))
						{
							mySite.remove(i);
							i--;
						}
					}
				}
			}
		}else if(bilgi.contains("diskboyutu")) {
			for(int i =0 ; i<mySite.size();i++) {
				if(!mySite.get(i).getDiskBoyutu().toUpperCase().contains(value[1].toUpperCase())) {
					mySite.remove(i);
					i--;
				}
			}
		}else if(bilgi.contains("diskturu")) {
			for(int i =0 ; i<mySite.size();i++) {
				if(!mySite.get(i).getDiskTuru().toUpperCase().contains(value[1].toUpperCase())) {
					mySite.remove(i);
					i--;
				}
			}
		}else if(bilgi.contains("islemcitipi")) {
			for(int i =0 ; i<mySite.size();i++) {
				if(!mySite.get(i).getIslemciTipi().toUpperCase().contains(value[1].toUpperCase())) {
					mySite.remove(i);
					i--;
				}
			}
		}else if(bilgi.contains("isletimsistemi")) {
			for(int i =0 ; i<mySite.size();i++) {
				if(!mySite.get(i).getIsletimSistemi().toUpperCase().contains(value[1].toUpperCase())) {
					mySite.remove(i);
					i--;
				}
			}
		}else if(bilgi.contains("inc")) {
			for(int i =0 ; i<mySite.size();i++) {
				if(!mySite.get(i).getINC().toUpperCase().contains(value[1].toUpperCase())) {
					mySite.remove(i);
					i--;
				}
			}
		}
		return mySite;
	}
	public ArrayList<ArrayList<Laptop>> cimriFilter(String bilgi) {
		String[] value = bilgi.split("=");
		if(bilgi.contains("marka")) {
			for(int j=0;j<cimri.size();j++) {
				if(cimri.get(j).get(0).getMarka().toUpperCase().contains(value[1].toUpperCase())) {
				}else
				{
					cimri.remove(j);
					j--;
				}
			}
		}else if(bilgi.contains("ram")) {
			for(int j=0;j<cimri.size();j++) {
				if(cimri.get(j).get(0).getRam().toUpperCase().contains(value[1].toUpperCase())) {
					if(value[1].equals("4")) {
						if(cimri.get(j).get(0).getRam().contains("6")||cimri.get(j).get(0).getRam().contains("2")) {
							cimri.remove(j);
							j--;
						}
					}
				}else
				{
					cimri.remove(j);
					j--;
				}
			}
		}else if(bilgi.contains("diskboyutu")) {
			for(int j=0;j<cimri.size();j++) {
				if(cimri.get(j).get(0).getDiskBoyutu().toUpperCase().contains(value[1].toUpperCase())) {
				}else
				{
					cimri.remove(j);
					j--;
				}
			}
		}else if(bilgi.contains("diskturu")) {
			for(int j=0;j<cimri.size();j++) {
				if(cimri.get(j).get(0).getDiskTuru().toUpperCase().contains(value[1].toUpperCase())) {
				}else
				{
					cimri.remove(j);
					j--;
				}
			}
		}else if(bilgi.contains("islemcitipi")) {
			for(int j=0;j<cimri.size();j++) {
				if(cimri.get(j).get(0).getIslemciTipi().toUpperCase().contains(value[1].toUpperCase())) {
				}else
				{
					cimri.remove(j);
					j--;
				}
			}
		}else if(bilgi.contains("isletimsistemi")) {
			for(int j=0;j<cimri.size();j++) {
				if(cimri.get(j).get(0).getIsletimSistemi().toUpperCase().contains(value[1].toUpperCase())) {
				}else
				{
					cimri.remove(j);
					j--;
				}
			}
		}else if(bilgi.contains("inc")) {
			for(int j=0;j<cimri.size();j++) {
				if(cimri.get(j).get(0).getINC().toUpperCase().contains(value[1].toUpperCase())) {
				}else
				{
					cimri.remove(j);
					j--;
				}
			}
		}
		return cimri;
	}
	public List<Laptop> sirala(String bilgi,String bilgi2) {
		if (bilgi.equals("fiyat")) {
			return fiyatSirala(bilgi2);
		}
		else
			return puanSirala(bilgi2);
	}
	private List<Laptop> fiyatSirala(String b) {
		int kontrol;
		for(int i = 0;i< mySite.size();i++) {
			kontrol = 0;
			for(int j = 0;j< mySite.size()-1;j++) {
				Float f1=Float.parseFloat(mySite.get(j).getFiyat());
				Float f2=Float.parseFloat(mySite.get(j + 1).getFiyat());
				if(b.equals("y")) {
					if(f1 > f2) {
						Laptop lp = mySite.get(j);
						mySite.set(j,mySite.get(j+1));
						mySite.set(j + 1, lp);
						kontrol =1;
					}
				}else {
					if(f1 < f2) {
						Laptop lp = mySite.get(j);
						mySite.set(j,mySite.get(j+1));
						mySite.set(j + 1, lp);
						kontrol =1;
					}
				}
			}
			if(kontrol==0)
				break;
		}
		return mySite;
	}

	private List<Laptop> puanSirala(String b){
		int kontrol;
		for(int i = 0;i< mySite.size();i++) {
			kontrol = 0;
			for(int j = 0;j< mySite.size()-1;j++) {
				int f1=Integer.parseInt(mySite.get(j).getPuan());
				int f2=Integer.parseInt(mySite.get(j + 1).getPuan());
				if(b.equals("y")) {
					if(f1 > f2) {
						Laptop lp = mySite.get(j);
						mySite.set(j,mySite.get(j+1));
						mySite.set(j + 1, lp);
						kontrol = 1;
					}
				}else {
					if(f1 < f2) {
						Laptop lp = mySite.get(j);
						mySite.set(j,mySite.get(j+1));
						mySite.set(j + 1, lp);
						kontrol =1;
					}
				}
			}
		}
		return mySite;
	}

	public Laptop getById(int id) {
		return repo.getLaptop(id);
	}



}
