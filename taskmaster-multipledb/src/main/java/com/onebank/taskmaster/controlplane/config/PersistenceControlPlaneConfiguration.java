package com.onebank.taskmaster.controlplane.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        basePackages = "com.onebank.taskmaster.controlplane.repository",
        entityManagerFactoryRef = "controlPlaneEntityManager",
        transactionManagerRef = "controlPlaneTransactionManager"
)
public class PersistenceControlPlaneConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties(prefix="task-master.datasource.control-plane.properties")
    public Properties controlPlaneHibernateProperties() {
        return new Properties();
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix="task-master.datasource.control-plane")
    public DataSource controlPlaneDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean controlPlaneEntityManager(@Qualifier("controlPlaneDataSource") DataSource dataSource, @Qualifier("controlPlaneHibernateProperties") Properties properties) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.onebank.taskmaster.controlplane.entity");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(properties);

        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager controlPlaneTransactionManager(@Qualifier("controlPlaneEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBean.getObject()));
    }
}
