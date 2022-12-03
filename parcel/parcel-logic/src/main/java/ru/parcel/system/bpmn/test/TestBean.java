package ru.parcel.system.bpmn.test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;

@Startup
@Singleton
@DependsOn("ActivitiProcessDeployer")
public class TestBean {
	private static Logger log = Logger.getLogger(TestBean.class.getName());

	@Inject
	private ProcessEngine processEngine;

	@PostConstruct
	protected void init() {
		log.info("Process engine '" + processEngine.getName() + "' is up and running!");
		
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("VAR1", "value1");
		
		runtimeService.startProcessInstanceByKey("myProcess", params);

        System.out.println("start business process!");
	}

}
