package com.travelassitant.microservice.usermanagementservice.pubsub;

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
    public MessageChannel flightserviceInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel carRentalserviceInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel recentSearchserviceInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public PollableChannel airportSaveResultInputChannel() {
        return new QueueChannel();
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
    public PubSubInboundChannelAdapter messageChannelAdapterflight(
            @Qualifier("flightserviceInputChannel") MessageChannel inputChannel) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "flight-sub");
        adapter.setOutputChannel(inputChannel);
        return adapter;
    }

    @Bean
    public PubSubInboundChannelAdapter messageChannelAdapterCarRental(
            @Qualifier("carRentalserviceInputChannel") MessageChannel inputChannel) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "carReantal-sub");
        adapter.setOutputChannel(inputChannel);
        return adapter;
    }

    @Bean
    public PubSubInboundChannelAdapter messageChannelAdapterRecentSearch(
            @Qualifier("recentSearchserviceInputChannel") MessageChannel inputChannel) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "RecentSearch-sub");
        adapter.setOutputChannel(inputChannel);
        return adapter;
    }

    @Bean
    public PubSubInboundChannelAdapter airportSaveResultAdapter(
            @Qualifier("airportSaveResultInputChannel") PollableChannel inputChannel) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "AirportError-sub");
        adapter.setOutputChannel(inputChannel);
        return adapter;
    }
}
