package com.example.BootMybatisTilesV3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"naver.cloud","controller.*","*.member","data.*","tiles.config","com.example.BootMybatisTilesV3"})
@MapperScan("data.mapper")
public class BootMybatisTilesV3Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisTilesV3Application.class, args);
	}

}
