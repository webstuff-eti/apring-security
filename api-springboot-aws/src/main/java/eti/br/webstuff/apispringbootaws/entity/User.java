package eti.br.webstuff.apispringbootaws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import eti.br.webstuff.apispringbootaws.enums.RoleEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "user")
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String name;

    @Column(length = 75, nullable = false, unique = true)
    private String email;

    // FIXME: [receberemos o password na API mas não retornaremos para o cliente]
    // FIXME: Durante a deserialização, O MESMO não é exibido
    @Setter(onMethod = @__({@JsonProperty}))
    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 20)
    private String phone;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    // FIXME: Ignora a serialização do atributo resquests durante a serialização do Objeto "User"
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(mappedBy = "user")
    private List<Request> resquests = new ArrayList<>(); //FIXME: Um usuário poderá ter vários pedidos

    // FIXME: Ignora a serialização do atributo requestStages durante a serialização do Objeto "User"
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(mappedBy = "user")
    private List<RequestStage> requestStages = new ArrayList<>();


}
