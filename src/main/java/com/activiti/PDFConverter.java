package com.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class PDFConverter implements JavaDelegate {
  @Override
  public void execute(DelegateExecution delegateExecution) {
    System.out.println("PDFConverter +" + delegateExecution.getVariable("documentType"));
  }
}
