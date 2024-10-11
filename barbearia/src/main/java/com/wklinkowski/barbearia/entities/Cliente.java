package com.wklinkowski.barbearia.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CLIENTES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @NotNull
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 100 caracteres.")
    @Column(name = "nome", nullable = false)
    private String nomeCliente;

    @NotNull
    @Size(min = 2, max = 50, message = "O sobrenome deve ter entre 2 e 100 caracteres")
    @Column(name = "sobrenome", nullable = false)
    private String sobrenomeCliente;

    @NotNull
    @Pattern(regexp = "^\\+55 \\(\\d{2}\\) \\d{5}-\\d{4}$", message = "Número de telefone inválido.")
    @Column(name = "telefone", nullable = false, unique = true)
    private String telefoneCliente;

    @Size(max = 80, message = "O email deve ter no máximo 100 caracteres")
    @Email(message = "E-mail inválido")
    @Column(name = "email", nullable = true, unique = true)
    private String emailCliente;

    @OneToOne(mappedBy = "clienteAgendamento")
    private Agendamento agendamentoCliente;

    public Cliente(String nomeCliente, String sobrenomeCliente, String telefoneCliente, String emailCliente, Agendamento agendamentoCliente) {
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
        this.agendamentoCliente = agendamentoCliente;
    }
}
