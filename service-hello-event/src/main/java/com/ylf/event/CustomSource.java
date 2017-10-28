package com.ylf.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 *
 * @author QianJH
 * @date 2017/10/23
 */
public interface CustomSource {
    String REGISTER = "output_userRegister";
    String LOGIN = "output_userLogin";

    @Output(REGISTER)
    MessageChannel register();

    @Output(LOGIN)
    MessageChannel login();
}
