package test;

import org.apache.activemq.artemis.api.core.client.ClientMessage;

/**
 * Created with IntelliJ IDEA.
 * User: rejeev
 * Date: 2019-11-16
 */
public class MessageHandler implements org.apache.activemq.artemis.api.core.client.MessageHandler {
	@Override
	public void onMessage(ClientMessage message) {
		System.out.println("mes=" + message.getBodyBuffer().readString());
	}
}
