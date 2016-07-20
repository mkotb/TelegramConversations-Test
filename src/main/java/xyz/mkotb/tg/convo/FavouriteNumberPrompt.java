package xyz.mkotb.tg.convo;

import pro.zackpollard.telegrambot.api.chat.message.content.TextContent;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;
import pro.zackpollard.telegrambot.api.conversations.prompt.NumericPrompt;

public class FavouriteNumberPrompt extends NumericPrompt {
    @Override
    protected boolean accept(ConversationContext context, Number input) {
        context.setSessionData("favourite-number", input.intValue());
        return false;
    }

    @Override
    protected SendableMessage invalidInputMessage(ConversationContext context, TextContent input) {
        return SendableTextMessage.builder()
                .message("That's not between 50 and 100! Try again!")
                .build();
    }

    @Override
    protected SendableMessage notNumericMessage(ConversationContext context, TextContent input) {
        return SendableTextMessage.builder()
                .message("That is not a number! Please enter a number")
                .build();
    }

    @Override
    public SendableMessage promptMessage(ConversationContext context) {
        return SendableTextMessage.builder()
                .message("Thanks for the email! What's your favourite number between 50 and 100?")
                .build();
    }

    @Override
    protected boolean validateNumber(ConversationContext context, Number input) {
        return input.intValue() < 100 && input.intValue() > 50;
    }
}