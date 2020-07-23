package com.ardevd.sms.messagesender.controller;

import com.ardevd.sms.messagesender.model.SmsRequest;
import com.ardevd.sms.messagesender.service.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author akberovr (Rovshan Akbarov)
 * created on 2020-07-16
 */

@RestController
@RequestMapping("api/v1/sms")
public class TwilioController {

    private SmsSender smsSender;

    @Autowired
    public TwilioController(SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    @PostMapping
    public void sendSms(@RequestBody SmsRequest smsRequest) {
        smsSender.initiateSms(smsRequest);
    }

}
