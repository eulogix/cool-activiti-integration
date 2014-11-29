package com.pragma_sc.cool.activiti.tasks;

import java.util.HashMap;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.client.apache.ApacheHttpClient;
import com.sun.jersey.client.apache.config.DefaultApacheHttpClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;

public class callAPI implements JavaDelegate {
 
	private Expression url, payload, var_result;
	
	public void execute(DelegateExecution execution) {

		@SuppressWarnings("unchecked")
		HashMap<String, Object> coolEnv = (HashMap<String, Object>) execution.getVariable("_cool");
		
		String baseUrl = (String) coolEnv.get("base_url");
		String userName = (String) coolEnv.get("username");
		String password = (String) coolEnv.get("password");
		
		String urlValue = (String) url.getValue(execution);
		String payloadValue = (String) payload.getValue(execution);
		String resultValue = (String) var_result.getValue(execution);
		
		String serviceUrl = baseUrl.concat(urlValue);
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		WebResource webResource =null;
		Client client=null;

      	try {
      		
      		// create an instance of the com.sun.jersey.api.client.Client class
      		client= ApacheHttpClient.create(new DefaultApacheHttpClientConfig());
      		client.addFilter(new HTTPBasicAuthFilter(userName, password));
      		
      		// create a WebResource object, which encapsulates a web resource for the client
      		webResource  = client.resource( serviceUrl );     			

      		// used for calculating the responseTime
            long startTime = System.currentTimeMillis();
            
			WebResource.Builder builder = webResource.getRequestBuilder();

			ClientResponse response=null;
			
			try {
				response = builder.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, payloadValue);
			}catch(UniformInterfaceException u) {
				response= u.getResponse();
			}
            
			// Get response time
			long responseTime = System.currentTimeMillis() - startTime;
			result.put("responseTime", responseTime);
			
			// Get status
            int status = response.getStatus();
            result.put("responseHttpCode", status);
            
            // Get Response
            String body = response.getEntity(String.class);
            result.put("responseBody", body);
            
            HashMap<String, Object> resultData;
        	try {
        		resultData = new ObjectMapper().readValue(body, HashMap.class);
        	} catch (Exception e) {
        		resultData = new HashMap<String, Object>();
        	}
        	result.put("data", resultData);
            
            if(!(status>=200 && status<300)) {
            	result.put("errorCode", status);
            	result.put("success", false);
            } else result.put("success", true);
            
        } catch(Exception e) {
        	result.put("success", false);
        	result.put("exception", e.getMessage());
        } finally {
	         if(webResource !=null) {
	        	 webResource =null;
	         }
	         if(client!=null) {
	        	 client.destroy();
	         }
        }
      	
      	execution.setVariable(resultValue, result);
      	
	}
	

}