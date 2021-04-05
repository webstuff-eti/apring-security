package eti.br.webstuff.apispringbootaws.entity;

import eti.br.webstuff.apispringbootaws.enums.RequestStateEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "request_stage")
public class RequestStage implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "realization_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date realizationDate;

    @Column(length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStateEnum stateEnum;

    //FIXME: Vários Estágios podem estar associados a um pedido
    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    //FIXME: Um usuários poderá ter vários estágios de pedidos
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
