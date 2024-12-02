package com.onebank.taskmaster.notifier.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.onebank.taskmaster.notifier.repository",
        entityManagerFactoryRef = "notifierEntityManager",
        transactionManagerRef = "notifierTransactionManager"
)
public class PersistenceNotifierConfiguration {

    @Bean
    @ConfigurationProperties(prefix="task-master.datasource.notifier.properties")
    public Properties notifierHibernateProperties() {
        return new Properties();
    }

    @Bean
    @ConfigurationProperties(prefix="task-master.datasource.notifier")
    public DataSource notifierDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean notifierEntityManager(@Qualifier("notifierDataSource") DataSource dataSource, @Qualifier("notifierHibernateProperties") Properties properties) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.onebank.taskmaster.notifier.entity");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager notifierTransactionManager(@Qualifier("notifierEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBean.getObject()));
    }
}
