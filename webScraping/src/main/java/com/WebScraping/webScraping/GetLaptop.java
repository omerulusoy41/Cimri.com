package com.WebScraping.webScraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GetLaptop{
	DatabaseCR db =new DatabaseCR();
	
	public void n11()
	{
		try {
			String url = "https://www.n11.com/bilgisayar/dizustu-bilgisayar?q=laptop";
			Laptop laptop =new Laptop();
			for(int i = 2;i<40;i++ )
			{
				Document doc = Jsoup.connect(url).get();
				Elements card = doc.getElementsByClass("pro");
				for(int j = 0;j<card.size();j++)
				{	
					Elements cntSite=card.get(j).getElementsByClass("plink");
					laptop.setSiteLink(cntSite.attr("href"));
					Elements cntImg=card.get(j).getElementsByClass("lazy cardImage");
					laptop.setImgLink(cntImg.attr("data-src"));
					Elements cntPuan = card.get(j).getElementsByClass("ratingText");
					laptop.setPuan(cntPuan.text());
					Elements cntFiyat = card.get(j).getElementsByTag("ins");
					String[] s = cntFiyat.text().split(",");
					if(s.length != 0)
						laptop.setFiyat(s[0]);
					
					laptop.setSiteIsmi("n11");
					
					Document doc2= Jsoup.connect(laptop.getSiteLink()).get();
					Elements card2 = doc2.getElementsByClass("unf-prop-context");
					if(card2.size() !=0)
					{
						Elements cntTit = card2.get(0).getElementsByClass("unf-prop-list-title");
						Elements cntInfo = card2.get(0).getElementsByClass("unf-prop-list-prop");
						for(int k = 0;k<cntTit.size();k++)
						{
							String strTit = tE(cntTit.get(k).text());
							String info=tE(cntInfo.get(k).text());
							//System.out.println(str);
							if(strTit.equals("Isletim Sistemi"))
							{
								laptop.setIsletimSistemi(info);
								//System.out.println(laptop.getIsletimSistemi());
							}else if(strTit.equals("Disk Turu"))
							{
								laptop.setDiskTur(info);
								//System.out.println(laptop.getDiskTur());
							}else if(strTit.equals("Marka"))
							{
								laptop.setMarka(info);
								
							}else if(strTit.equals("Model"))
							{
								String[] split = info.split(" ");
								laptop.setModelNo(split[split.length-1]);
								//System.out.println(laptop.getModelNo());
							}else if(strTit.equals("Islemci Modeli"))
							{
								laptop.setIslemciTipi(info);
								//System.out.println(laptop.getIslemciTipi());
							}else if(strTit.equals("Ekran Boyutu"))
							{
								laptop.setInc(info);
								//System.out.println(laptop.getInc());
							}else if(strTit.equals("Bellek Kapasitesi"))
							{
								laptop.setRam(info);
								//System.out.println(laptop.getRam());
							}else if(strTit.equals("Disk Kapasitesi"))
							{
								laptop.setDiskBoyut(info);
								//System.out.println(laptop.getDiskBoyut());
							}
						}
					}
					if(laptop.getModelNo() != null && laptop.getModelNo().length() > 4)
					{
						String[] s2 = laptop.getModelNo().split(" ");
						laptop.setModelNo(s2[s2.length-1]);
						db.insert(laptop);
						laptop.setModelNo(null);
					}
				}
				url= "https://www.n11.com/bilgisayar/dizustu-bilgisayar?q=laptop&pg="+i;
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void teknosa()
	{
		Document doc;
		try {
			Laptop laptop =new Laptop();
			String url = "https://www.teknosa.com/arama/?s=laptop";
			for(int i = 1;i<22;i++)
			{
				doc = Jsoup.connect(url).get();	
				Elements card = doc.getElementsByClass("prd");
				for (int j = 0 ; j<card.size();j++)
				{
					laptop.setSiteIsmi("Teknosa");
					Elements cntSite =card.get(j).getElementsByClass("prd-link");
					laptop.setSiteLink("https://www.teknosa.com"+cntSite.attr("href"));
					
					laptop.setImgLink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5FGMEwIkOuwZXgtqmyo3mlXF_AC0F7Pi0_g&usqp=CAU");
					
					Elements cntFiyat =card.get(j).getElementsByClass("prd-prc2");
					String[] s = cntFiyat.text().split(",");
					if(s.length != 0)
						laptop.setFiyat(s[0]);
					laptop.setPuan("0");
					
					Document doc2 = Jsoup.connect(laptop.getSiteLink()).get();
					Elements card2 = doc2.getElementsByClass("ptf-body");
					Elements cntMarka=doc2.getElementsByClass("pdp-base");
					if(cntMarka.size()!=0)
						laptop.setMarka(cntMarka.get(0).getElementsByTag("b").text());
					if(card2.size() !=0 )
					{
						Elements cntTit = card2.get(0).getElementsByTag("th");
						Elements cntInfo = card2.get(0).getElementsByTag("td");
						for(int k = 0; k<cntTit.size();k++)
						{
							String tit = tE(cntTit.get(k).text());
							String info = tE(cntInfo.get(k).text());
							 if(tit.equals("Model Kodu"))
							 {
								laptop.setModelNo(info);
							 }else if(tit.equals("Isletim Sistemi Yazilimi"))
							{
								laptop.setIsletimSistemi(info);
								//System.out.println(laptop.getIsletimSistemi());
							}else if(tit.equals("Disk Turu"))
							{
								laptop.setDiskTur(info);
								//System.out.println(laptop.getDiskTur());
							}else if(tit.equals("Marka"))
							{
								laptop.setMarka(info);
								
							}else if(tit.equals("Islemci Nesli"))
							{
								laptop.setIslemciTipi(info);
								//System.out.println(laptop.getIslemciTipi());
							}else if(tit.equals("Ekran Boyutu"))
							{
								laptop.setInc(info);
								//System.out.println(laptop.getInc());
							}else if(tit.equals("Ram"))
							{
								laptop.setRam(info);
								//System.out.println(laptop.getRam());
							}else if(tit.equals("SSD Kapasitesi"))
							{
								if(!info.equals("Yok"))
									laptop.setDiskBoyut(info);
								//System.out.println(laptop.getDiskBoyut());
							}else if(tit.equals("HDD Kapasitesi"))
							{
								if(!info.equals("Yok"))
									laptop.setDiskBoyut(info);
								//System.out.println(laptop.getDiskBoyut());
							}
						}
					}
					if(laptop.getModelNo() == null)
					{
						String[] split = cntMarka.text().split(" ");
						if(split.length > 5)
						{
							laptop.setModelNo(split[2]);
							if(laptop.getMarka().equals("Asus"))
								laptop.setModelNo(split[1]);
							else if(laptop.getMarka().equals("Monster"))
								laptop.setModelNo(split[3]);
						}
					}
					if(laptop.getDiskTur().equals("HDD - SSD"))
						laptop.setDiskTur("SSD");
					if(laptop.getModelNo() != null && laptop.getModelNo().length() > 4)
					{
						String[] s2 = laptop.getModelNo().split(" ");
						laptop.setModelNo(s2[s2.length-1]);
						db.insert(laptop);
						laptop.setModelNo(null);
					}
				}
				Thread.sleep(1000);
				url ="https://www.teknosa.com/arama?s=laptop%3Arelevance&page="+i;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void vatan()
	{
		
		Document doc;
		try {
			String url = "https://www.vatanbilgisayar.com/notebook/";
			Laptop laptop =new Laptop();
			for(int i = 2;i<20;i++)
			{
				doc = Jsoup.connect(url).get();	
				Elements card = doc.getElementsByClass("product-list product-list--list-page");
				for (int j = 0 ; j<card.size();j++)
				{
					
					laptop.setSiteIsmi("Vatan");
					Elements cntSite =card.get(j).getElementsByClass("product-list__image-safe-link sld");
					laptop.setSiteLink("https://www.vatanbilgisayar.com"+cntSite.attr("href"));
					
					Elements cntFiyat =card.get(j).getElementsByClass("product-list__price");
					laptop.setFiyat(cntFiyat.text());
					//System.out.println(laptop.getFiyat());
					Elements cntImg =card.get(j).getElementsByClass("lazyimg");
					laptop.setImgLink(cntImg.attr("data-src"));
					
					
					Elements cntPuan =card.get(j).getElementsByClass("comment-count");
					laptop.setPuan(cntPuan.text());
					
					Document doc2 = Jsoup.connect(laptop.getSiteLink()).get();
					Elements card2 = doc2.getElementsByClass("product-list__product-code pull-left product-id");
					laptop.setModelNo(card2.attr("data-productcode"));
					
					Elements cntMarka = doc2.getElementsByClass("wrapper-product-brand");
					if(cntMarka.size()!=0)
						laptop.setMarka(cntMarka.get(0).getElementsByTag("img").attr("title"));
					
					Elements card3 = doc2.getElementsByAttributeValue("data-count", "0");
					//System.out.println(card3);
					for(int k=0; k<card3.size();k++)
					{
						String strTit=tE(card3.get(k).text()); 
//						System.out.println(strTit);
//						System.out.println("--");
						String info = tE(card3.get(k).getElementsByTag("p").text());
						//System.out.println(info);
						if(strTit.contains("Isletim Sistemi"))
						{
							laptop.setIsletimSistemi(info);
							//System.out.println(laptop.getIsletimSistemi());
						}else if(strTit.contains("Disk Turu"))
						{
							laptop.setDiskTur(info);
							//System.out.println(laptop.getDiskTur());
						}else if(strTit.contains("Islemci Nesli"))
						{
							laptop.setIslemciTipi(info);
							//System.out.println(laptop.getIslemciTipi());
						}else if(strTit.contains("Ekran Boyutu"))
						{
							laptop.setInc(info);
							//System.out.println(laptop.getInc());
						}else if(strTit.contains("Ram (Sistem Bellegi"))
						{
							laptop.setRam(info);
							//System.out.println(laptop.getRam());
						}else if(strTit.contains("Disk Kapasitesi"))
						{
							if(info.contains("Izle"))
								info = info.substring(0, info.length()-4);
							laptop.setDiskBoyut(info);
							//System.out.println(laptop.getDiskBoyut());
						}
					}
					if(laptop.getModelNo()!=null && laptop.getModelNo().length() > 4)
					{
						db.insert(laptop);
						laptop.setModelNo(null);
					}
					//lp.add(laptop);
				}
				url ="https://www.vatanbilgisayar.com/notebook/?page="+i;
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void trendyol()
	{
		String url ="https://www.trendyol.com/sr?q=laptop&qt=laptop&st=laptop&os=1";
		try {
			Laptop laptop = new Laptop();
			for(int j=2; j < 50; j++)
			{
				Document doc = Jsoup.connect(url).get();
				Elements card= doc.getElementsByClass("p-card-wrppr with-campaign-view");
				for(int i=0;i<card.size();i++)
				{
					laptop.setSiteIsmi("Trendyol");
					Elements cntSite = card.get(i).getElementsByTag("a");
					laptop.setSiteLink("https://www.trendyol.com"+cntSite.get(0).attr("href"));
					
					Elements cntBaslik = card.get(i).getElementsByClass("p-card-img");
					if(cntBaslik.size()!=0)
						laptop.setModelNo(tE(cntBaslik.get(0).attr("alt")));
				
					Elements cntPuan = card.get(i).getElementsByClass("ratings");
					if(cntPuan.size() > 0)
						laptop.setPuan(cntPuan.get(0).getElementsByTag("span").text());
					else
						laptop.setPuan("(0)");
					
					Elements cntFiyat = card.get(i).getElementsByClass("prc-box-dscntd");
					laptop.setFiyat(cntFiyat.text());
					
					db.insert(laptop);
				}
				Thread.sleep(1000);
				url = "https://www.trendyol.com/sr?q=laptop&qt=laptop&st=laptop&os=1&pi="+j;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void hepsiburada()
	{
		String url ="https://www.hepsiburada.com/ara?q=Laptop&kategori=2147483646_3000500_98";
		try {
			Laptop laptop = new Laptop();
			for(int j=2; j < 50; j++)
			{
				Document doc = Jsoup.connect(url).get();
				Elements card= doc.getElementsByClass("productListContent-zAP0Y5msy8OHn5z7T_K_");
				//System.out.println(card);
				for(int i=0;i<card.size();i++)
				{
					laptop.setSiteIsmi("hepsiburada");
					Elements cntSite = card.get(i).getElementsByTag("a");
					laptop.setSiteLink("https://www.hepsiburada.com"+cntSite.get(0).attr("href"));
					if(cntSite.size() != 0)
						laptop.setModelNo(tE(cntSite.get(0).attr("title")));
					laptop.setPuan("(0)");
					
					Elements cntFiyat = card.get(i).getElementsByAttributeValue("data-test-id", "price-current-price");
					laptop.setFiyat(cntFiyat.text());
					//System.out.println(laptop.getFiyat());
				
					db.insert(laptop);
				}
				Thread.sleep(1000);
				url = "https://www.hepsiburada.com/ara?q=Laptop&kategori=2147483646_3000500_98&sayfa="+j;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private String tE(String str) {
		  String ret = str;
			char[] turkishChars = new char[] {0x131, 0x130, 0xFC, 0xDC, 0xF6, 0xD6, 0x15F, 0x15E, 0xE7, 0xC7, 0x11F, 0x11E};
			char[] englishChars = new char[] {'i', 'I', 'u', 'U', 'o', 'O', 's', 'S', 'c', 'C', 'g', 'G'};
			for (int i = 0; i < turkishChars.length; i++) {
				ret = ret.replaceAll(new String(new char[]{turkishChars[i]}), new String(new char[]{englishChars[i]}));
			}
			return ret;
	}
}
