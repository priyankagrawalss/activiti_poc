package com.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ReadPDF implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) {
    System.out.println("ReadPDF: " + execution.getVariable("documentType"));
  }
}
