package com.ardevd.sms.messagesender.service;

import com.ardevd.sms.messagesender.model.SmsRequest;

public interface SmsSender {
    void initiateSms(SmsRequest smsRequest);
}
