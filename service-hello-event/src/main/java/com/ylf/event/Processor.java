package com.ylf.event;

/**
 * @Author YangLF
 * @Date 2017/10/31
 *
 *  Processor 是stream中绑定输入输出的接口，主要用来讲发布者和订阅者绑定到一起
 */
public interface Processor extends CustomSource,CustomSink {
}
