package bbdn.rest.membership;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import bbdn.rest.RestConstants;
import bbdn.rest.RestHandler;
import bbdn.rest.RestRequest;

public class MembershipHandler implements RestHandler {

	private static final Logger log = LoggerFactory.getLogger(MembershipHandler.class);
	
	@Override
	public String createObject(String access_token) {
		log.info("CREATE");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH + "/" + RestConstants.COURSE_ID + "/users", HttpMethod.POST, access_token, getBody()));
	}

	@Override
	public String readObject(String access_token) {
		log.info("READ");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH + "/externalId:" + RestConstants.COURSE_ID + "/users/externalId:"+ RestConstants.USER_ID, HttpMethod.GET, access_token, ""));
	}

	@Override
	public String updateObject(String access_token) {
		log.info("UPDATE");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH + "/externalId:" + RestConstants.COURSE_ID + "/users/externalId:"+ RestConstants.USER_ID, HttpMethod.PATCH, access_token, getBody()));
	}

	@Override
	public String deleteObject(String access_token) {
		log.info("DELETE");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH + "/externalId:" + RestConstants.COURSE_ID + "/users/externalId:"+ RestConstants.USER_ID, HttpMethod.DELETE, access_token, ""));
	}
	
	private String getBody() {
		
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode membership = objMapper.createObjectNode();
		membership.put("dataSourceId", RestConstants.DATASOURCE_ID);
		ObjectNode availability = membership.putObject("availability");
		availability.put("available", "Yes");
		membership.put("courseRoleId", "Instructor");
		
		String body = "";
		try {
			body = objMapper.writeValueAsString(membership);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info(body);

		return(body);
	}
}
