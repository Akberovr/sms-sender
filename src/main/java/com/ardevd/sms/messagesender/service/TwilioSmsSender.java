package com.ardevd.sms.messagesender.service;

import com.ardevd.sms.messagesender.model.SmsRequest;
import com.ardevd.sms.messagesender.config.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author akberovr (Rovshan Akbarov)
 * created on 2020-07-16
 */

@Service
public class TwilioSmsSender implements SmsSender {


    private final TwilioConfiguration twilioConfiguration;
    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    @Autowired
    TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }


    @Override
    public void initiateSms(SmsRequest smsRequest) {
        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
        String message = smsRequest.getMessage();

        MessageCreator creator = Message.creator(
                to,
                from,
                message
        );

        creator.create();
    }

}
