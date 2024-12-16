package com.onebank.taskmaster.notifier.config;


import com.onebank.taskmaster.config.ConditionalOnDatabaseEnabled;
import com.onebank.taskmaster.notifier.model.NotificationTemplateDetails;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "task-master.channel.email")
@ConditionalOnDatabaseEnabled
@Getter
@Setter
public class NotificationTemplateConfig {
	private List<NotificationTemplateDetails> templates;
}
