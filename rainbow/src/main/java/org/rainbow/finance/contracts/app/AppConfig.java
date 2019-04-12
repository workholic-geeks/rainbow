package org.rainbow.finance.contracts.app;

/**
 * This interface will introduce methods for allowing intialization of the app.
 * 
 * @author Anish Singh
 *
 */
public interface AppConfig {

	/**
	 * This method will allow app intialization for custom configuration.
	 */
	public void initConfig();

	/**
	 * This method will destroy the app and release all resources.
	 */
	public void destroy();

}
