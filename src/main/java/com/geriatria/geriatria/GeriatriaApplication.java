package com.geriatria.geriatria;

import com.geriatria.geriatria.model.entities.Casa;
import com.geriatria.geriatria.model.entities.Funcionario;
import com.geriatria.geriatria.model.repository.CasaRepository;
import com.geriatria.geriatria.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.geriatria.geriatria.model.entities")  //Scanea o package aonde cria as tabelas do banco de dados model.entities
@SpringBootApplication
public class GeriatriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeriatriaApplication.class, args);
	}

}
