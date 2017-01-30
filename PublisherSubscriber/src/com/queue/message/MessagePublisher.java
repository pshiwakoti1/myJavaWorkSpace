package com.queue.message;


public class MessagePublisher{	
	
	public synchronized void publish(String name, Message message){		
		MessageBoard.getMessageBoard().put(name, message);
		
	}
}
