package serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;

import mapper.GoogleGeoCode;
import service.CityInterface;

public class CityServiceImpl implements CityInterface {

	@Override
	@SuppressWarnings("deprecation")
	public String  getGeoCode(String address, boolean ssl)  {
		
		
		 StringBuilder url = new StringBuilder("http");
		    if ( ssl ) {
		        //url.append("s");
		    }
		  
		    //url.append("://maps.googleapis.com/maps/api/geocode/json?");
		    url.append("://api.positionstack.com/v1/forward?");
		  
		    if ( ssl ) {
		        url.append("access_key=");
		        url.append("87ba7d4070e64ee897e0b2c75e131dbe");
		        url.append("&");
		    }
		    url.append("query=");
		    url.append( URLEncoder.encode(address) );
		  
		    
		      try  {
		    	  CloseableHttpClient httpclient = HttpClients.createDefault();
		        HttpGet request = new HttpGet(url.toString());

		        // set common headers (may useless)
//		        request.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:31.0) Gecko/20100101 Firefox/31.0 Iceweasel/31.6.0");
//		        request.setHeader("Host", "maps.googleapis.com");
//		        request.setHeader("Connection", "keep-alive");
//		        request.setHeader("Accept-Language", "en-US,en;q=0.5");
//		        request.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//		        request.setHeader("Accept-Encoding", "gzip, deflate");

		         try(CloseableHttpResponse response = httpclient.execute(request)) {
		            HttpEntity entity = response.getEntity();

		            // recover String response (for debug purposes)
		            StringBuilder result = new StringBuilder();
		             try(BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()))) {
		                String inputLine;
		                while ((inputLine = in.readLine()) != null) {
		                    result.append(inputLine);
		                    result.append("\n");
		                }
		            }

		            // parse result
		            ObjectMapper mapper = new ObjectMapper();
		            String geocode = result.toString();
//		            System.out.println(geocode.getStatus());
//		            System.out.println(geocode.getError_message());
//
//		            if (!"OK".equals(geocode.getStatus())) {
//		            	if (geocode.getError_message() != null) {
//		                    throw new Exception(geocode.getError_message());
//		                }
//		                throw new Exception("Can not find geocode for: " + address);
//		            }
		            return geocode;
		        }
		     }catch(Exception e) {
		    	 e.printStackTrace();
		     }
		      return null;
	}

	
	
	
	

}
