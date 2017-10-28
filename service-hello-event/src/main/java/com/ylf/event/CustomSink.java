package com.ylf.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by QianJH on 2017/10/23.
 */
public interface CustomSink {
    String REGISTER = "input_userRegister";
    String LOGIN = "input_userLogin";

    @Input(REGISTER)
    SubscribableChannel register();

    @Input(LOGIN)
    SubscribableChannel login();
}
