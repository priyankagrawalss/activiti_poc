package org.activiti.example.loan;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class LoanReviewService implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) {
    // Simulate loan review logic here
    System.out.println("Loan Review in process...");

    // Example: setting decision to approve if amount is greater than 10000
    int loanAmount = (int) execution.getVariable("loanAmount");
    if (loanAmount > 10000) {
      execution.setVariable("loanApproved", true);
    } else {
      execution.setVariable("loanApproved", false);
    }
  }
}
