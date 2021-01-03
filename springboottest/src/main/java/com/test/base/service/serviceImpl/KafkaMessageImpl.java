package com.test.base.service.serviceImpl;

import com.test.base.service.MessageSend;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageImpl implements MessageSend {
    @Override
    public String send(String message) {
        return "kafak";
    }
}
