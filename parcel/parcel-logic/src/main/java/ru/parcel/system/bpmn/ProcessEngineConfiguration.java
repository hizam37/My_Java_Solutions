package ru.parcel.system.bpmn;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

import org.activiti.cdi.CdiJtaProcessEngineConfiguration;
import org.activiti.cdi.spi.ProcessEngineLookup;
import org.activiti.engine.ProcessEngine;

public class ProcessEngineConfiguration implements org.activiti.cdi.spi.ProcessEngineLookup {

	private static final String JNDI_NAME_DS = "java:jboss/datasources/ParcelLogicDS";
	private static final String PROCESS_ENGINE_NAME_DEFAULT = "default";
	private ProcessEngine processEngine;

	public int getPrecedence() {
		return 10;
	}

	private TransactionManager lookupTransactionManager() {
		return new ActivitiTransactionManager();
	}

	public ProcessEngine getProcessEngine() {
		CdiJtaProcessEngineConfiguration processEngineConfiguration = new CdiJtaProcessEngineConfiguration();
		processEngineConfiguration.setProcessEngineName(PROCESS_ENGINE_NAME_DEFAULT);
		processEngineConfiguration.setDataSourceJndiName(JNDI_NAME_DS);
		processEngineConfiguration.setTransactionManager(lookupTransactionManager());
        
		processEngineConfiguration.setDatabaseSchemaUpdate(org.activiti.engine.ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);
//        processEngineConfiguration.setDatabaseSchemaUpdate(org.activiti.engine.ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		
        processEngineConfiguration.setTransactionsExternallyManaged(true);
		
		//processEngineConfiguration.setJobExecutorActivate(true);
		processEngine = processEngineConfiguration.buildProcessEngine();
		return processEngine;
	}

	public void ungetProcessEngine() {
		processEngine.close();
		processEngine = null;
	}

	public static class ActivitiTransactionManager implements TransactionManager {

		private TransactionManager tm;

		public ActivitiTransactionManager() {
			try {
				tm = InitialContext.doLookup("java:/TransactionManager");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void begin() throws NotSupportedException, SystemException {
			Transaction tr = tm.getTransaction();

			if (tr == null || tr.getStatus() == Status.STATUS_NO_TRANSACTION)
				tm.begin();
		}

		@Override
		public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException,
				SecurityException, IllegalStateException, SystemException {
			tm.commit();
		}

		@Override
		public void rollback() throws IllegalStateException, SecurityException, SystemException {
			tm.rollback();
		}

		@Override
		public void setRollbackOnly() throws IllegalStateException, SystemException {
			tm.setRollbackOnly();
		}

		@Override
		public int getStatus() throws SystemException {
			return tm.getStatus();
		}

		@Override
		public Transaction getTransaction() throws SystemException {
			return tm.getTransaction();
		}

		@Override
		public void setTransactionTimeout(int seconds) throws SystemException {
			tm.setTransactionTimeout(seconds);
		}

		@Override
		public Transaction suspend() throws SystemException {
			return tm.suspend();
		}

		@Override
		public void resume(Transaction tobj)
				throws InvalidTransactionException, IllegalStateException, SystemException {
			tm.resume(tobj);
		}
	}
}