package com.sumeet.contactapp.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sumeet.contactapp.bean.Facts;

public class AppClient {
	
	static String factsURL="https://factsbox.herokuapp.com/";
	static Client client = javax.ws.rs.client.ClientBuilder.newClient();
	
	public List<Facts> allFacts() throws Exception{
		List<Facts> allfacts=new ArrayList<Facts>();
		Response res=client.target(factsURL)
				.path("api")
				.path("FactAPI")
				.path("allFacts")
				.request()
				.accept(MediaType.APPLICATION_JSON)
				.get();
		
		GenericType<List<Facts>> result=new GenericType<List<Facts>>(){};
		List<Facts> newResult=null;
		
		if(res.getStatus()==200){
			newResult=res.readEntity(result);
			
		}else{
			res.readEntity(String.class);
		}
		
		if(newResult!=null){
			for (Facts facts : newResult) {
				allfacts.add(facts);
			}
		}		
		return allfacts;
		
	}
	
	/*public static void main(String[] args)throws Exception {
		AppClient c=new AppClient();
		System.out.println(c.allFacts());
	}*/

}
