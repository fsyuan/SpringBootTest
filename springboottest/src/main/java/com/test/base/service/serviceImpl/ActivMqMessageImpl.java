package com.test.base.service.serviceImpl;

import com.test.base.service.MessageSend;

public class ActivMqMessageImpl implements MessageSend {
    @Override
    public String send(String message) {
        return "MQ";
    }
}
