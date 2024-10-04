package com.nam077.spring_advanced.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Arrays;
import java.util.Locale;

@Component
public class CustomLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        Locale locale = Locale.getDefault();

        if (lang != null && !lang.isEmpty()) {
            locale = Locale.forLanguageTag(lang);
        } else {
            String acceptLangHeader = request.getHeader("Accept-Language");
            if (acceptLangHeader != null && !acceptLangHeader.isEmpty()) {
                locale = Locale.lookup(Locale.LanguageRange.parse(acceptLangHeader),
                        Arrays.asList(Locale.getAvailableLocales()));
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // Không hỗ trợ thay đổi locale trong runtime
        // Giữ phương thức này trống để tránh lỗi UnsupportedOperationException
    }
}
