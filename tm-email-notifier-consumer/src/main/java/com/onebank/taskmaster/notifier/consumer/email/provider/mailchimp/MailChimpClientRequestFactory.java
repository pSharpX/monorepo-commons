package com.onebank.taskmaster.notifier.consumer.email.provider.mailchimp;

import com.onebank.taskmaster.notifier.consumer.email.config.ConditionalOnMailChimpEnabled;
import com.onebank.taskmaster.notifier.consumer.model.mailchimp.GlobalMergeVar;
import com.onebank.taskmaster.notifier.consumer.model.mailchimp.Message;
import com.onebank.taskmaster.notifier.consumer.model.mailchimp.SendMessageWithTemplateRequest;
import com.onebank.taskmaster.notifier.consumer.model.mailchimp.To;
import com.onebank.taskmaster.notifier.model.senders.EmailNotificationMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
@RequiredArgsConstructor
@ConditionalOnMailChimpEnabled
public class MailChimpClientRequestFactory {
    @Qualifier("mailchimpProperties")
    private final Properties config;

    public SendMessageWithTemplateRequest build(EmailNotificationMessage notificationMessage) {
        SendMessageWithTemplateRequest mailChimpRequest = new SendMessageWithTemplateRequest();
        mailChimpRequest.setTemplateName("template-test");

        Message message = this.buildMessage(notificationMessage);

        mailChimpRequest.setMessage(message);
        return mailChimpRequest;
    }

    private Message buildMessage(EmailNotificationMessage notificationDto) {
        List<To> toList = this.buildToList(notificationDto);

        Message message = new Message();
        message.setFromEmail(config.getProperty("from.email"));
        message.setFromName(config.getProperty("from.name"));
        message.setTo(toList);
        message.setMergeLanguage(config.getProperty("config.mergeLanguage"));
        message.setGlobalMergeVars(this.buildGlobalMergeVars(notificationDto));
        return message;
    }

    private List<GlobalMergeVar> buildGlobalMergeVars(EmailNotificationMessage notificationDto) {
        List<GlobalMergeVar> globalMergeVarList = new ArrayList<>();
        for (Map.Entry<String, String> text : notificationDto.getVars().entrySet()) {
            GlobalMergeVar globalMergeVar = new GlobalMergeVar();
            globalMergeVar.setName(text.getKey());
            globalMergeVar.setContent(text.getValue());
            globalMergeVarList.add(globalMergeVar);
        }
        return globalMergeVarList;
    }

    private List<To> buildToList(EmailNotificationMessage notificationDto) {
        To to = new To();
        to.setName(notificationDto.getRecipientName());
        to.setEmail(notificationDto.getRecipientEmail());

        return List.of(to);
    }
}
