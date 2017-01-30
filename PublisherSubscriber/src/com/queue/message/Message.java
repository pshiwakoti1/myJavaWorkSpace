package com.queue.message;
import java.util.Date;

public class Message {

	private String messageId;
	private String message;
	private Date timeStamp;
	
	public Message(){
		
	}
	public Message(String id, String message, Date timeStamp){
		this.message=message;
		this.setMessageId(id);
		this.timeStamp=timeStamp;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
}
