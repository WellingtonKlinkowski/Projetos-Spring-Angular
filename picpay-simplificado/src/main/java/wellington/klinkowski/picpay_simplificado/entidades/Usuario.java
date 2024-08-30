package wellington.klinkowski.picpay_simplificado.entidades;

import jakarta.persistence.*;
import lombok.*;
import wellington.klinkowski.picpay_simplificado.enuns.TipoContaUsuario;

import java.math.BigDecimal;

@Entity(name = "Usuario")
@Table(name = "TB_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompletoUsuario;

    @Column(unique = true)
    private String documentoUsuario;

    @Column(unique = true)
    private String emailUsuario;

    private String senhaUsuario;

    private TipoContaUsuario tipoContaUsuario;

    private BigDecimal saldoUsuario;
}
