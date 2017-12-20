package com.juyoung.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juyoung.persistence.MessageDAO;

public class MessageServiceImpl implements MessageService{
	
	private static final Logger logger =
			LoggerFactory.getLogger(MessageServiceImpl.class);
			
	@Inject
	private MessageDAO mdao;
	
	
	
}
