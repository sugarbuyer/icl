package com.icl.icl.core.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.text.ParseException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.icl.icl")
@MapperScan(value = {"com.**.dao", "com.**.mapper"})
@EnableTransactionManagement
public class DefaultConfig extends WebMvcConfigurerAdapter {
    private static final String[] CLASSPATH_RESOURCE_LOCATION = {"classpath:/resources/", "classpath:/static/"};

    @Autowired ApplicationContext applicationContext;
    @Autowired private Environment environment;

    @PostConstruct
    public void init(){
        environment = applicationContext.getEnvironment();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATION);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
    }

    @Bean(destroyMethod = "postDeregister")
    public DataSource readDataSource() throws IOException{
        String driverClassName = environment.getProperty("spring.datasource.driver-class-name");
        String dataSourceUrl = environment.getProperty("spring.datasource.url");
        String userName = environment.getProperty("spring.datasource.username");
        String password = environment.getProperty("spring.datasource.password");
        int maxWait = Integer.parseInt(environment.getProperty("db.read.maxWait"));
        int maxTotal = Integer.valueOf(environment.getProperty("db.read.maxActive"));
        int maxIdle = Integer.valueOf(environment.getProperty("db.read.maxActive"));

        System.out.println("driver class name : " + driverClassName);
        System.out.println("data source url : " + dataSourceUrl);
        System.out.println("database user name : " + userName);
        System.out.println("database password : " + password);
        System.out.println("max wait : " + maxWait);
        System.out.println("max total : " + maxTotal);
        System.out.println("max idle : " + maxIdle);

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setMaxWaitMillis(maxWait);
        dataSource.setMaxTotal(maxTotal);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setValidationQuery("select 1");
        dataSource.setTestWhileIdle(true);

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws URISyntaxException, GeneralSecurityException, ParseException, IOException{
        return new DataSourceTransactionManager(readDataSource());
    }
}
