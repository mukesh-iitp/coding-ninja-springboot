package com.example.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.website.domain.SupportUserMessage;
import com.example.website.domain.UserMessage;

@Service
public class UserMessageService implements MessageService{
	
	@Autowired
	UserMessage userMessage;

	@Override
	public String createMessage(int userID) {
		userMessage.setUserID(userID);
		SupportUserMessage supportUserMessage = (SupportUserMessage)userMessage;
		return supportUserMessage.getMessage();
	}

}
