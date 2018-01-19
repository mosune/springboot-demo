import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EntityScan("com.example.entity") jpa扫描实体类包
@ComponentScan("com.example.*") // 扫描注解
@SpringBootApplication // 启动springboot
@MapperScan("com.example.mapper")
// @EnableJpaRepositories("com.example.repository") 使用jpa
// @EnableScheduling 使用定时任务
public class DemoApplication {

	private static Logger logger = Logger.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Springboot run success");
	}
}
