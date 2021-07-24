package com.springbank.lambdas;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sns.AmazonSNS;
import com.springbank.aws.basics.configurations.AWSProperties;
import com.springbank.aws.basics.configurations.AWSProperties.Services;
import com.springbank.aws.basics.configurations.AWSProperties.Services.SNS;
import com.springbank.aws.basics.configurations.AWSProperties.Services.SNSTopic;
import com.springbank.domains.MessagePayload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SNSPublisher implements Function<MessagePayload, String> {

	@Autowired
	private AmazonSNS amazonSns;
	@Autowired
	private AWSProperties awsProperties;

	@Override
	public String apply(final MessagePayload messagePayload) {
		final Services services = awsProperties.getServices();
		final SNS sns = services.getSns();
		final SNSTopic snsTopic = sns.getSnsTopic();
		final String topicArn = snsTopic.getTopicArn();
		final String subject = sns.getSubject();
		final String message = sns.getMessage();
		amazonSns.publish(topicArn, message, subject);
		log.info("message: {} with subject : {}  is published to topic : {}.", message, subject, topicArn);
		return "message is published successfully";
	}

}
