package com.ylf;

import com.ylf.event.CustomSink;
import com.ylf.event.CustomSource;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.ServiceActivator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 *
 * @EnableBinding注解用于绑定一个或者多个接口作为参数，本文中绑定sink接口来接受消息。
 *
 * @StreamListener注解使方法接受管道推送的消息。      @EnableBinding({CustomSink.class})
 *
 * @InboundChannelAdapter注解用来绑定输出的管道，进行消息推送。本案例就推送格式化的时间。    @EnableBinding({CustomSource.class})
 *
 *
 * @ServiceActivator注解分别绑定输入和输出的管道，两个管道之间消息的传递。     @EnableBinding(Processor.class)
 *
 */
@SpringCloudApplication
@EnableBinding({CustomSink.class})
public class ServiceHelloServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHelloServiceApplication.class, args);
	}


	@StreamListener(Sink.INPUT)
	public void sinkMessage(Object message){
		System.out.println("received message: "+message);
	}



	@InboundChannelAdapter(value = Source.OUTPUT)
	public String timerMessageSource() {
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println("publish message :"+format);
		return format;
	}


	@ServiceActivator(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public Object transform(Object payload) {
		System.out.println("Transformed by "  + ": " + payload);
		return payload;
	}

}
