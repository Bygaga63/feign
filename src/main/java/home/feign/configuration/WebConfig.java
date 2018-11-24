package home.feign.configuration;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import home.feign.feign.UserClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Value("${feign.userclient.url}")
    String userClientUrl;
    @Bean
    UserClient userClient(){
        return Feign.builder()
                //.contract определяет какими аннотациями мы будем метить Feign интерфейсы
                .contract(new SpringMvcContract())
                //.encoder и .decoder заставят Feint клент мапить JSON в Java объекты и обратно
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                //.logger и .logLevel - логировать каждый запрос и ответ в System.error
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                //куда шлем request и response
                .target(UserClient.class, userClientUrl);
    }
}
