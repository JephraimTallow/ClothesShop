package com.bjss.clothesStore;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import com.bjss.CRUD.CreatedUser;
import com.bjss.CRUD.OuterResponse;
import com.bjss.CRUD.UpdatedUser;
import com.bjss.CRUD.UserData;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CRUDTest {
	
	@Test
	public void createTest() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			URL url = new URL("https://reqres.in/api/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			conn.setRequestProperty("conntent-Type", "application/json;charset=UTF-8");
		
			// Send post request
			conn.setDoOutput(true);
		    conn.setDoInput(true);
		    
		    DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		    wr.write("{\"name\": \"Wesson\",\"job\": \"Archer\"}".getBytes("UTF-8"));
		    wr.flush();
		    wr.close();
			
		    int responseCode = conn.getResponseCode();
		    assertEquals("Response code incorrect", responseCode, 201);
		    
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer conntent = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				conntent.append(inputLine);
			}
			in.close();
			
			String conntentString = conntent.toString();
			CreatedUser resp = objectMapper.readValue(conntentString, CreatedUser.class);
			assertTrue("Name is incorrect", resp.getName().equals("Wesson"));
			
		} catch (Exception ex) {
			
		}
	}
	
	@Test
	public void readTest() {
		try {
			URL url = new URL("https://reqres.in/api/users?page=2");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			conn.setRequestProperty("conntent-Type", "application/json");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer conntent = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				conntent.append(inputLine);
			}
			in.close();
			
			String conntentString = conntent.toString();
			assertTrue(conntentString.contains("total_pages"));
			
			ObjectMapper objectMapper = new ObjectMapper();
			OuterResponse resp = objectMapper.readValue(conntentString, OuterResponse.class);

			assertEquals("Incorrect number of users returned", resp.getData().size(), 3);
			
			for (UserData userData : resp.getData()) {
				if (userData.getId().equals("4")) {
					assertTrue("User first name is incorrect", userData.getFirst_name().equals("Eve"));
				}
				if (userData.getId().equals("6")) {
					assertTrue("User avatar is incorrect", userData.getAvatar()
							.equals("https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg"));
				}
			}
			
		} catch (Exception ex) {
			
		}
	}

	@Test
	public void updateTest() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			URL url = new URL("https://reqres.in/api/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			conn.setRequestProperty("conntent-Type", "application/json;charset=UTF-8");
		
			// Send post request
			conn.setDoOutput(true);
		    conn.setDoInput(true);
		    
		    DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		    wr.write("{\"name\": \"Wesson\",\"job\": \"Skier\"}".getBytes("UTF-8"));
		    wr.flush();
		    wr.close();
			
		    int responseCode = conn.getResponseCode();
		    assertEquals("Response code incorrect", responseCode, 200);
		    
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer conntent = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				conntent.append(inputLine);
			}
			in.close();
			
			String conntentString = conntent.toString();
			UpdatedUser resp = objectMapper.readValue(conntentString, UpdatedUser.class);
			assertTrue("Response has no updated user value", resp.getUpdatedAt().contains("updatedAt"));
			
		} catch (Exception ex) {
			
		}
	}
	
	@Test
	public void deleteTest() {
		try {
			URL url = new URL("https://reqres.in/api/users/2");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			conn.setRequestProperty("conntent-Type", "application/json;charset=UTF-8");
			
		    int responseCode = conn.getResponseCode();
		    assertTrue("Response code is not correct", responseCode == 204);
		    
		} catch (Exception ex) {
			
		}
	}
}
