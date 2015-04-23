package com.spring.restful.controller;

import java.io.IOException;


public class Convertor {
	
	
	public static void testA() throws IOException{
		
		String s=  "{"+  "\"test\""+ ":" +"\"tesA\""+"}";
		
		//System.out.println(s);
		
		/*Reader reader = new BufferedReader(new FileReader(new File("C:/dhanaraj/dd.txt")));
		JsonReader js = new JsonReader(reader);
		    js.beginObject();
		    while(js.hasNext()){
		JsonToken jt= js.peek();
		System.out.println(jt.name().toString());
		if(jt.name().toString().equals(JsonToken.NUMBER.toString())){
			System.out.println(js.nextInt());
		   
		}*/
		 
		 //   }
		
	}
	
	
	StringBuilder createMap(StringBuilder sb){
				
		return sb;
		
	}
	
	public static void main(String[] args) throws IOException {
		testA();
	}

}
