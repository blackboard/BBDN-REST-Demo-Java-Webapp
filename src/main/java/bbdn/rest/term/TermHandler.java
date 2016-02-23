package bbdn.rest.term;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import bbdn.rest.RestHandler;
import bbdn.rest.RestRequest;
import bbdn.rest.RestConstants;

public class TermHandler implements RestHandler {
	
	private static final Logger log = LoggerFactory.getLogger(TermHandler.class);

	@Override
	public String createObject(String access_token) {
		log.debug("TermHandler::CREATE");
		return(RestRequest.sendRequest(RestConstants.TERM_PATH, HttpMethod.POST, access_token, getBody()));
	}

	@Override
	public String readObject(String access_token) {
		log.debug("TermHandler::READ");
		return(RestRequest.sendRequest(RestConstants.TERM_PATH + "/" + RestConstants.TERM_ID, HttpMethod.GET, access_token, ""));
	}

	@Override
	public String updateObject(String access_token) {
		log.debug("TermHandler::UPDATE");
		return(RestRequest.sendRequest(RestConstants.TERM_PATH + "/" + RestConstants.TERM_ID, HttpMethod.POST, access_token, getBody()));
	}

	@Override
	public String deleteObject(String access_token) {
		log.debug("TermHandler::DELETE");
		return(RestRequest.sendRequest(RestConstants.TERM_PATH + "/" + RestConstants.TERM_ID, HttpMethod.DELETE, access_token, ""));
	}
	
	private String getBody() {
		/*
		 * {
            "externalId":self.termExternalId,
            "dataSourceId": self.dskExternalId,
            "name":"REST Demo Term",
            "description": {
                "rawText": "Term used for REST demo",
                "displayText": "Term used for REST demo",
            },
            "availability": {
                "duration":"continuous"
            }
		 */
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode term = objMapper.createObjectNode();
		term.put("externalId", RestConstants.TERM_ID);
		term.put("dataSourceId", RestConstants.DATASOURCE_ID);
		term.put("name", RestConstants.TERM_NAME);
		ObjectNode description = term.putObject("description");
		description.put("rawText", RestConstants.TERM_RAW);
		description.put("displayText", RestConstants.TERM_DISPLAY);
		ObjectNode availability = term.putObject("availability");
		availability.put("duration", "continuous");
		
		log.debug("TermHandler::getBody:\nobjMapper\n");
		log.debug(objMapper.toString());
		log.debug("\nterm\n");
		log.debug(term.asText());
		return(objMapper.toString());
	}
}
