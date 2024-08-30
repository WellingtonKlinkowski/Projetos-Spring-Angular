package wellington.klinkowski.picpay_simplificado.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * Os nomes dos atríbutos desta classe estão em inglês
 * por causa dos padrões de retorno exigidos nos requests.
 */

@Entity(name = "Transacao")
@Table(name = "TB_TRANSACAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private Usuario payer;

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private Usuario payee;

    private Timestamp horaTransferencia;
}
