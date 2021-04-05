package eti.br.webstuff.apispringbootaws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eti.br.webstuff.apispringbootaws.enums.RequestStateEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "request")
public class Request implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String subject;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStateEnum stateEnum;

    //FIXME: Vários pedidos para um usuário
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //FIXME: UM pedido poderá ter vários estágios
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(mappedBy = "request")
    private List<RequestStage> stages = new ArrayList<>();

    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(mappedBy = "request")
    private List<RequestFile> files = new ArrayList<RequestFile>();

}
