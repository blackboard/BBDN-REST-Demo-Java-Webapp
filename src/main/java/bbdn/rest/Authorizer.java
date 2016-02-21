package bbdn.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class Authorizer {
	
	private String host = "";
	private String key = "";
	private String secret = "";
	

    private static final Logger log = LoggerFactory.getLogger(Authorizer.class);

    public Authorizer(String key, String secret, String host ) {
    	this.key = key;
    	this.secret = secret;
    	this.host = host;
    }
    
    public Authorizer () {
    	this("d03caa33-1095-47b9-bc67-f5cd634430b1", "QSFClAMu5KmoG8yFbHTi7pjhsseJl4uz", "ultra-integ.int.bbpd.io");
    }
    
    public String authorize() {
    	
    	RestTemplate restTemplate = new RestTemplate();
        
        URI uri = null;
		try {
			uri = new URI("https://" + host + "/learn/api/public/v1/oauth2/token");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + getHash());
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		log.info("Request Headers: " + headers.toString());
		HttpEntity<String> request = new HttpEntity<String>("grant_type=client_credentials",headers);
		log.info("Request Body: " + request.getBody());
		ResponseEntity<Token> response = restTemplate.exchange(uri, HttpMethod.POST, request, Token.class);
		log.info("Response: " + response.toString());
        Token token = response.getBody();
        
        log.info("Access Token: " + token.toString());
        return (token.getToken());
    }
    
    private String getHash() {
    	
    	String hashable = this.key + ":" + this.secret;
    	log.info("Value to hash: " + hashable);
    	String hash = Base64.getEncoder().encodeToString(hashable.getBytes());
    	log.info("Hashed Value: " + hash);
    	
    	return(hash);
    	
    }
    
    public String getHost() {
    	return(this.host);
    }
    
    public void setHost(String host) {
    	this.host = host;
    }

    public String getKey() {
    	return(this.key);
    }
    
    public void setKey(String key) {
    	this.key = key;
    }

    public String getSecret() {
    	return(this.secret);
    }
    
    public void setSecret(String secret) {
    	this.secret = secret;
    }
    
}