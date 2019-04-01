package org.rainbow.finance.template;

import java.util.Locale;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class TemplateEngineFactory implements org.rainbow.finance.contracts.template.TemplateEngine {

	private TemplateEngine templateEngine;

	@Bean("rainbowTemplateEngine")
	@Scope("singleton")
	public org.rainbow.finance.contracts.template.TemplateEngine getInstance() {
		return new TemplateEngineFactory();
	}

	public ITemplateResolver getTemplateResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		return templateResolver;
	}

	@Override
	public String processHtmlTemplate(String templateName, Map<String, Object> params, Locale loacle) {
		return templateEngine().process(templateName, new Context(loacle, params));
	}

	public TemplateEngine templateEngine() {
		if (templateEngine == null) {
			templateEngine = new TemplateEngine();
			templateEngine.setTemplateResolver(this.getTemplateResolver());
		}
		return templateEngine;

	}

}
