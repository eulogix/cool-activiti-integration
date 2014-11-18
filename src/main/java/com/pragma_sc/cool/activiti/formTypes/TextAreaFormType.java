package com.pragma_sc.cool.activiti.formTypes;

import org.activiti.engine.form.*;

public class TextAreaFormType extends AbstractFormType {
 
  public static final String TYPE_NAME = "textarea";
 
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