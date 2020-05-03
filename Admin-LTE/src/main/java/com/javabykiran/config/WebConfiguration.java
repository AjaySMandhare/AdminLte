package com.javabykiran.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.CacheControl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SuppressWarnings("unused")
@Configuration
@EnableWebMvc
@ComponentScan("com.javabykiran")
@EnableScheduling
@EnableAsync
@EnableAspectJAutoProxy
public class WebConfiguration implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver myresolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/admin/");
		resolver.setSuffix(".jsp");
		return resolver;
	}


	/* public void addResourceHandlers(ResourceHandlerRegistry registry) {
   //  Add css file resource url here
       registry.addResourceHandler("/resources/**").addResourceLocations("/bootsrap/css")
       .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
     }
*/
	
	 /*public void configureViewResolvers(ViewResolverRegistry registry) {
	      registry.jsp("/WEB-INF/pages/admin/", ".jsp");
	      
	   }*/

	  
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {

	      // Register resource handler for CSS and JS
	      registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

	      // Register resource handler for images
	      registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	   }
	


}
