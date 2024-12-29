package com.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.runtime.ProcessInstance;

public class App {
    public static void main(String[] args) {
        // Create the process engine
        ProcessEngine processEngine =
                ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration()
                        .buildProcessEngine();

        // Deploy the updated BPMN file
        processEngine
                .getRepositoryService()
                .createDeployment()
                .addClasspathResource("document-processor.bpmn")
                .deploy();

        // Start the process instance
        ProcessInstance processInstance =
                processEngine
                        .getRuntimeService()
                        .startProcessInstanceByKey("Process_0v0eki1");
        processEngine.close();
    }
}
