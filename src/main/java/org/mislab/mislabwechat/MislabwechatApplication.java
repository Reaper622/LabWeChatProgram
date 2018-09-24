package org.mislab.mislabwechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.mislab.mislabwechat.dao")
public class MislabwechatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MislabwechatApplication.class, args);
	}
}
