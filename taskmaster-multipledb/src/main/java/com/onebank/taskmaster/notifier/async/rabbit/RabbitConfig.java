package com.onebank.taskmaster.notifier.async.rabbit;

import com.onebank.taskmaster.notifier.async.ConditionalOnRabbitEnabled;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnRabbitEnabled
public class RabbitConfig {
}
