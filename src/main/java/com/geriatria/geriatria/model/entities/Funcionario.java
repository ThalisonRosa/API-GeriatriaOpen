package com.geriatria.geriatria.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nomeFuncionario;

    @Column(nullable = false)
    private Integer idadeFuncionario;

    @Column(nullable = false, length = 100)
    private String cpfFuncionario;

    @Column(nullable = false, length = 110)
    private String rgFuncionario;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastroFuncionario;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "id_casa")
    private Casa casa;

    @PrePersist
    public void prePersistDataCadastro(){
        setDataCadastroFuncionario(LocalDate.now());
    }
}
