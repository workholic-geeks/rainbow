package org.rainbow.finance.strategy;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.contracts.reponses.EmailResponse;
import org.rainbow.finance.contracts.strategy.FlowStrategy;
import org.rainbow.finance.contracts.strategy.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * This class will act as strategy factory for flow.
 * 
 * @author Anish Singh
 *
 */

@Configuration
public class FlowStrategyFactory implements FlowStrategy {

	@Autowired
	@Qualifier("emailStrategy")
	private Strategy<EmailResponse, Command> emailStrategy;

	@Override
	public EmailResponse invokeEmailStrategy(Command command) throws Exception {

		return emailStrategy.invokeStrategy(command);
	}

	@Bean
	@Scope("singleton")
	public FlowStrategy getInstance() {
		return new FlowStrategyFactory();
	}

}
