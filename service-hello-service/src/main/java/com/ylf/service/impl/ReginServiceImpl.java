package com.ylf.service.impl;

import com.ylf.event.CustomSource;
import com.ylf.service.ReginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @Author YangLF
 * @Date 2017/10/31
 */
@Service
public class ReginServiceImpl implements ReginService {

    @Autowired
    private CustomSource customSource;

    @Override
    public String regin() {
        //注册时输出消息
        customSource.register().send(MessageBuilder.withPayload("regin").build());
        return null;
    }
}
