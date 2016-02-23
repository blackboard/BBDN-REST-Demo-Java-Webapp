package bbdn.rest.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import bbdn.rest.RestConstants;
import bbdn.rest.RestHandler;
import bbdn.rest.RestRequest;

public class DatasourceHandler implements RestHandler {

	private static final Logger log = LoggerFactory.getLogger(DatasourceHandler.class);
	
	@Override
	public String createObject(String access_token) {
		log.debug("DatasourceHandler::CREATE");
		return(RestRequest.sendRequest(RestConstants.DATASOURCE_PATH, HttpMethod.POST, access_token, getBody()));
	}

	@Override
	public String readObject(String access_token) {
		log.debug("DatasourceHandler::READ");
		return(RestRequest.sendRequest(RestConstants.DATASOURCE_PATH + "/" + RestConstants.DATASOURCE_ID, HttpMethod.GET, access_token, ""));
	}

	@Override
	public String updateObject(String access_token) {
		log.debug("DatasourceHandler::UPDATE");
		return(RestRequest.sendRequest(RestConstants.DATASOURCE_PATH + "/" + RestConstants.DATASOURCE_ID, HttpMethod.POST, access_token, getBody()));
	}

	@Override
	public String deleteObject(String access_token) {
		log.debug("DatasourceHandler::DELETE");
		return(RestRequest.sendRequest(RestConstants.DATASOURCE_PATH + "/" + RestConstants.DATASOURCE_ID, HttpMethod.DELETE, access_token, ""));
	}
	
	private String getBody() {
		/*
		 * {"description":"Demo Data Source used for REST Python Demo"}
		 */
		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode datasource = objMapper.createObjectNode();
		datasource.put("description", RestConstants.DATASOURCE_DESCRIPTION);
		
		log.debug("DatasourceHandler::getBody:\nobjMapper\n");
		log.debug(objMapper.toString());
		log.debug("\ndatasource\n");
		log.debug(datasource.asText());
		return(objMapper.toString());
	}
}
