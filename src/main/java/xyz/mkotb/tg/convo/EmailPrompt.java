package xyz.mkotb.tg.convo;

import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;
import pro.zackpollard.telegrambot.api.conversations.prompt.RegexPrompt;

public class EmailPrompt extends RegexPrompt {
    public EmailPrompt() {
        super("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)" +
                "*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)" +
                "+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
    }

    @Override
    protected boolean accept(ConversationContext context, TextContent input) {
        context.setSessionData("email", input.getContent());
        return false;
    }

    @Override
    public SendableMessage promptMessage(ConversationContext context) {
        return SendableTextMessage.builder()
                .message("What's your e-mail?")
                .build();
    }
}