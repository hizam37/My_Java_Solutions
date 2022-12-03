package ru.parcel.system.bpmn;

import java.util.Collection;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.activiti.cdi.impl.ProcessDeployer;
import org.activiti.engine.ProcessEngine;
import org.itryms.itweb.bpmn.utils.ResourceList;

@Startup
@Singleton
public class ActivitiProcessDeployer {
	private static final String EXTENSION_BPMN = "bpmn";

	private static final String PATH_TO_DIAGRAMS = "diagrams";

	ProcessDeployer processDeployer;
	
	private static Logger log = Logger.getLogger(ActivitiProcessDeployer.class.getName());
	

	public ActivitiProcessDeployer() {}
	
	@Inject
	ActivitiProcessDeployer(ProcessEngine pe) {
		processDeployer = new ProcessDeployer(pe);
	}

	@PostConstruct
	public void init() {
		final Collection<String> list = ResourceList.getListFilesFromResources(PATH_TO_DIAGRAMS, EXTENSION_BPMN);
		deploy(list);
	}
	
	public void deploy(Collection<String> list) {
		log.info("Loading diagrams ...");
		for (String bpmnPath : list) {
			log.info("deploy process "+ bpmnPath + " ...");
			//processDeployer.deployProcess(bpmnPath);
		} 
		
		processDeployer.deployProcess("diagrams/parcelProcess.bpmn");
	}	
}
