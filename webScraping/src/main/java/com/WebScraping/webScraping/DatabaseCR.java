package com.WebScraping.webScraping;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.ErrorCategory;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DatabaseCR {
	 public static int ID = 1;
	  final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	  final	MongoDatabase database = mongoClient.getDatabase("admin");
	  final MongoCollection collection = database.getCollection("Deneme");
	  List<Laptop> laptops;
		 public  void insert(Laptop laptop)
		 {
	            Document lp = new Document();
	  
	
	            lp.append("_id", ID++)
	                    .append("marka", laptop.getMarka())
	                    .append("ModelNo",laptop.getModelNo())
	                    .append("IsletimSistemi", laptop.getIsletimSistemi())
	                    .append("IslemciTipi",laptop.getIslemciTipi() )
	            		.append("Ram",laptop.getRam())
	            		.append("DiskBoyutu",laptop.getDiskBoyut())
	            		.append("DiskTuru",laptop.getDiskTur())
	            		.append("INC",laptop.getInc())
	            		.append("Puan",laptop.getPuan())
	            		.append("Fiyat",laptop.getFiyat())
	            		.append("SiteIsmi",laptop.getSiteIsmi())
	            		.append("SiteLinki",laptop.getSiteLink())
	            		.append("ImageLinki",laptop.getImgLink());
	            		
	            try {
	                collection.insertOne(lp);
	                System.out.println("Successfully inserted documents. \n");
	            } catch (MongoWriteException mwe) {
	                if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
	                    System.out.println("Document with that id already exists");
	                }
	            }
		 }
		 public void listele()
		 {
			  laptops = (List<Laptop>) collection.find().into(new ArrayList<>());
			 for (Laptop lp : laptops) {
			     System.out.println(lp.getFiyat());
			 }
		 }
//			public ArrayList<ArrayList<Laptop>> getAllequals()
//			{
////				ArrayList<ArrayList<Laptop>> result = new ArrayList<ArrayList<Laptop>>();
////				laptops.stream()
////					.forEach(lp ->{
////						if ( !isHave(result,lp.getModelNo())&&lp.getModelNo()!=null && !lp.getSiteIsmi().equals("Trendyol") && !lp.getSiteIsmi().equals("hepsiburada"))
////						{
////							if(!modelNoKont(lp.getModelNo()))
////							{
////								ArrayList<Laptop> eq = new ArrayList<Laptop>();
////								eq = getFindByModelNo(lp.getModelNo());
////								if(eq.size() != 1)
////								{
////									result.add(eq);
////								}
////							}
////						}
////					});
////				System.out.println(result.size());
////				return result;
//			}
}
