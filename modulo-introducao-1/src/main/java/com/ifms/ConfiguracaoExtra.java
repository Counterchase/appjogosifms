package com.ifms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoExtra {
	@Bean(name= "nameAplication")
	public String nomeDaAplicao() {
		return "Bean";
	}
}
