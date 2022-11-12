package priv.component;

import cn.hutool.core.text.CharSequenceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Sunny Boy
 */
@Slf4j
@SpringBootApplication
public class Main {
	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);

		Environment environment = applicationContext.getEnvironment();
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("server.port");
		String path = CharSequenceUtil.emptyToDefault(environment.getProperty("server.servlet.context-path"), CharSequenceUtil.EMPTY);
		String name = environment.getProperty("spring.application.name");
		// @formatter:off
		log.info("\n----------------------------------------------------------\n\t" +
			"Application " + name + " is running! Access URLs:\n\t" +
			"Local: \t\t\thttp://localhost:" + port + path + "/\n\t" +
			"External: \t\thttp://" + ip + ":" + port + path + "/\n\t" +
			"Swagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
			"----------------------------------------------------------");
	}
}