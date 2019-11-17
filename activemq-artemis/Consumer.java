package test;

import org.apache.activemq.artemis.api.core.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: rejeev
 * Date: 2019-11-16
 */
public class Consumer extends Thread {
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
	public void run(){
		consume();
	}
	public void consume(){
		try {
			ServerLocator serverLocator = ActiveMQClient.createServerLocator("tcp://localhost:61616");
			ClientSessionFactory sessionFactory = serverLocator.createSessionFactory();
			ClientSession session = sessionFactory.createSession();
			ClientConsumer consumer = session.createConsumer("testQ");
			session.start();
			//ClientMessage message = consumer.receive();
			consumer.setMessageHandler(new MessageHandler());
			//System.out.println("msg=" + message.getBodyBuffer().readString());
			Thread.sleep(1000);
			session.close();
		}catch (Exception e){
			logger.error("exception", e);
		}
	}
}
