package bbdn.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public abstract class RestRequest {
	
	private static final Logger log = LoggerFactory.getLogger(RestRequest.class);
	
	public static String sendRequest(String sUri, HttpMethod method, String access_token, String body) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
		    protected boolean hasError(HttpStatus statusCode) {
		        return false;
		    }});
        
        URI uri = null;
		try {
			uri = new URI(RestConstants.HOSTNAME + sUri);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Authorization", "Bearer " + access_token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		log.info("Request Headers: " + headers.toString());
		
		HttpEntity<String> request = new HttpEntity<String>(body, headers);
		log.info("Request Body: " + request.getBody());
		
		ResponseEntity<String> response = restTemplate.exchange(uri, method, request, String.class);
		log.info("Response: " + response);
        
        return (response.toString());
	}
}
