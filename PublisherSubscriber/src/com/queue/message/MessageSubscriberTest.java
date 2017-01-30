package com.queue.message;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
//Junit test
public class MessageSubscriberTest {

	
	@Test
	public final void test() {
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
		msgPublisher.publish("fish2",message2);
		
		
		Message messageReceived2 = msgSubscriber.subscribe("fish1");
		Message actualMessage = new Message("1001" ,"hello1", new Date());
	    assertEquals(actualMessage,messageReceived2);
	    //this test case always fails because timestamp are different for each messages
	}

}
