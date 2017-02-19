package com.eulogix.cool.bridge;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import org.activiti.engine.delegate.DelegateExecution;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.client.apache.ApacheHttpClient;
import com.sun.jersey.client.apache.config.DefaultApacheHttpClientConfig;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.map.*;

public class serializer {
	
	public Object deserializeBase64String(String b64) {
		return SerializationUtils.deserialize(new ByteArrayInputStream(Base64.decodeBase64(b64.getBytes()))); 
	}
	
	public String toJSON(Object object) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json;
		try {
			json = ow.writeValueAsString(object);
		} catch (Exception e) {
			return "null";
		}
		return json;
	}
}
