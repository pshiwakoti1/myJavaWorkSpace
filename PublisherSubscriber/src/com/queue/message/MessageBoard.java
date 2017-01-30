package com.queue.message;

import java.util.HashMap;
import java.util.Map;

public class MessageBoard {
  private static Map<String, Message> messageBoard = new HashMap<String,Message>();

public static Map<String, Message> getMessageBoard() {
	return messageBoard;
}

public static void setMessageBoard(Map<String, Message> messageBoard) {
	MessageBoard.messageBoard = messageBoard;
}



}
