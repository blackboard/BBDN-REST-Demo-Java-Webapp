package bbdn.rest.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import bbdn.rest.RestConstants;
import bbdn.rest.RestHandler;
import bbdn.rest.RestRequest;

public class UserHandler implements RestHandler {

	private static final Logger log = LoggerFactory.getLogger(UserHandler.class);
	
	@Override
	public String createObject(String access_token) {
		log.info("CREATE");
		return(RestRequest.sendRequest(RestConstants.USER_PATH, HttpMethod.POST, access_token, getBody()));
	}

	@Override
	public String readObject(String access_token) {
		log.info("READ");
		return(RestRequest.sendRequest(RestConstants.USER_PATH + "/externalId:" + RestConstants.USER_ID, HttpMethod.GET, access_token, ""));
	}

	@Override
	public String updateObject(String access_token) {
		log.info("UPDATE");
		return(RestRequest.sendRequest(RestConstants.USER_PATH + "/externalId:" + RestConstants.USER_ID, HttpMethod.PATCH, access_token, getBody()));
	}

	@Override
	public String deleteObject(String access_token) {
		log.info("DELETE");
		return(RestRequest.sendRequest(RestConstants.USER_PATH + "/externalId:" + RestConstants.USER_ID, HttpMethod.DELETE, access_token, ""));
	}
	
	private String getBody() {
		
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode user = objMapper.createObjectNode();
		user.put("externalId", RestConstants.USER_ID);
		user.put("dataSourceId", RestConstants.DATASOURCE_ID);
		user.put("userName", RestConstants.USER_NAME);
		user.put("password", RestConstants.USER_PASS);
		ObjectNode availability = user.putObject("availability");
		availability.put("available", "Yes");
		ObjectNode name = user.putObject("name");
		name.put("given", RestConstants.USER_FIRST);
		name.put("family", RestConstants.USER_LAST);
		ObjectNode contact = user.putObject("contact");
		contact.put("email", RestConstants.USER_EMAIL);
		
		String body = "";
		try {
			body = objMapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info(body);

		return(body);
	}
}
