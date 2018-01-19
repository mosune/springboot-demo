package com.example.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileName: TimeTask
 *
 * @author gcg
 * @create 2017/12/11 10:01
 * Description: schedule test demo
 * History:
 **/
@Component
public class TimeTask {

    private Logger logger = LoggerFactory.getLogger(TimeTask.class);

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void showCurrentTime() {
        logger.info("现在时间:{}", simpleDateFormat.format(new Date()));
    }

}
