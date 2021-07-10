package com.mrozowski.reporter.queue;

import lombok.RequiredArgsConstructor;


import com.mrozowski.reporter.report.ReportService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnClass(name = "com.rabbitmq.client.ConnectionFactory")
@EnableRabbit
@RequiredArgsConstructor
@EnableConfigurationProperties(QueueProperties.class)
class QueueConfiguration {

  private final QueueProperties properties;
  private final ConnectionFactory connectionFactory;
  private final ReportService reportService;

  @Bean
  public Queue queue() {
    return new Queue(properties.getQueue());
  }

  @Bean
  public TopicExchange exchange() {
    return new TopicExchange(properties.getExchange());
  }

  @Bean
  public Binding binding(Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(properties.getRoutingKey());
  }

  @Bean
  public MessageConverter converter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public AmqpTemplate template() {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(converter());
    return rabbitTemplate;
  }

  @Bean
  ReportMessageListener ReportMessageListener() {
    return new ReportMessageListener(reportService);
  }


}
