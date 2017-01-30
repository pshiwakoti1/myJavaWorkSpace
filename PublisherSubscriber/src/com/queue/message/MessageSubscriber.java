package com.queue.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MessageSubscriber {

	public synchronized Message subscribe(String name){	
		if( MessageBoard.getMessageBoard().get(name) != null){
			return MessageBoard.getMessageBoard().get(name);
		}
		else
		{
			return new Message("-1","No Message", new Date());
		}
	}
	
	public synchronized List<Message> subscribe(String name, String id){	
		List<Message> messageList = new ArrayList<Message>();
		Iterator<Entry<String, Message>> it = MessageBoard.getMessageBoard().entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, Message> pair = (Map.Entry)it.next();
	        if(pair.getKey().equals(name)){	        	
	        	Message myMap= MessageBoard.getMessageBoard().get(pair.getKey());
	        	if(myMap.getMessageId() == id)
	        	 messageList.add(myMap);	        	
	        	}
	        it.remove(); 
	    }
	    return messageList;
	   }
	
}
