package com.ylf.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Administrator
 *
 *  接收消息的接口  主要用来绑定管道接受消息
 */
public interface CustomSink {
    String REGISTER = "input_userRegister";
    String LOGIN = "input_userLogin";

    @Input(REGISTER)
    SubscribableChannel register();

    @Input(LOGIN)
    SubscribableChannel login();
}
