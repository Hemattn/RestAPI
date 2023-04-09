package com.rest.api2.demoRestApi2.internationalisation;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class Question1 {
    private MessageSource messageSource;

    public Question1(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @GetMapping("/message")
    public String getMessage() {
        Locale locale=LocaleContextHolder.getLocale();
        return messageSource.getMessage("Good.morning.message",  null, "Default message", locale);
    }
}
