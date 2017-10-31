package com.ylf.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author Administrator
 *
 * 发布消息的接口   主要用来绑定管道发布消息
 */
public interface CustomSource {
    String REGISTER = "output_userRegister";
    String LOGIN = "output_userLogin";

    @Output(REGISTER)
    MessageChannel register();

    @Output(LOGIN)
    MessageChannel login();
}
