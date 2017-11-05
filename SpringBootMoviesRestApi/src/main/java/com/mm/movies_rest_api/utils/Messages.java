package com.mm.movies_rest_api.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Messages {

    @Autowired
    private MessageSource messageSource;

    /**
     *
     * @param key
     * @return
     */
    public String getMessage(String key) {
        return getMessage(key, Locale.getDefault());
    }

    /**
     *
     * @param key
     * @param params
     * @return
     */
    public String getMessage(String key, Object[] params) {
        return getMessage(key, params, Locale.getDefault());
    }

    /**
     *
     * @param key
     * @param locale
     * @return
     */
    public String getMessage(String key, Locale locale) {
        return getMessage(key, null, locale);
    }

    /**
     *
     * @param key
     * @param params
     * @param locale
     * @return
     */
    public String getMessage(String key, Object[] params, Locale locale) {
        return messageSource.getMessage(key, params, locale);
    }
}
