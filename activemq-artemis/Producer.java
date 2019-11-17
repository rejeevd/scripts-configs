package test;

import org.apache.activemq.artemis.api.core.RoutingType;
import org.apache.activemq.artemis.api.core.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created with IntelliJ IDEA.
 * User: rejeev
 * Date: 2019-11-16
 */
public class Producer extends Thread {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	
	public void run(){
		produce();
	}
	
	public void produce(){
		try {
			ServerLocator serverLocator = ActiveMQClient.createServerLocator("tcp://localhost:61616");
			ClientSessionFactory sessionFactory = serverLocator.createSessionFactory();
			ClientSession session = sessionFactory.createSession();
			ClientProducer producer = session.createProducer("testAddress1");
			ClientMessage message = session.createMessage(true);
			message.getBodyBuffer().writeString("test message 1");
			//session.createQueue("testAddress1", RoutingType.ANYCAST, "testQ1");
			producer.send(message);
		}catch (Exception e){
			logger.error("exception", e);
		}
	}
}
