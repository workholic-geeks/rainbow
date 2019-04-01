package org.rainbow.finance.contracts.template;

import java.util.Locale;
import java.util.Map;

public interface TemplateEngine {

	public String processHtmlTemplate(String templateName, Map<String, Object> params, Locale loacle);

}
