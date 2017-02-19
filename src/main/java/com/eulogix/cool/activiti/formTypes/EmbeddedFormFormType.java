package com.eulogix.cool.activiti.formTypes;

import org.activiti.engine.form.*;

public class EmbeddedFormFormType extends AbstractFormType {
 
  public static final String TYPE_NAME = "embeddedForm";
  
  public String getName() {
    return TYPE_NAME;
  }

  @Override
  public Object convertFormValueToModelValue(String propertyValue) {
    return propertyValue;
  }
 
  @Override
  public String convertModelValueToFormValue(Object modelValue) {
    return (String) modelValue;
  }
}