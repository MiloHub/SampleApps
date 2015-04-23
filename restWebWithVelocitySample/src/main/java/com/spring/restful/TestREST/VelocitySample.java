package com.spring.restful.TestREST;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.json.simple.JSONValue;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class VelocitySample {

	public static HelloWorld hm = new HelloWorld();

	public static String fileToString(String file) {
		String result = null;
		DataInputStream in = null;

		try {
			File f = new File(file);
			byte[] buffer = new byte[(int) f.length()];
			in = new DataInputStream(new FileInputStream(f));
			in.readFully(buffer);
			result = new String(buffer);
		} catch (IOException e) {
			throw new RuntimeException("IO problem in fileToString", e);
		} finally {
			try {
				in.close();
			} catch (IOException e) { /* ignore it */
			}
		}
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public static Map printJson(String jsonText,
			ContainerFactory containerFactory, JSONParser parser,
			Map<String, List<String>> m, Stack<String> key)
			throws ParseException, ResourceNotFoundException,
			ParseErrorException, MethodInvocationException, IOException {
		Object jsonObject = (Object) parser.parse(jsonText, containerFactory);
		System.out.println("jsonObject.." + jsonObject);
		Map json = null;
		LinkedList ls = null;

		String keytemp = key.empty() ? "" : key.peek();

		if (jsonObject instanceof LinkedHashMap) {
			json = (Map) jsonObject;
			List field = new ArrayList<String>();
			Iterator iter = json.entrySet().iterator();
			// System.out.println("==iterate result==");
			int count = json.entrySet().size();
			if (count == 0) {
				field.clear();
				String temp1 = key.pop();

				return m;
			}
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				// System.out.println(entry.getKey() + "=>" + entry.getValue());
				String jsontemp = JSONValue.toJSONString(entry.getValue());
				// System.out.println("--" + jsontemp);
				if (entry.getValue() != null
						&& (entry.getValue().toString().startsWith("{") || entry
								.getValue().toString().startsWith("["))) {
					// hm.createClass(entry.getKey().toString(),
					// entry.getKey().toString());
					if (m.get(keytemp) != null) {
						List<String> temp = new ArrayList<String>(
								m.get(keytemp));
						String prefixType = "";
						if(entry
						.getValue().toString().startsWith("[")){
							prefixType = "ARRAY";
						}else{
							prefixType = "OBJ";
						}
						temp.add(prefixType+"_"+(entry.getKey()).toString());
						m.put(keytemp, temp);
					}
					key.push(entry.getKey().toString());
					field.clear();
					m.put(entry.getKey().toString(), field);

					jsontemp = JSONValue.toJSONString(entry.getValue());
					// System.out.println("->"+jsontemp);
					printJson(jsontemp, containerFactory, parser, m, key);
				} else {
					List<String> temp = new ArrayList<String>(m.get(keytemp));
					temp.add((entry.getKey()).toString());
					m.put(keytemp, temp);
				}

			}

		} else if (jsonObject instanceof LinkedList) {
			ls = (LinkedList) jsonObject;
			Iterator it = ls.iterator();
			while (it.hasNext()) {
				Object jsonObject1 = (Object) it.next();
				if (jsonObject1 instanceof LinkedHashMap) {
					printJson(JSONValue.toJSONString(jsonObject1),
							containerFactory, parser, m, key);

				}
			}
		}
		return m;
	}

	public static void main(String[] args) throws FileNotFoundException {

		String jsonText = "{\"first\": 123, \"second\": [4, 5, 6], \"third\": 789}";
		jsonText = fileToString("C:/dhanaraj/dd.txt");
		JSONParser parser = new JSONParser();

		ContainerFactory containerFactory = new ContainerFactory() {
			public List creatArrayContainer() {
				return new LinkedList();
			}

			public Map createObjectContainer() {
				return new LinkedHashMap();
			}

		};

		try {

			try {
				Map<String, List<String>> m = new HashMap<String, List<String>>();
				 m = printJson(jsonText, containerFactory, parser, m,
						new Stack<String>());
				System.out.println("==toJSONString()==");
				System.out.println(JSONValue.toJSONString(m.get(0)));
				List<String> f = m.get(0);
				hm.createClass("name", m);
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseErrorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MethodInvocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ParseException pe) {
			System.out.println(pe);
		}
	}
}
