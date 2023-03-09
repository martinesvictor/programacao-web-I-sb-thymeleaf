package br.com.ada.programacaowebIsb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "tb_clientes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Obrigatório o preenchimento do CPF")
    @NotBlank(message = "Não pode ser vazio")
    @Size(min = 11, max = 11, message = "CPF deve conter 11 caracteres")
    @Column(unique = true)
    private String cpf;
    private String nome;

}
