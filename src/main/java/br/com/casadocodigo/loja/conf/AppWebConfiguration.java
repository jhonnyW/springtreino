package br.com.casadocodigo.loja.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.infra.FileSaver;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class, FileSaver.class})
public class AppWebConfiguration {
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
		
	}
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource message = new ReloadableResourceBundleMessageSource();
		message.setBasename("/WEB-INF/messages");
		message.setDefaultEncoding("UTF-8");
		message.setCacheSeconds(1);
		return message;
	}
	@Bean
	public FormattingConversionService mvcConversionService(){
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);
		return conversionService;
		
	}
	@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
		
	}
}
