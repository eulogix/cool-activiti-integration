package com.pragma_sc.cool.activiti.formTypes;

import org.activiti.engine.form.*;

import java.util.HashMap;

import org.codehaus.jackson.map.ObjectMapper;


public class JsonFormType extends AbstractFormType {
 
  public static final String TYPE_NAME = "json";
 
  public String getName() {
    return TYPE_NAME;
  }
 
  @Override
  public Object convertFormValueToModelValue(String propertyValue) {
   
    HashMap<String, Object> result;
	try {
		result = new ObjectMapper().readValue(propertyValue, HashMap.class);
		return result;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
    return propertyValue;
  }
 
  @Override
  public String convertModelValueToFormValue(Object modelValue) {
	
	try {
		String result = new ObjectMapper().writeValueAsString(modelValue);
		return result;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return (String) modelValue;
  }
  
}