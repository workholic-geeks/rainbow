package org.rainbow.finance.contracts.strategy;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.contracts.reponses.EmailResponse;

/**
 * This interface will expose flow strategy.
 * 
 * @author Anish Singh
 *
 */
public interface FlowStrategy {

	public EmailResponse invokeEmailStrategy(Command command) throws Exception;

}
