//package com.yxtec.t4;
//
//import com.atomikos.icatch.jta.UserTransactionManager;
//import com.atomikos.jdbc.AtomikosDataSourceBean;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.transaction.jta.JtaTransactionManager;
//
//import java.util.Properties;
//
///**
// * The type App config.
// *
// * @author :<a href="mailto:liujie@ebnew.com">刘杰</a>
// * @date :2017-05-17 22:39:53
// */
//@Configuration
//public class AppConfig {
//
//    /**
//     * Atomikos data source bean atomikos data source bean.
//     *
//     * @return the atomikos data source bean
//     * @author :<a href="mailto:liujie@ebnew.com">刘杰</a>
//     * @date :2017-05-17 22:39:53
//     */
//    @Bean
//    @Qualifier("ds")
//    public AtomikosDataSourceBean atomikosDataSourceBean() {
//        AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
//        Properties properties = new Properties();
//        properties.setProperty("url", "jdbc:mysql://localhost:3306/test?useUnicode=true");
//        properties.setProperty("user", "root");
//        properties.setProperty("password", "123456");
//        dataSourceBean.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
//        dataSourceBean.setXaProperties(properties);
//        dataSourceBean.setUniqueResourceName("ds1");
//        return dataSourceBean;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(atomikosDataSourceBean());
//    }
//
//    /**
//     * Atomikos transaction imp user transaction manager.
//     *
//     * @return the user transaction manager
//     * @author :<a href="mailto:liujie@ebnew.com">刘杰</a>
//     * @date :2017-05-17 22:39:53
//     */
//    @Bean
//    public UserTransactionManager atomikosTransactionImp() {
//        UserTransactionManager userTransactionManager = new UserTransactionManager();
//        userTransactionManager.setForceShutdown(true);
//        return userTransactionManager;
//    }
//
//
//    /**
//     * Transaction manager jta transaction manager.
//     *
//     * @return the jta transaction manager
//     * @author :<a href="mailto:liujie@ebnew.com">刘杰</a>
//     * @date :2017-05-17 22:39:53
//     */
//    @Bean
//    public JtaTransactionManager transactionManager() {
//        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
//        jtaTransactionManager.setTransactionManager(atomikosTransactionImp());
//        return jtaTransactionManager;
//    }
//
//    @Bean
//    public ActiveMQConnectionFactory activeMQConnectionFactory() {
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
//        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
//        activeMQConnectionFactory.setUserName(ActiveMQConnectionFactory.DEFAULT_USER);
//        activeMQConnectionFactory.setPassword(ActiveMQConnectionFactory.DEFAULT_PASSWORD);
//        return activeMQConnectionFactory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        JmsTemplate jmsTemplate = new JmsTemplate(activeMQConnectionFactory());
//        jmsTemplate.setPubSubDomain(false); //Queue
//        return jmsTemplate;
//    }
//
//
//}
