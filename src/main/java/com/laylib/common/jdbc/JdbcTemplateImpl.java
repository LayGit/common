package com.laylib.common.jdbc;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class JdbcTemplateImpl extends org.springframework.jdbc.core.JdbcTemplate implements JdbcTemplate {
	private PlatformTransactionManager platformTransactionManager;
    private DefaultTransactionDefinition transactionDefinition;
    private ThreadLocal<TransactionStatus> transcationStatus = new ThreadLocal<TransactionStatus>();
 
    public void beginTranstaion() {
        TransactionStatus tmp = platformTransactionManager.getTransaction(transactionDefinition);
        transcationStatus.set(tmp);
    }
 
    public void commit() {
        TransactionStatus tmp = transcationStatus.get();
        if (tmp == null) {
        	System.out.println("Error:no transcation");
            //throw new Exception("no transcation");
        }
        platformTransactionManager.commit(tmp);
        transcationStatus.remove();
    }
 
    public void rollback() {
        TransactionStatus tmp = transcationStatus.get();
        if (tmp == null) {
        	System.out.println("Error:no transcation");
            //throw new RMSRuntimeException("no transcation");
        }
        platformTransactionManager.rollback(tmp);
        transcationStatus.remove();
 
    }
 
    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        platformTransactionManager = new DataSourceTransactionManager(getDataSource());
 
    }
 
    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }
 
    public DefaultTransactionDefinition getTransactionDefinition() {
        return transactionDefinition;
    }
 
    public ThreadLocal<TransactionStatus> getTranscationStatus() {
        return transcationStatus;
    }
}
