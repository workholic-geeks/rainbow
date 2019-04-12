package org.rainbow.finance.listener;

import org.rainbow.finance.contracts.app.AppConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * This listener will start custom initialization of app.
 * 
 * @author Anish Singh
 *
 */
@Component
public class ApplicationInitListener implements ApplicationContextAware {

	@Autowired
	private AppConfig config;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		config.initConfig();
	}

}
