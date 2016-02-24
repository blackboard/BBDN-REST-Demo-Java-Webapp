package bbdn.rest.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import bbdn.rest.RestConstants;
import bbdn.rest.RestHandler;
import bbdn.rest.RestRequest;

public class CourseHandler implements RestHandler {

	private static final Logger log = LoggerFactory.getLogger(CourseHandler.class);

	@Override
	public String createObject(String access_token) {
		log.info("CREATE");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH, HttpMethod.POST, access_token, getBody()));
	}

	@Override
	public String readObject(String access_token) {
		log.info("READ");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH + "/externalId:" + RestConstants.COURSE_ID, HttpMethod.GET, access_token, ""));
	}

	@Override
	public String updateObject(String access_token) {
		log.info("UPDATE");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH + "/externalId:" + RestConstants.COURSE_ID, HttpMethod.PATCH, access_token, getBody()));
	}

	@Override
	public String deleteObject(String access_token) {
		log.info("DELETE");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH + "/externalId:" + RestConstants.COURSE_ID, HttpMethod.DELETE, access_token, ""));
	}
	
	private String getBody() {

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode course = objMapper.createObjectNode();
		course.put("externalId", RestConstants.COURSE_ID);
		course.put("dataSourceId", RestConstants.DATASOURCE_ID);
		course.put("courseId", RestConstants.COURSE_ID);
		course.put("name", RestConstants.COURSE_NAME);
		course.put("description", RestConstants.COURSE_DESCRIPTION);
		course.put("allowGuests", "true");
		course.put("readOnly", "false");
		course.put("termId", RestConstants.TERM_ID);
		ObjectNode availability = course.putObject("availability");
		availability.put("duration", "continuous");
		
		String body = "";
		try {
			body = objMapper.writeValueAsString(course);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info(body);

		return(body);
	}
}
