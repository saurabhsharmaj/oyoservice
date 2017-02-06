package org.phstudy.sample.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.phstudy.sample.exception.OyoServiceExceptionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;



@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "org.phstudy")
@PropertySource("classpath:application.properties")
@Import({ OyoServiceSecurityConfig.class })
public class OyoServiceConfiguration extends WebMvcConfigurerAdapter{

	private static final String MESSAGE_SOURCE_BASE_NAME = "messages";
			
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setFallbackPageable(new PageRequest(0, 50));
		argumentResolvers.add(resolver);
		super.addArgumentResolvers(argumentResolvers);
	}


	@Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();       
        resolvers.add(viewResolver());  
        resolvers.add(jsonViewResolver());  
        resolver.setViewResolvers(resolvers);
        return resolver;
    }
	
	@Bean
	public ViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}

	@Bean
	TilesViewResolver viewResolver(){
		TilesViewResolver viewResolver = new TilesViewResolver();
		return viewResolver;
	}

	@Bean
	TilesConfigurer tilesConfigurer(){
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("WEB-INF/tiles.xml","WEB-INF/views/**/views.xml");
		tilesConfigurer.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
		return tilesConfigurer;    
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() throws NamingException {    	
		JndiTemplate jndiTemplate = new JndiTemplate();
		DataSource dataSource
		= (DataSource) jndiTemplate.lookup("java:comp/env/jdbc/oyoservice");

		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {     
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);     
		sessionBuilder.scanPackages("org.phstudy.sample");
		sessionBuilder.addProperties(getHibernateProperties());
		return sessionBuilder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return properties;
	}

	@Autowired    
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);     
		return transactionManager;
	}

	/*@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }*/

	/*
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}


	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {    	
    	OyoServiceExceptionResolver simpleMappingExceptionResolver = new OyoServiceExceptionResolver();
        simpleMappingExceptionResolver.setDefaultErrorView("error");
        simpleMappingExceptionResolver.setDefaultStatusCode(500);
        exceptionResolvers.add(simpleMappingExceptionResolver);
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}

	@Bean(name = "multipartResolver")
	public StandardServletMultipartResolver resolver() {
		return new StandardServletMultipartResolver();
	}

	@Bean
	public MessageSource messageSource() {
		String[] baseNames = "messages".split(",");
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasenames(baseNames);
		return resourceBundleMessageSource;
	}

}
