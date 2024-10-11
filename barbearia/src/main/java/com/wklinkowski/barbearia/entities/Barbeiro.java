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
@Table(name = "BARBEIROS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBarbeiro;

    @NotNull
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 100 caracteres.")
    @Column(name = "nome", nullable = false)
    private String nomeBarbeiro;

    @NotNull
    @Size(min = 2, max = 50, message = "O sobrenome deve ter entre 2 e 100 caracteres")
    @Column(name = "sobrenome", nullable = false)
    private String sobrenomeBarbeiro;

    @NotNull
    @Pattern(regexp = "^\\+55 \\(\\d{2}\\) \\d{5}-\\d{4}$", message = "Número de telefone inválido.")
    @Column(name = "telefone", nullable = false)
    private String telefoneBarbeiro;

    @Size(max = 80, message = "O email deve ter no máximo 100 caracteres")
    @Email(message = "E-mail inválido")
    @Column(name = "email", nullable = true)
    private String emailBarbeiro;

    @OneToMany
    private Agendamento agendamentoBarbeiro;
}

