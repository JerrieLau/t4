package com.yxtec.t4;

import com.yxtec.t4.model.Score;
import com.yxtec.t4.service.ScoreService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ImportResource(locations = "classpath*:applicationContext.xml")
@EnableTransactionManagement
public class T4Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(T4Application.class, args);

        ScoreService service = context.getBean(ScoreService.class);

        Score score = new Score();
        score.setId(RandomUtils.nextLong(1, 1000));
        score.setSname("bot");
        score.setCourse("Software Development");
        score.setScore(RandomUtils.nextFloat(0, 100));

        service.save(score);

        context.stop();
        context.close();
    }
}
