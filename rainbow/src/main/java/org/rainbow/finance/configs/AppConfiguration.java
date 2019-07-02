package org.rainbow.finance.configs;

import java.util.Map.Entry;

import javax.mail.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//@Configuration
public class AppConfiguration {

	
	
	/*@Bean
	public MailSession createMailSession() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean jndiContext = new JndiObjectFactoryBean();
		jndiContext.setJndiName("java:/comp/env/mail/rainbow");
		jndiContext.setExpectedType(Session.class);
		jndiContext.setLookupOnStartup(false);
		jndiContext.afterPropertiesSet();
		return new MailSession((Session) jndiContext.getObject());
	}*/

	/*public Session initializeContext() throws Exception {
		Context context = new InitialContext();
		//return (Session) context.lookup("java:/comp/env/mail/rainbow");
		return (Session) new JndiTemplate().lookup("java:comp/env/mail/rainbow");
	}

	@Bean
	public JavaMailSender mailSender() {
		JavaMailSender mailSender = new JavaMailSenderImpl() {
			{
				setSession(null);
			}

			@Override
			public synchronized void setSession(Session session) {
				// TODO Auto-generated method stub
				try {
					Session obj = initializeContext();
					System.out.println("Printing =====================");
					for (Entry<Object, Object> set : obj.getProperties().entrySet()) {
						System.out.println(set.getKey() + " " + set.getValue());
					}
					super.setSession(obj);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};

		return mailSender;
	}*/

}
