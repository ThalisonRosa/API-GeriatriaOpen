package com.geriatria.geriatria.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import net.bytebuddy.asm.Advice;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data//@Getter@Setter Lombock gera getter e setter a @Data cria getter setter e construtor
@NoArgsConstructor
@AllArgsConstructor
public class Idoso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_idoso",nullable = false, length = 100)
    private String nomeIdoso;

    @Column(name = "idade_idoso",nullable = false,length =3)
    private Integer idadeIdoso;

    @Column(name = "cpf_idoso",nullable = false, length = 100)
    @CPF
    private String cpfIdoso;

    @Column(name = "rg_idoso",nullable = false, length = 11)
    private String rgIdoso;

    @Column(name = "data_de_cadastro" , updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeCadastroIdoso;

    @OneToOne   //Faz o realacionamento 1 pra 1 e faz o relacionamento de tabela estrangeira
    @JoinColumn(name = "id_casa")
    private Casa casa;

    @PrePersist
    public void prePersistDataCadastroIdoso(){
        setDataDeCadastroIdoso(LocalDate.now());
    }




}
