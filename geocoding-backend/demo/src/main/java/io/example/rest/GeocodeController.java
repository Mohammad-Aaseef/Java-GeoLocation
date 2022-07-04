package io.example.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.CityInterface;
import serviceImpl.CityServiceImpl;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import mapper.GoogleGeoCode;
import mapper.helloWorldBean;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import java.net.URLEncoder;
import java.util.Optional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "*")
@RestController
public class GeocodeController {

	final static Logger logger = Logger.getLogger(GeocodeController.class);
	//CityInterface city;
	
	
	
//	 @RequestMapping(path = "/geocode", method = RequestMethod.GET )
//	   public String getGeocode(@RequestParam String address) throws IOException {
//	       OkHttpClient client = new OkHttpClient();
//	       String encodedAddress = URLEncoder.encode(address, "UTF-8");
//	       Request request = new Request.Builder()
//	               .url("https://google-maps-geocoding.p.rapidapi.com/geocode/json?language=en&address=" + encodedAddress)
//	               .get()
//	               .addHeader("x-rapidapi-host", "google-maps-geocoding.p.rapidapi.com")
//	               .addHeader("x-rapidapi-key", "069d95fe4amshbf38cbf4b7f20cep150317jsnbadc5ab3cae6")
//	               .build();
//	       ResponseBody responseBody = client.newCall(request).execute().body();
//	       return responseBody.string();
//	   }
	 
	 @GetMapping(path="/helloworld")
		public helloWorldBean helloWorld() {
		 
		// return ResponseEntity.of(Optional.of("hello"));
			return new helloWorldBean("helloworld");
		}
	 
//	 @RequestMapping(path = "/geocode", method = RequestMethod.GET )
//	 public GoogleGeoCode getGeoCode(@RequestParam String address, @RequestParam boolean ssl) {
//		 
//		 GoogleGeoCode geo = new GoogleGeoCode();
//		 CityServiceImpl city = new CityServiceImpl();
//		 
//		 return Optional.ofNullable(city.getGeoCode(address, ssl))
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "item not found"));
//		 }
	 
	
//	 @RequestMapping(path = "/geocode", method = RequestMethod.GET )
//	 public ResponseEntity<GoogleGeoCode> getGeoCode(@RequestParam String address, @RequestParam boolean ssl) {
//		 
//		 GoogleGeoCode geo = new GoogleGeoCode();
//		 CityServiceImpl city = new CityServiceImpl();
//		 try {
//			 Optional<GoogleGeoCode> result = Optional.of(city.getGeoCode(address, ssl));
//			 
//			 if(result.isPresent()) {
//				 
//				  geo=result.get();
//				 return ResponseEntity.of(Optional.of(geo));
//			 }
//		 }catch (Exception e ) {
//			 logger.error(e);
//		 }
//		 return null;
//		 }
	 @RequestMapping("/")
	    public String index() {
	        logger.trace("A TRACE Message");
	        logger.debug("A DEBUG Message");
	        logger.info("An INFO Message");
	        logger.warn("A WARN Message");
	        logger.error("An ERROR Message");

	        return "Howdy! Check out the Logs to see the output...";
	    }

	 @RequestMapping(path = "/geocode", method = RequestMethod.GET )
	 public ResponseEntity<String> getGeoCode(@RequestParam String address, @RequestParam boolean ssl) {
		 
		 GoogleGeoCode geo = new GoogleGeoCode();
		 CityServiceImpl city = new CityServiceImpl();
		// GoogleGeoCode result = city.getGeoCode(address, ssl);
		 
			 String result = city.getGeoCode(address, ssl);
//		 if(result.getResults().length <=0 || !"OK".equals(result.getStatus())) {
//			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		 }else {
//		 geo.setStatus(result.getStatus());
//		 geo.setError_message(result.getError_message());
//		 geo.setExclude_from_slo(result.getExclude_from_slo());
//		 geo.setResults(result.getResults());
//		// return ResponseEntity.of(Optional.of(geo));
//		 }
		 return ResponseEntity.of(Optional.of(result));
		 
		 }

}
