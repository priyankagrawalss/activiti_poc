package com.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class MetadataExtraction implements JavaDelegate {
  @Override
  public void execute(DelegateExecution delegateExecution) {
    System.out.println("MetadataExtraction : ");
      delegateExecution.setVariable("documentType", "mp3");
  }
}
