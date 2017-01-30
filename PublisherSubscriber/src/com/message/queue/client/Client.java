package com.message.queue.client;
import java.util.Date;
import java.util.List;

import com.queue.message.Message;
import com.queue.message.MessageBoard;
import com.queue.message.MessagePublisher;
import com.queue.message.MessageSubscriber;

public class Client {

	public static void main(String[] args) {
		Message message1 = new Message();
		message1.setMessageId("1001");
		message1.setTimeStamp(new Date());
		message1.setMessage("hello1");
		
		Message message2 = new Message();
		message2.setMessageId("1001");
		message2.setTimeStamp(new Date());
		message2.setMessage("hello2");
		
		MessagePublisher msgPublisher = new MessagePublisher();
		MessageSubscriber msgSubscriber = new MessageSubscriber();
		
		msgPublisher.publish("fish1",message1);
		System.out.println("Message published.");
		msgPublisher.publish("fish2",message2);		
		System.out.println("Message published.");
		
		//Message messageReceived2 = msgSubscriber.subscribe("fish1");
		//System.out.println("Message Received: " + messageReceived2.getMessageId() + ":" +
	    //messageReceived2.getMessage() + " :" + messageReceived2.getTimeStamp());
		
		while(MessageBoard.getMessageBoard().entrySet().iterator().hasNext()){
			List<Message> messageReceived =  msgSubscriber.subscribe("fish2","1001");			
			for(Message m: messageReceived){
			System.out.println("Message Received: " + m.getMessageId() + ":" + m.getMessage() + " :" + m.getTimeStamp());			
			
			}
			
		}
		
	}

}
