package com.laylib.common.easemob.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.laylib.common.easemob.type.MessageType;
public abstract class Notify {
	private static final long serialVersionUID = -7191320079281358428L;
	
	@JSONField(name = "type")
	private MessageType messageType;

	public Notify(MessageType messageType) {
		this.messageType = messageType;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
}
