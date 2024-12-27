package org.activiti.example.loan;

import java.util.HashMap;
import java.util.Map;
import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class LoanApprovalProcess {
    public static void main(String[] args) {
        // 1. Initialize the Process Engine
        ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration()
                .buildProcessEngine();

        // 2. Deploy the BPMN Model
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment()
                .addClasspathResource("loanApproval.bpmn20.xml")
                .deploy();

        // 3. Start the Process Instance
        Map<String, Object> variables = new HashMap<>();
        variables.put("loanAmount", 15000);  // Example loan amount
        variables.put("applicant", "John Doe");
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("loanApprovalProcess", variables);

        // 4. Handle User Task: Submit Loan Request
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery().taskAssignee("applicant").singleResult();
        System.out.println("Task for applicant: " + task.getName());
        taskService.complete(task.getId(), variables); // Complete the loan submission task

        // 5. Service Task: Loan Review (Automatically handled by LoanReviewService)

        // 6. Handle Decision: Approve or Reject
        boolean loanApproved = (boolean) processEngine.getRuntimeService().getVariable(processInstance.getId(), "loanApproved");
        if (loanApproved) {
            task = taskService.createTaskQuery().taskAssignee("manager").singleResult();
            System.out.println("Task for manager: " + task.getName());
            taskService.complete(task.getId()); // Complete manager's approval task
        }

        // 7. End the Process
        System.out.println("Loan approval process completed.");
        processEngine.close();
    }
}
