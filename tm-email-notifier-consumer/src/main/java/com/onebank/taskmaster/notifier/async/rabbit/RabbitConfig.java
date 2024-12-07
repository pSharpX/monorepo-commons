package com.onebank.taskmaster.notifier.async.rabbit;

import com.onebank.taskmaster.notifier.config.ConditionalOnRabbitEnabled;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnRabbitEnabled
public class RabbitConfig {
}
