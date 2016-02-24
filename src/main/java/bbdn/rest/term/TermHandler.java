package bbdn.rest.term;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import bbdn.rest.RestHandler;
import bbdn.rest.RestRequest;
import bbdn.rest.RestConstants;

public class TermHandler implements RestHandler {
	
	private static final Logger log = LoggerFactory.getLogger(TermHandler.class);

	@Override
	public String createObject(String access_token) {
		log.info("CREATE");
		return(RestRequest.sendRequest(RestConstants.TERM_PATH, HttpMethod.POST, access_token, getBody()));
	}

	@Override
	public String readObject(String access_token) {
		log.info("READ");
		return(RestRequest.sendRequest(RestConstants.TERM_PATH + "/externalId:" + RestConstants.TERM_ID, HttpMethod.GET, access_token, ""));
	}

	@Override
	public String updateObject(String access_token) {
		log.info("UPDATE");
		return(RestRequest.sendRequest(RestConstants.TERM_PATH + "/externalId:" + RestConstants.TERM_ID, HttpMethod.POST, access_token, getBody()));
	}

	@Override
	public String deleteObject(String access_token) {
		log.info("DELETE");
		return(RestRequest.sendRequest(RestConstants.TERM_PATH + "/externalId:" + RestConstants.TERM_ID, HttpMethod.DELETE, access_token, ""));
	}
	
	private String getBody() {
		
		/*
		 * 
{
  "externalId": "string",
  "dataSourceId": "string",
  "name": "string",
  "description": "string",
  "availability": {
    "available": "Yes",
    "duration": {
      "type": "Continuous",
      "start": "2016-02-24T19:53:21.448Z",
      "end": "2016-02-24T19:53:21.448Z",
      "daysOfUse": 0
    }
  }
}

{
  "externalId" : "BBDN-TERM-JAVA",
  "dataSourceId" : "BBDN-DSK-JAVA",
  "name" : "REST Demo Term - Java",
  "description" : "Term Used For REST Demo - Java",
  "availability" : {
    "available" : "Yes",
    "duration" : {
      "type" : "continuous"
    }
  }
}
		 */

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode term = objMapper.createObjectNode();
		term.put("externalId", RestConstants.TERM_ID);
		term.put("dataSourceId", RestConstants.DATASOURCE_ID);
		term.put("name", RestConstants.TERM_NAME);
		term.put("description", RestConstants.TERM_DISPLAY);
		ObjectNode availability = term.putObject("availability");
		availability.put("available", "Yes");
		ObjectNode duration = availability.putObject("duration");
		duration.put("type",  "Continuous");
		
		String body = "";
		try {
			body = objMapper.writeValueAsString(term);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info(body);

		return(body);
	}
}
