package bbdn.rest.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import bbdn.rest.RestConstants;
import bbdn.rest.RestHandler;
import bbdn.rest.RestRequest;

public class CourseHandler implements RestHandler {

	private static final Logger log = LoggerFactory.getLogger(CourseHandler.class);

	@Override
	public String createObject(String access_token) {
		log.debug("CourseHandler::CREATE");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH, HttpMethod.POST, access_token, getBody()));
	}

	@Override
	public String readObject(String access_token) {
		log.debug("CourseHandler::READ");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH + "/" + RestConstants.COURSE_ID, HttpMethod.GET, access_token, ""));
	}

	@Override
	public String updateObject(String access_token) {
		log.debug("CourseHandler::UPDATE");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH + "/" + RestConstants.COURSE_ID, HttpMethod.POST, access_token, getBody()));
	}

	@Override
	public String deleteObject(String access_token) {
		log.debug("CourseHandler::DELETE");
		return(RestRequest.sendRequest(RestConstants.COURSE_PATH + "/" + RestConstants.COURSE_ID, HttpMethod.DELETE, access_token, ""));
	}
	
	private String getBody() {
		/*
		 * {
            "externalId":self.courseExternalId,
            "dataSourceId":self.dskExternalId,
            "courseId":self.courseExternalId,
            "name":"Course used for REST demo",
            "description":"Course used for REST demo",
            "allowGuests":"true",
            "readOnly": "false",
            "termId":self.termExternalId,
            "availability": {
                "duration":"continuous"
            }
		 */
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
		
		log.debug("CourseHandler::getBody:\nobjMapper\n");
		log.debug(objMapper.toString());
		log.debug("\ncourse\n");
		log.debug(course.asText());
		return(objMapper.toString());
	}
}
