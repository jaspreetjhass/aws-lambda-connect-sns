package com.springbank.handlers;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.springbank.domains.MessagePayload;

public class MessagePushHandler extends SpringBootRequestHandler<MessagePayload, String> {

}
