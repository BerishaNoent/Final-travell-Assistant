package com.travelassitant.microservice.hotelsearchservice.pubSub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;

@Configuration
@EnableIntegration
public class PubSubConfig {

    @Autowired
    private PubSubTemplate pubSubTemplate;

    @Bean
    public MessageChannel hotelsearchserviceInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public PubSubInboundChannelAdapter messageChannelAdapter(
            @Qualifier("hotelsearchserviceInputChannel") MessageChannel inputChannel) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate,
                "hotelsearchservice-subscription");
        adapter.setOutputChannel(inputChannel);
        return adapter;
    }

    @Bean
    public PollableChannel hotelResultInputChannel() {
        return new QueueChannel();
    }

    @Bean
    public PubSubInboundChannelAdapter hotelResultAdapter(
            @Qualifier("hotelResultInputChannel") PollableChannel inputChannel) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "HotelError-sub");
        adapter.setOutputChannel(inputChannel);
        return adapter;
    }
}
