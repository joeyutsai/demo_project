package com.example.demo_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//若在Controller 有這個 @Corss... 需要去除


//@Configuration // 宣告為設定檔，讓SpringBoot託管
//public class WebMvcConfig implements WebMvcConfigurer {
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**") // 對應URIs路徑
//		.allowedOriginPatterns("*") // SpringBoot v2.4 之後使用
//		.allowCredentials(true) // 允許憑證
//		.allowedMethods("POST", "GET") // HTTP method. 多個用逗號(,)分隔 example: "POST", "GET"
//		.allowedHeaders("*");
//	}
//}

//有自定義攔截器(Filter)時用
//若不需要 implements WebMvcConfigurer
@Configuration // 宣告為設定檔，讓SpringBoot託管
public class WebMvcConfig {
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig());
		return new CorsFilter(source);
	}

	private CorsConfiguration corsConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOriginPattern("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.setAllowCredentials(true);
		return corsConfiguration;
	}

}
