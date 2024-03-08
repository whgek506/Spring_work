package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:spring/db.properties")
public class SpringConfiguration {
	//변수로 지정하여 값을 넣는 방법
	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public BasicDataSource dataSourece() {
		BasicDataSource basicDataSource = new BasicDataSource();
		
		//직접 값을 넣는 방법
//		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		basicDataSource.setUsername("jdbc:mysql://localhost:3306/mydb?serverTimezone=Asia/Seoul");
//		basicDataSource.setUsername("root");
//		basicDataSource.setPassword("1234");
		
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		return basicDataSource;
	}
	

}
