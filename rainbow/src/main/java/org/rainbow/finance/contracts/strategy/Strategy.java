package org.rainbow.finance.contracts.strategy;

import org.rainbow.finance.contracts.command.Command;

public interface Strategy<Response extends Object, StrategyCommand extends Command> {

	public Response invokeStrategy(StrategyCommand command) throws Exception;

}
