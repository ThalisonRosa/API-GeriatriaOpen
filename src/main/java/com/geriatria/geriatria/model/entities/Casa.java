package com.geriatria.geriatria.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Properties;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "nome_casa",nullable = false)
    private String nomeCasa;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String CEP;

    @Column(name = "numero_casa",nullable = false)
    private Integer numeroCasa;

    @Column(name ="data_cadastro_casa" ,nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastroCasa;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Funcionario gerente;

    @PrePersist
    public void prePersistDataCadastro(){
        setDataCadastroCasa(LocalDate.now());
    }

}
