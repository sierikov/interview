package tk.artemser.task4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tk.artemser.task4.converter.StringToEnumConverter;
import tk.artemser.task4.interceptor.RequestLoggerInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private RequestLoggerInterceptor requestLoggerInterceptor;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLoggerInterceptor)
                .addPathPatterns("/**");
    }
}
