package com.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class LayoutParser implements JavaDelegate {
  @Override
  public void execute(DelegateExecution delegateExecution) {
    System.out.println("LayoutParser");
  }
}