package com.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class Transcript implements JavaDelegate {
  @Override
  public void execute(DelegateExecution execution) {
    System.out.println("Transcript");
  }
}
