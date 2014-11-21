package com.pragma_sc.cool.activiti.tasks;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.client.apache.ApacheHttpClient;
import com.sun.jersey.client.apache.config.DefaultApacheHttpClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;

public class callREST implements JavaDelegate {
 
	private Expression 
		url,
		auth_user,
		auth_password,
		payload,
		var_result_http_code, 
		var_result, 
		var_result_error,
		var_result_duration;
	
	public void execute(DelegateExecution execution) {

		String urlValue = (String) url.getValue(execution);
		String userValue = (String) auth_user.getValue(execution);
		String passValue = (String) auth_password.getValue(execution);
		String payloadValue = (String) payload.getValue(execution);
		String httpCodeValue = (String) var_result_http_code.getValue(execution);
		String resultValue = (String) var_result.getValue(execution);
		String errorValue = (String) var_result_error.getValue(execution);
		String durationValue = (String) var_result_duration.getValue(execution);
		
		//set some defaults
		execution.setVariable(durationValue, "");
        execution.setVariable(httpCodeValue, "");
        execution.setVariable(resultValue, "");
    	execution.setVariable(errorValue, "");
    	
		WebResource webResource =null;
		Client client=null;

      	try {
      		
      		// create an instance of the com.sun.jersey.api.client.Client class
      		client= ApacheHttpClient.create(new DefaultApacheHttpClientConfig());
      		client.addFilter(new HTTPBasicAuthFilter(userValue, passValue));
      		
      		// create a WebResource object, which encapsulates a web resource for the client
      		webResource  = client.resource( urlValue );     			

      		// used for calculating the responseTime
            long startTime = System.currentTimeMillis();
            
            //MultivaluedMapImpl queryParams2 = new MultivaluedMapImpl();
            //queryParams2.add("decode_as_class", "param value");
			//webResource = webResource.queryParams(queryParams2);

			WebResource.Builder builder = webResource.getRequestBuilder();

			ClientResponse response=null;
			
			try {
				response = builder.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, payloadValue);
			}catch(UniformInterfaceException u) {
				response= u.getResponse();
			}
            
			// Get response time
			long responseTime = System.currentTimeMillis() - startTime;
			execution.setVariable(durationValue, Long.toString(responseTime));
			
			// Get status
            int status = response.getStatus();
            execution.setVariable(httpCodeValue, Integer.toString(status));
            
            // Get Response
            String body = response.getEntity(String.class);
            execution.setVariable(resultValue, body);
            
            if(!(status>=200 && status<300)) {
            	execution.setVariable(errorValue, payloadValue.concat( "HTTP ".concat(Integer.toString(status))));	
            }
            
        } catch(Exception e) {
            //throw new KettleException(BaseMessages.getString(PKG, "Rest.Error.CanNotReadURL",data.realUrl), e);
        	execution.setVariable(errorValue, e.getMessage());
        } finally {
	         if(webResource !=null) {
	        	 webResource =null;
	         }
	         if(client!=null) {
	        	 client.destroy();
	         }
        }
	}
	

}