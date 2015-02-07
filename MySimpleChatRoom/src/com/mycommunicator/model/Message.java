package com.mycommunicator.model;

public class Message
{
	private Integer id;
	private String senderLogin;
	private String receiverLogin;
	private String messageContent;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSenderLogin() {
		return senderLogin;
	}
	public void setSenderLogin(String senderLogin) {
		this.senderLogin = senderLogin;
	}
	public String getReceiverLogin() {
		return receiverLogin;
	}
	public void setReceiverLogin(String receiverLogin) {
		this.receiverLogin = receiverLogin;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	
}
